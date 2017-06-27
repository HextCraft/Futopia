package net.thegaminghuskymc.futopia.blocks.decorativeBlocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;

public class BlockDecorationBase extends BlockBase {

    public BlockDecorationBase(String blockName) {
        super(Material.ROCK, blockName, true);
        setCreativeTab(FTCreativeTabs.main);
        setSoundType(SoundType.METAL);
    }

}