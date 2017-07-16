package net.thegaminghuskymc.futopia.items.itemblocks;

import cofh.core.block.ItemBlockCore;
import cofh.core.util.helpers.ItemHelper;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockAsphalt;

public class ItemBlockAsphalt extends ItemBlockCore {

	public ItemBlockAsphalt(Block block) {

		super(block);
		setHasSubtypes(true);
		setMaxDamage(0);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {

		return "tile.asphalt." + BlockAsphalt.Type.byMetadata(ItemHelper.getItemDamage(stack)).getName() + ".name";
	}

}