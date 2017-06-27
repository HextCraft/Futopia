package net.thegaminghuskymc.futopia.items.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockMarble;
import net.thegaminghuskymc.futopia.utils.ItemHelper;

public class ItemBlockMarble extends ItemBlockCore {

    public ItemBlockMarble(Block block) {

        super(block);
        setHasSubtypes(true);
        setMaxDamage(0);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {

        return "tile.marble." + BlockMarble.Type.byMetadata(ItemHelper.getItemDamage(stack)).getName() + ".name";
    }

}