package net.thegaminghuskymc.futopia.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
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
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockBaseOres;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockBaseStorage;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.futopia.tiles.TileAlloyFurnace;
import net.thegaminghuskymc.futopia.tiles.TileElectricalFurnace;
import net.thegaminghuskymc.futopia.tiles.TileProjectTable;
import net.thegaminghuskymc.huskylib.RebornRegistry;
import net.thegaminghuskymc.huskylib.items.blocks.ItemBlockBase;

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
	
	public static void registerRenderSpecial(Block block) {
		for(EnumMaterialType types : EnumMaterialType.values()){
			RebornRegistry.registerItemModel(Item.getItemFromBlock(block), types.getMeta(), types.getName());
		}
	}
	
	private static void registerItemBlocks(){
		
	}
    
    public static void registerTE(){
    	
    	registerTileEntity(TileAlloyFurnace.class, alloyfurnace);
        registerTileEntity(TileProjectTable.class, projectTable);
        registerTileEntity(TileElectricalFurnace.class, electricalfurnace);
    }
    
    private static void registerTileEntity(Class<? extends TileEntity> tileClass, Block owner){
        String registryName = owner.getRegistryName().getResourceDomain() + ".tile." + owner.getRegistryName().getResourcePath();
        GameRegistry.registerTileEntity(tileClass, registryName);
    }

}
