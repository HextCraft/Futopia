package net.thegaminghuskymc.futopia.items.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.futopia.blocks.decorativeBlocks.concrete.BlockConcrete;
import net.thegaminghuskymc.futopia.utils.ItemHelper;

public class ItemBlockConcrete extends ItemBlockCore {

    public ItemBlockConcrete(Block block) {

        super(block);
        setHasSubtypes(true);
        setMaxDamage(0);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {

        return "tile.concrete_test." + BlockConcrete.Type.byMetadata(ItemHelper.getItemDamage(stack)).getName() + ".name";
    }

}