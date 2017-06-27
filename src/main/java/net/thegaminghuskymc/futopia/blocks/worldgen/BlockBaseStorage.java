package net.thegaminghuskymc.futopia.blocks.worldgen;

import net.minecraft.block.material.Material;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.huskylib.blocks.BlockSubBase;

public class BlockBaseStorage extends BlockSubBase {

    public BlockBaseStorage() {
        super("storage", Material.IRON, FTCreativeTabs.main, EnumMaterialType.toStringArray());
        setHardness(1.6F);
        setHarvestLevel("pickaxe", 2);
    }

}
