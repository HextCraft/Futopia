package net.thegaminghuskymc.futopia.items.itemblocks;

import cofh.core.block.ItemBlockCore;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ItemBlockRefinery extends ItemBlockCore {

    public ItemBlockRefinery(Block block) {

        super(block);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "tile.refinery.name";
    }

}
