package cofh.core.item.tool;

import javax.annotation.Nullable;

import cofh.lib.util.helpers.ItemHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFishingRodCore extends ItemFishingRod {

	protected String repairIngot = "";
	protected ToolMaterial toolMaterial;

	protected int luckModifier = 0;
	protected int speedModifier = 0;

	protected boolean showInCreative = true;

	public ItemFishingRodCore(ToolMaterial toolMaterial) {

		this.toolMaterial = toolMaterial;
		setMaxStackSize(1);
		setMaxDamage(toolMaterial.getMaxUses() + 5);

		addPropertyOverride(new ResourceLocation("cast"), new IItemPropertyGetter() {
			@SideOnly (Side.CLIENT)
			public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {

				return entityIn == null ? 0.0F : (entityIn.getHeldItemMainhand() == stack && entityIn instanceof EntityPlayer && ((EntityPlayer) entityIn).fishEntity != null ? 1.0F : 0.0F);
			}
		});
	}

	public ItemFishingRodCore setRepairIngot(String repairIngot) {

		this.repairIngot = repairIngot;
		return this;
	}

	public ItemFishingRodCore setShowInCreative(boolean showInCreative) {

		this.showInCreative = showInCreative;
		return this;
	}

	public ItemFishingRodCore setLuckModifier(int luckModifier) {

		this.luckModifier = luckModifier;
		return this;
	}

	public ItemFishingRodCore setSpeedModifier(int speedModifier) {

		this.speedModifier = speedModifier;
		return this;
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
		if(!isInCreativeTab(tab)){
    		return;
    	}
		if (showInCreative) {
			list.add(new ItemStack(this, 1, 0));
		}
	}

	@Override
	public boolean getIsRepairable(ItemStack itemToRepair, ItemStack stack) {

		return ItemHelper.isOreNameEqual(stack, repairIngot);
	}

	@Override
	public int getItemEnchantability() {

		return toolMaterial.getEnchantability();
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {

		if (player.fishEntity != null) {
			int i = player.fishEntity.handleHookRetraction();
			player.getActiveItemStack().damageItem(i, player);
			player.swingArm(hand);
		} else {
			world.playSound(null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_BOBBER_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

			player.swingArm(hand);
		}
		return new ActionResult<>(EnumActionResult.SUCCESS, player.getActiveItemStack());
	}

}
