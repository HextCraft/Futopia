package net.thegaminghuskymc.futopia.items.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockAsphalt;
import net.thegaminghuskymc.futopia.utils.ItemHelper;

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