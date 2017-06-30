package net.thegaminghuskymc.futopia.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.blocks.computer.BlockCPU;
import net.thegaminghuskymc.futopia.blocks.computer.BlockDiskDrive;
import net.thegaminghuskymc.futopia.blocks.computer.BlockIOExpander;
import net.thegaminghuskymc.futopia.blocks.computer.BlockMonitor;
import net.thegaminghuskymc.futopia.blocks.idk.pipe.BlockPipeBasic;
import net.thegaminghuskymc.futopia.blocks.idk.pipe.BlockPipeFluid;
import net.thegaminghuskymc.futopia.blocks.machine.BlockAlloyFurnace;
import net.thegaminghuskymc.futopia.blocks.machine.BlockConveyer;
import net.thegaminghuskymc.futopia.blocks.machine.BlockElectricalFurnace;
import net.thegaminghuskymc.futopia.blocks.machine.BlockFilter;
import net.thegaminghuskymc.futopia.blocks.machine.BlockFoodFactory;
import net.thegaminghuskymc.futopia.blocks.machine.BlockParticleSummoner;
import net.thegaminghuskymc.futopia.blocks.machine.BlockProjectTable;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockBaseOre;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockBaseStorage;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.futopia.tiles.TileAlloyFurnace;
import net.thegaminghuskymc.futopia.tiles.TileElectricalFurnace;
import net.thegaminghuskymc.futopia.tiles.TileProjectTable;
import net.thegaminghuskymc.huskylib.RebornRegistry;

public class FTBlocks {
	
    public static BlockAlloyFurnace alloyfurnace;
    public static BlockConveyer conveyer;
    public static BlockFoodFactory foodFactory;
    public static BlockPipeBasic pipe;
    public static BlockPipeBasic pipePower;
    public static BlockPipeFluid pipeFluid;
    public static BlockFilter filter;
    public static BlockProjectTable projectTable;
    public static BlockElectricalFurnace electricalfurnace;
    public static BlockParticleSummoner particleSummoner;
    public static BlockCPU cpu;
    public static BlockDiskDrive diskDrive;
    public static BlockIOExpander ioExpander;
    public static BlockMonitor monitor;
    public static BlockBaseOre ores;
    public static BlockBaseStorage storages;

    public static void init(){
    	alloyfurnace = new BlockAlloyFurnace();
    	conveyer = new BlockConveyer();
    	foodFactory = new BlockFoodFactory();
    	pipe = new BlockPipeBasic("item");
    	pipePower = new BlockPipeBasic("power");
    	pipeFluid = new BlockPipeFluid();
    	filter = new BlockFilter();
    	projectTable = new BlockProjectTable();
    	electricalfurnace = new BlockElectricalFurnace();
    	particleSummoner = new BlockParticleSummoner();
    	cpu = new BlockCPU();
    	diskDrive = new BlockDiskDrive();
    	ioExpander = new BlockIOExpander();
    	monitor = new BlockMonitor();
    	ores = new BlockBaseOre();
    	storages = new BlockBaseStorage();
    }
    
    public static void register(){
    	registerBlock(alloyfurnace);
    	registerBlock(conveyer);
    	registerBlock(foodFactory);
    	registerBlock(pipe);
    	registerBlock(pipePower);
    	registerBlock(pipeFluid);
    	registerBlock(filter);
    	registerBlock(projectTable);
    	registerBlock(electricalfurnace);
    	registerBlock(particleSummoner);
        registerBlock(cpu);
        registerBlock(diskDrive);
        registerBlock(ioExpander);
        registerBlock(monitor);
        registerBlock(ores);
        registerBlock(storages);
    }
    
    public static void registerRenders(){
        registerRender(alloyfurnace);
        registerRender(conveyer);
        registerRender(foodFactory);
        registerRender(pipe);
        registerRender(pipePower);
        registerRender(pipeFluid);
        registerRender(filter);
        registerRender(projectTable);
        registerRender(electricalfurnace);
        registerRender(particleSummoner);
        registerRender(cpu);
        registerRender(diskDrive);
        registerRender(ioExpander);
        registerRender(monitor);
        registerRenderSpecial(ores);
        registerRenderSpecial(storages);
    }
    
    public static void registerBlock(Block block) {
		RebornRegistry.registerBlock(block);
	}
	
	public static void registerRender(Block block) {
		RebornRegistry.registerItemModel(block, 0);
	}
	
	public static void registerRenderSpecial(Block block) {
		for(EnumMaterialType types : EnumMaterialType.values()){
			RebornRegistry.registerItemModel(Item.getItemFromBlock(block), types.getMeta(), types.getName());
		}
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
