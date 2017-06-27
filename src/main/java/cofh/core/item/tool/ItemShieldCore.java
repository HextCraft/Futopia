package cofh.core.item.tool;

import javax.annotation.Nullable;

import cofh.lib.util.helpers.ItemHelper;
import net.minecraft.block.BlockDispenser;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemShieldCore extends Item {

	protected String repairIngot = "";
	protected ToolMaterial toolMaterial;

	protected boolean showInCreative = true;

	public ItemShieldCore(ToolMaterial toolMaterial) {

		super();
		this.toolMaterial = toolMaterial;
		setMaxStackSize(1);
		setMaxDamage(toolMaterial.getMaxUses() + 275);

		addPropertyOverride(new ResourceLocation("blocking"), new IItemPropertyGetter() {
			@SideOnly (Side.CLIENT)
			public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {

				return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
			}
		});
		BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(this, ItemArmor.DISPENSER_BEHAVIOR);
	}

	public ItemShieldCore setRepairIngot(String repairIngot) {

		this.repairIngot = repairIngot;
		return this;
	}

	public ItemShieldCore setShowInCreative(boolean showInCreative) {

		this.showInCreative = showInCreative;
		return this;
	}

	public void damageShield(ItemStack stack, int damage, EntityPlayer player, Entity source) {

		stack.damageItem(damage, player);
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
	public int getMaxItemUseDuration(ItemStack stack) {

		return 72000;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {

		playerIn.setActiveHand(hand);
		return new ActionResult(EnumActionResult.SUCCESS, playerIn.getActiveItemStack());
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {

		return EnumAction.BLOCK;
	}

}
