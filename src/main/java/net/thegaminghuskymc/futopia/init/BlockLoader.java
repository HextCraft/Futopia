package net.thegaminghuskymc.futopia.init;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.blocks.test.misc.BlockCompressor;
import net.thegaminghuskymc.futopia.blocks.test.misc.BlockEngine;
import net.thegaminghuskymc.futopia.blocks.test.misc.BlockPipe;
import net.thegaminghuskymc.futopia.blocks.test.misc.BlockPlatingPress;
import net.thegaminghuskymc.futopia.blocks.test.misc.BlockRefinery;

@GameRegistry.ObjectHolder(value = Refs.MODID)
public class BlockLoader {

	public static BlockEngine engine;
    public static BlockRefinery refinery;
    public static BlockPlatingPress platingPress;
    public static BlockCompressor compressor;
    public static BlockPipe bakedModelBlock;

    public static void loadBlocks() {
        engine = new BlockEngine();
        refinery = new BlockRefinery();
        platingPress = new BlockPlatingPress();
        compressor = new BlockCompressor();
//        bakedModelBlock = new BlockPipe();
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        engine.initModel();
        refinery.initModel();
        platingPress.initModel();
        compressor.initModel();
//        bakedModelBlock.initModel();
    }

    @SideOnly(Side.CLIENT)
    public static void initItemModels() {
//        bakedModelBlock.initItemModel();
    }
    
}
