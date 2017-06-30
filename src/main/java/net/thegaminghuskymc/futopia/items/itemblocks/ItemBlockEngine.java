package net.thegaminghuskymc.futopia.items.itemblocks;

import cofh.core.block.ItemBlockCore;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ItemBlockEngine extends ItemBlockCore {

    public ItemBlockEngine(Block block) {

        super(block);
        setHasSubtypes(false);
        setMaxDamage(0);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "tile.engine.name";
    }

}
