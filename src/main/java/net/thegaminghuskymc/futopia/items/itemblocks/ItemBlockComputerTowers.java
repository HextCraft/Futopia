package net.thegaminghuskymc.futopia.items.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.futopia.network.EnumDyeColor;
import net.thegaminghuskymc.futopia.utils.ItemHelper;

public class ItemBlockComputerTowers extends ItemBlockCore {

	public ItemBlockComputerTowers(Block block) {

		super(block);
		setHasSubtypes(true);
		setMaxDamage(0);
		setRegistryName(block.getRegistryName());
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return "tile.computer_tower." + EnumDyeColor.byMetadata(ItemHelper.getItemDamage(stack)).getName() + ".name";
	}

}