package net.thegaminghuskymc.futopia.items.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.huskylib.blocks.BlockSubBase;

public class ItemBlockBase extends ItemBlock {

	public ItemBlockBase(Block block) {
		super(block);
		this.setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int damage) {
		return damage;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
		if (!isInCreativeTab(tab)) {
			return;
		}
		this.block.getSubBlocks(tab, subItems);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getUnlocalizedName(ItemStack stack) {
		if (this.block instanceof BlockSubBase) {
			if (((BlockSubBase) this.block).getSubNames() != null) {
				return this.getUnlocalizedName() + "." + ((BlockSubBase) this.block).getSubNames()[stack.getMetadata()];
			} else {
				return super.getUnlocalizedName(stack);
			}
		} else {
			return super.getUnlocalizedName(stack);
		}
	}

	/*
	 * @Override
	 * 
	 * @SideOnly(Side.CLIENT) public void addInformation(ItemStack stack,
	 * EntityPlayer player, List<String> tooltip, boolean advanced) {
	 * if(this.block instanceof IShiftDescription){
	 * if(((IShiftDescription)this.block).shouldAddDescription(stack, player)){
	 * if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) ||
	 * Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)){
	 * ((IShiftDescription)this.block).addDescription(stack, player, tooltip); }
	 * else{ String press = TextFormatting.GRAY +
	 * TranslationUtils.translate(ModPrefs.MODID, "tooltip", "press"); String
	 * shift = TextFormatting.YELLOW +
	 * TranslationUtils.translate(ModPrefs.MODID, "tooltip", "shift"); String
	 * info = TextFormatting.GRAY + TranslationUtils.translate(ModPrefs.MODID,
	 * "tooltip", "info"); tooltip.add(press + " " + shift + " " + info); } } }
	 * }
	 */

}
