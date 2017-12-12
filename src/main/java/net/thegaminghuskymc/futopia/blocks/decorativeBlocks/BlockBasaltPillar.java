package net.thegaminghuskymc.futopia.blocks.decorativeBlocks;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.thegaminghuskymc.futopia.Reference;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;

public class BlockBasaltPillar extends BlockPillarBase {

    public BlockBasaltPillar() {
        super(Reference.MODID, "basalt", FTCreativeTabs.main, Material.ROCK, MapColor.BLACK);
    }

}
