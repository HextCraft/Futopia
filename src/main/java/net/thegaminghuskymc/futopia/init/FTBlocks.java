package net.thegaminghuskymc.futopia.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.model.ModelShulker;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thegaminghuskymc.futopia.blocks.computer.BlockController;
import net.thegaminghuskymc.futopia.blocks.computer.BlockDiskDrive;
import net.thegaminghuskymc.futopia.blocks.computer.BlockMonitor;
import net.thegaminghuskymc.futopia.blocks.computer.BlockProjectTable;
import net.thegaminghuskymc.futopia.blocks.conduits.BlockFluidConduit;
import net.thegaminghuskymc.futopia.blocks.conduits.BlockItemConduit;
import net.thegaminghuskymc.futopia.blocks.conduits.BlockPowerConduit;
import net.thegaminghuskymc.futopia.blocks.machine.BlockAlloyFurnace;
import net.thegaminghuskymc.futopia.blocks.machine.BlockConveyer;
import net.thegaminghuskymc.futopia.blocks.machine.BlockElectricalFurnace;
import net.thegaminghuskymc.futopia.blocks.machine.BlockFilter;
import net.thegaminghuskymc.futopia.blocks.machine.BlockParticleSummoner;
import net.thegaminghuskymc.futopia.blocks.normal.BlockBed;
import net.thegaminghuskymc.futopia.blocks.normal.BlockShulkerBox;
import net.thegaminghuskymc.futopia.blocks.normal.BlockStainedGlass;
import net.thegaminghuskymc.futopia.blocks.normal.BlockStainedGlassPane;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockBaseOres;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockBaseStorage;
import net.thegaminghuskymc.futopia.client.render.TileEntityShulkerBoxRenderer;
import net.thegaminghuskymc.futopia.items.itemblocks.ItemBlockBase;
import net.thegaminghuskymc.futopia.items.itemblocks.ItemBlockShulkerBox;
import net.thegaminghuskymc.futopia.items.itemblocks.ItemBlockStainedGlass;
import net.thegaminghuskymc.futopia.items.itemblocks.ItemBlockStainedGlassPane;
import net.thegaminghuskymc.futopia.network.EnumDyeColor;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.futopia.tiles.TileAlloyFurnace;
import net.thegaminghuskymc.futopia.tiles.TileElectricalFurnace;
import net.thegaminghuskymc.futopia.tiles.TileEntityShulkerBox;
import net.thegaminghuskymc.futopia.tiles.TileProjectTable;
import net.thegaminghuskymc.huskylib.RebornRegistry;

public class FTBlocks {
	
    public static BlockAlloyFurnace alloyfurnace;
    public static BlockConveyer conveyer;
    
    public static BlockItemConduit itemConduit;
    public static BlockPowerConduit powerConduit;
    public static BlockFluidConduit fluidConduit;
    
    public static BlockFilter filter;
    public static BlockElectricalFurnace electricalfurnace;
    public static BlockParticleSummoner particleSummoner;
    
    public static BlockProjectTable projectTable;
    public static BlockDiskDrive diskDrive;
    public static BlockMonitor monitor;
    public static BlockController controller;
    
    public static BlockBaseOres ores;
    public static BlockBaseStorage storages;
    
    public static BlockBed test_bed;
    
    public static Block WHITE_SHULKER_BOX;
    public static Block ORANGE_SHULKER_BOX;
    public static Block MAGENTA_SHULKER_BOX;
    public static Block LIGHT_BLUE_SHULKER_BOX;
    public static Block YELLOW_SHULKER_BOX;
    public static Block LIME_SHULKER_BOX;
    public static Block PINK_SHULKER_BOX;
    public static Block GRAY_SHULKER_BOX;
    public static Block SILVER_SHULKER_BOX;
    public static Block CYAN_SHULKER_BOX;
    public static Block PURPLE_SHULKER_BOX;
    public static Block BLUE_SHULKER_BOX;
    public static Block BROWN_SHULKER_BOX;
    public static Block GREEN_SHULKER_BOX;
    public static Block RED_SHULKER_BOX;
    public static Block BLACK_SHULKER_BOX;
    
    public static BlockStainedGlass stained_glass;
    public static BlockStainedGlassPane stained_glass_pane;

    public static void init(){
    	alloyfurnace = new BlockAlloyFurnace();
    	electricalfurnace = new BlockElectricalFurnace();
    	
    	conveyer = new BlockConveyer();
    	
    	itemConduit = new BlockItemConduit();
    	powerConduit = new BlockPowerConduit();
    	fluidConduit = new BlockFluidConduit();
    	
    	particleSummoner = new BlockParticleSummoner();
    	
    	filter = new BlockFilter();
    	projectTable = new BlockProjectTable();
    	diskDrive = new BlockDiskDrive();
    	monitor = new BlockMonitor();
    	controller = new BlockController();
    	
    	ores = new BlockBaseOres();
    	storages = new BlockBaseStorage();
    	
    	test_bed = new BlockBed();
    	
    	WHITE_SHULKER_BOX = new BlockShulkerBox(EnumDyeColor.WHITE);
    	ORANGE_SHULKER_BOX = new BlockShulkerBox(EnumDyeColor.ORANGE);
    	MAGENTA_SHULKER_BOX = new BlockShulkerBox(EnumDyeColor.MAGENTA);
    	LIGHT_BLUE_SHULKER_BOX = new BlockShulkerBox(EnumDyeColor.LIGHT_BLUE);
    	YELLOW_SHULKER_BOX = new BlockShulkerBox(EnumDyeColor.YELLOW);
    	LIME_SHULKER_BOX = new BlockShulkerBox(EnumDyeColor.LIME);
    	PINK_SHULKER_BOX = new BlockShulkerBox(EnumDyeColor.PINK);
    	GRAY_SHULKER_BOX = new BlockShulkerBox(EnumDyeColor.GRAY);
    	SILVER_SHULKER_BOX = new BlockShulkerBox(EnumDyeColor.SILVER);
    	CYAN_SHULKER_BOX = new BlockShulkerBox(EnumDyeColor.CYAN);
    	PURPLE_SHULKER_BOX = new BlockShulkerBox(EnumDyeColor.PURPLE);
    	BLUE_SHULKER_BOX = new BlockShulkerBox(EnumDyeColor.BLUE);
    	BROWN_SHULKER_BOX = new BlockShulkerBox(EnumDyeColor.BROWN);
    	GREEN_SHULKER_BOX = new BlockShulkerBox(EnumDyeColor.GREEN);
    	RED_SHULKER_BOX = new BlockShulkerBox(EnumDyeColor.RED);
    	BLACK_SHULKER_BOX = new BlockShulkerBox(EnumDyeColor.BLACK);
    	
    	stained_glass = new BlockStainedGlass(Material.GLASS);
    	stained_glass_pane = new BlockStainedGlassPane();
    	
    }
    
    public static void register(){
    	registerBlock(alloyfurnace);
    	registerBlock(electricalfurnace);
    	
    	registerBlock(conveyer);
    	
    	registerBlock(itemConduit);
    	registerBlock(powerConduit);
    	registerBlock(fluidConduit);

    	registerBlock(particleSummoner);
    	
    	registerBlock(filter);
    	registerBlock(projectTable);
        registerBlock(diskDrive);
        registerBlock(monitor);
        registerBlock(controller);
        
        registerSpecialBlock(ores);
        registerSpecialBlock(storages);
        
        registerBlock(test_bed);
        
        registerBlockOnly(WHITE_SHULKER_BOX);
        registerBlockOnly(ORANGE_SHULKER_BOX);
        registerBlockOnly(MAGENTA_SHULKER_BOX);
        registerBlockOnly(LIGHT_BLUE_SHULKER_BOX);
        registerBlockOnly(YELLOW_SHULKER_BOX);
        registerBlockOnly(LIME_SHULKER_BOX);
        registerBlockOnly(PINK_SHULKER_BOX);
        registerBlockOnly(GRAY_SHULKER_BOX);
        registerBlockOnly(SILVER_SHULKER_BOX);
        registerBlockOnly(CYAN_SHULKER_BOX);
        registerBlockOnly(PURPLE_SHULKER_BOX);
        registerBlockOnly(BLUE_SHULKER_BOX);
        registerBlockOnly(BROWN_SHULKER_BOX);
        registerBlockOnly(GREEN_SHULKER_BOX);
        registerBlockOnly(RED_SHULKER_BOX);
        registerBlockOnly(BLACK_SHULKER_BOX);
        
        registerBlockOnly(stained_glass);
        registerBlockOnly(stained_glass_pane);
    }
    
    public static void registerRenders(){
        registerRender(alloyfurnace);
        registerRender(electricalfurnace);
        
        registerRender(conveyer);
        
        registerRender(itemConduit);
        registerRender(powerConduit);
        registerRender(fluidConduit);
        
        registerRender(particleSummoner);
        
        registerRender(filter);
        registerRender(projectTable);
        registerRender(diskDrive);
        registerRender(monitor);
        registerRender(controller);
        
        registerRenderSpecial(ores);
        registerRenderSpecial(storages);
        
        registerRender(test_bed);
        
        registerItemBlocks();
    }
    
    public static void registerBlock(Block block) {
    	ForgeRegistries.BLOCKS.register(block);
    	ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}
    
    public static void registerBlockOnly(Block block){
    	ForgeRegistries.BLOCKS.register(block);
    }
	
	public static void registerRender(Block block) {
		RebornRegistry.registerItemModel(block, 0);
	}
	
	public static void registerSpecialBlock(Block block){
		ForgeRegistries.BLOCKS.register(block);
    	ForgeRegistries.ITEMS.register(new ItemBlockBase(block).setRegistryName(block.getRegistryName()));
	}
	
	public static void registerShulkerBox(Block block){
		ForgeRegistries.BLOCKS.register(block);
		ForgeRegistries.ITEMS.register(new ItemBlockShulkerBox(block).setRegistryName(block.getRegistryName()));
	}
	
	public static void registerRenderSpecial(Block block) {
		for(EnumMaterialType types : EnumMaterialType.values()){
			RebornRegistry.registerItemModel(Item.getItemFromBlock(block), types.getMeta(), types.getName());
		}
	}
	
	private static void registerItemBlocks(){
		ForgeRegistries.ITEMS.register(new ItemBlockShulkerBox(WHITE_SHULKER_BOX).setRegistryName(WHITE_SHULKER_BOX.getRegistryName()));
		ForgeRegistries.ITEMS.register(new ItemBlockShulkerBox(ORANGE_SHULKER_BOX).setRegistryName(ORANGE_SHULKER_BOX.getRegistryName()));
		ForgeRegistries.ITEMS.register(new ItemBlockShulkerBox(MAGENTA_SHULKER_BOX).setRegistryName(MAGENTA_SHULKER_BOX.getRegistryName()));
		ForgeRegistries.ITEMS.register(new ItemBlockShulkerBox(LIGHT_BLUE_SHULKER_BOX).setRegistryName(LIGHT_BLUE_SHULKER_BOX.getRegistryName()));
		ForgeRegistries.ITEMS.register(new ItemBlockShulkerBox(YELLOW_SHULKER_BOX).setRegistryName(YELLOW_SHULKER_BOX.getRegistryName()));
		ForgeRegistries.ITEMS.register(new ItemBlockShulkerBox(LIME_SHULKER_BOX).setRegistryName(LIME_SHULKER_BOX.getRegistryName()));
		ForgeRegistries.ITEMS.register(new ItemBlockShulkerBox(PINK_SHULKER_BOX).setRegistryName(PINK_SHULKER_BOX.getRegistryName()));
		ForgeRegistries.ITEMS.register(new ItemBlockShulkerBox(GRAY_SHULKER_BOX).setRegistryName(GRAY_SHULKER_BOX.getRegistryName()));
		ForgeRegistries.ITEMS.register(new ItemBlockShulkerBox(SILVER_SHULKER_BOX).setRegistryName(SILVER_SHULKER_BOX.getRegistryName()));
		ForgeRegistries.ITEMS.register(new ItemBlockShulkerBox(CYAN_SHULKER_BOX).setRegistryName(CYAN_SHULKER_BOX.getRegistryName()));
		ForgeRegistries.ITEMS.register(new ItemBlockShulkerBox(PURPLE_SHULKER_BOX).setRegistryName(PURPLE_SHULKER_BOX.getRegistryName()));
		ForgeRegistries.ITEMS.register(new ItemBlockShulkerBox(BLUE_SHULKER_BOX).setRegistryName(BLUE_SHULKER_BOX.getRegistryName()));
		ForgeRegistries.ITEMS.register(new ItemBlockShulkerBox(BROWN_SHULKER_BOX).setRegistryName(BROWN_SHULKER_BOX.getRegistryName()));
		ForgeRegistries.ITEMS.register(new ItemBlockShulkerBox(GREEN_SHULKER_BOX).setRegistryName(GREEN_SHULKER_BOX.getRegistryName()));
		ForgeRegistries.ITEMS.register(new ItemBlockShulkerBox(RED_SHULKER_BOX).setRegistryName(RED_SHULKER_BOX.getRegistryName()));
		ForgeRegistries.ITEMS.register(new ItemBlockShulkerBox(BLACK_SHULKER_BOX).setRegistryName(BLACK_SHULKER_BOX.getRegistryName()));
		
		ForgeRegistries.ITEMS.register(new ItemBlockStainedGlass(stained_glass).setRegistryName(stained_glass.getRegistryName()));
		ForgeRegistries.ITEMS.register(new ItemBlockStainedGlassPane(stained_glass_pane).setRegistryName(stained_glass_pane.getRegistryName()));
	}
    
    public static void registerTE(){
    	
    	registerTileEntity(TileAlloyFurnace.class, alloyfurnace);
        registerTileEntity(TileProjectTable.class, projectTable);
        registerTileEntity(TileElectricalFurnace.class, electricalfurnace);
        
        registerTileEntity(TileEntityShulkerBox.class, WHITE_SHULKER_BOX);
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityShulkerBox.class, new TileEntityShulkerBoxRenderer(new ModelShulker()));
    }
    
    private static void registerTileEntity(Class<? extends TileEntity> tileClass, Block owner){
        String registryName = owner.getRegistryName().getResourceDomain() + ".tile." + owner.getRegistryName().getResourcePath();
        GameRegistry.registerTileEntity(tileClass, registryName);
    }

}
