package net.thegaminghuskymc.futopia.blocks.decorativeBlocks;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.thegaminghuskymc.futopia.Reference;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;

public class BlockMarblePillar extends BlockPillarBase {

    public BlockMarblePillar() {
        super(Reference.MODID, "marble", FTCreativeTabs.main, Material.ROCK, MapColor.SNOW);
    }

}
