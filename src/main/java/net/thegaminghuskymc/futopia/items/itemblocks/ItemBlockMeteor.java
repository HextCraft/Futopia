package net.thegaminghuskymc.futopia.items.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockMeteor;
import net.thegaminghuskymc.futopia.utils.ItemHelper;

public class ItemBlockMeteor extends ItemBlockCore {

    public ItemBlockMeteor(Block block) {
        super(block);
        setHasSubtypes(true);
        setMaxDamage(0);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "tile.meteor." + BlockMeteor.Type.byMetadata(ItemHelper.getItemDamage(stack)).getName() + ".name";
    }

}