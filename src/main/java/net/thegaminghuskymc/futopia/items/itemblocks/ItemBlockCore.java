package net.thegaminghuskymc.futopia.items.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.huskylib2.lib.utils.StringHelper;

public class ItemBlockCore extends ItemBlock {

	public ItemBlockCore(Block block) {
		super(block);
		setHasSubtypes(true);
		setMaxDamage(0);
		setNoRepair();
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		return StringHelper.localize(getUnlocalizedName(stack));
	}

	@Override
	public int getMetadata(int i) {
		return i;
	}

	@Override
	public boolean isEnchantable(ItemStack stack) {
		return false;
	}

}