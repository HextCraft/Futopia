package net.thegaminghuskymc.futopia.blocks.worldgen;

import net.minecraft.block.material.Material;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.huskylib.blocks.BlockSubBase;

public class BlockBaseOre extends BlockSubBase{

    public BlockBaseOre() {
        super("ore", Material.ROCK, FTCreativeTabs.world_gen, EnumMaterialType.toStringArray());
        setHardness(1.6F);
        setHarvestLevel("pickaxe", 2);
        setLightLevel(7F);
    }

}
