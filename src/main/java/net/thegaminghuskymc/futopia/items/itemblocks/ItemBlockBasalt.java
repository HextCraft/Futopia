package net.thegaminghuskymc.futopia.items.itemblocks;

import net.thegaminghuskymc.futopia.utils.ItemHelper;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockBasalt;

public class ItemBlockBasalt extends ItemBlockCore {

    public ItemBlockBasalt(Block block) {

        super(block);
        setHasSubtypes(true);
        setMaxDamage(0);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {

        return "tile.basalt." + BlockBasalt.Type.byMetadata(ItemHelper.getItemDamage(stack)).getName() + ".name";
    }

}