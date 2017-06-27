package net.thegaminghuskymc.futopia.items.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.futopia.network.ClearGlassType;
import net.thegaminghuskymc.futopia.utils.ItemHelper;

public class ItemBlockCrackedGlass extends ItemBlockCore {

    public ItemBlockCrackedGlass(Block block) {

        super(block);
        setHasSubtypes(true);
        setMaxDamage(0);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {

        return "tile.cracked_glass." + ClearGlassType.byMetadata(ItemHelper.getItemDamage(stack)).getName() + ".name";
    }

}
