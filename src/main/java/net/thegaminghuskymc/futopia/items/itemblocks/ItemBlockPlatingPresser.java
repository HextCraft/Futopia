package net.thegaminghuskymc.futopia.items.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ItemBlockPlatingPresser extends ItemBlockCore {

    public ItemBlockPlatingPresser(Block block) {

        super(block);
        setMaxDamage(0);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "tile.plating_presser.name";
    }

}
