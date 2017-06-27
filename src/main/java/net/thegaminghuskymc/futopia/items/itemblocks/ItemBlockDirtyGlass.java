package net.thegaminghuskymc.futopia.items.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.futopia.network.ClearGlassType;
import net.thegaminghuskymc.futopia.utils.ItemHelper;

public class ItemBlockDirtyGlass extends ItemBlockCore {

    public ItemBlockDirtyGlass(Block block) {

        super(block);
        setHasSubtypes(true);
        setMaxDamage(0);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {

        return "tile.dirty_glass." + ClearGlassType.byMetadata(ItemHelper.getItemDamage(stack)).getName() + ".name";
    }

}
