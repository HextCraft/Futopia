package net.thegaminghuskymc.futopia.items.itemblocks;

import cofh.core.block.ItemBlockCore;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ItemBlockCompressor extends ItemBlockCore {

    public ItemBlockCompressor(Block block) {

        super(block);
        setMaxDamage(0);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "tile.compressor.name";
    }

}
