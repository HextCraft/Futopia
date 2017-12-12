package net.thegaminghuskymc.futopia.blocks.decorativeBlocks;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.thegaminghuskymc.futopia.Reference;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;

public class BlockMeteorPillar extends BlockPillarBase {

    public BlockMeteorPillar() {
        super(Reference.MODID, "meteor", FTCreativeTabs.main, Material.ROCK, MapColor.BLUE);
    }

}
