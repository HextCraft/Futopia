package net.thegaminghuskymc.futopia.init;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.blocks.test.misc.BlockCompressor;
import net.thegaminghuskymc.futopia.blocks.test.misc.BlockEngine;
import net.thegaminghuskymc.futopia.blocks.test.misc.BlockPlatingPress;
import net.thegaminghuskymc.futopia.blocks.test.misc.BlockRefinery;
import net.thegaminghuskymc.futopia.client.render.CompressorRenderer;
import net.thegaminghuskymc.futopia.client.render.PlatingPressRenderer;
import net.thegaminghuskymc.futopia.tiles.TileCompressor;
import net.thegaminghuskymc.futopia.tiles.TileEngine;
import net.thegaminghuskymc.futopia.tiles.TilePlatingPress;
import net.thegaminghuskymc.futopia.tiles.TileTank;

public class BlockLoader {

	public static BlockEngine engine;
    public static BlockRefinery refinery;
    public static BlockPlatingPress platingPress;
    public static BlockCompressor compressor;

    public static void loadBlocks() {
        register(engine);
        register(refinery);
        register(platingPress);
        register(compressor);
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        registerModel(engine);
        registerModel(refinery);
        registerModel(platingPress);
        registerModel(compressor);
    }
    
    public static void initTileEntity(){
    	registerTileEntity(TileCompressor.class, compressor);
    	registerTileEntity(TilePlatingPress.class, platingPress);
    	registerTileEntity(TileEngine.class, engine);
    	registerTileEntity(TileTank.class, refinery);
    }
    
    @SideOnly(Side.CLIENT)
    public static void initTesr(){
    	registerTESR(TileCompressor.class, new CompressorRenderer());
    	registerTESR(TilePlatingPress.class, new PlatingPressRenderer());
    }
    
    private static void registerModel(Block block){
    	ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }
    
    private static <T extends TileEntity> void registerTESR(Class<T> te, TileEntitySpecialRenderer<? super T> tesr){
    	ClientRegistry.bindTileEntitySpecialRenderer(te, tesr);
    }
    
    private static void register(Block block){
    	ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }
    
    private static void registerTileEntity(Class<? extends TileEntity> tileClass, Block owner){
        String registryName = owner.getRegistryName().getResourceDomain() + ".tile." + owner.getRegistryName().getResourcePath();
        GameRegistry.registerTileEntity(tileClass, registryName);
    }
    
}
