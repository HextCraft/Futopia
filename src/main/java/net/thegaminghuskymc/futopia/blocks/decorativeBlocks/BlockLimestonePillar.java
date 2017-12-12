package net.thegaminghuskymc.futopia.blocks.decorativeBlocks;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.thegaminghuskymc.futopia.Reference;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;

public class BlockLimestonePillar extends BlockPillarBase {

    public BlockLimestonePillar() {
        super(Reference.MODID, "limestone", FTCreativeTabs.main, Material.ROCK, MapColor.SAND);
    }

}
