package net.thegaminghuskymc.futopia.items.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockLimestone;
import net.thegaminghuskymc.futopia.utils.ItemHelper;

public class ItemBlockLimestone extends ItemBlockCore {

    public ItemBlockLimestone(Block block) {
        super(block);
        setHasSubtypes(true);
        setMaxDamage(0);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "tile.limestone." + BlockLimestone.Type.byMetadata(ItemHelper.getItemDamage(stack)).getName() + ".name";
    }

}
