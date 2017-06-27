package net.thegaminghuskymc.futopia.init;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thegaminghuskymc.futopia.blocks.computer.BlockCPU;
import net.thegaminghuskymc.futopia.blocks.computer.BlockDiskDrive;
import net.thegaminghuskymc.futopia.blocks.computer.BlockIOExpander;
import net.thegaminghuskymc.futopia.blocks.computer.BlockMonitor;
import net.thegaminghuskymc.futopia.blocks.machine.BlockAlloyFurnace;
import net.thegaminghuskymc.futopia.blocks.machine.BlockElectricalFurnace;
import net.thegaminghuskymc.futopia.blocks.machine.BlockParticleBlock;
import net.thegaminghuskymc.futopia.blocks.machine.BlockProjectTable;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockBaseOre;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockBaseStorage;
import net.thegaminghuskymc.futopia.tiles.TileAlloyFurnace;
import net.thegaminghuskymc.futopia.tiles.TileElectricalFurnace;
import net.thegaminghuskymc.futopia.tiles.TileProjectTable;
import net.thegaminghuskymc.huskylib.RebornRegistry;

public class FTBlocks {
	
    public static BlockAlloyFurnace alloyfurnace;

    public static BlockProjectTable projectTable;
    public static BlockElectricalFurnace electricalfurnace;

    public static BlockParticleBlock particle_block;
    
    public static BlockCPU cpu;

    public static BlockDiskDrive disk_drive;
    public static BlockIOExpander io_expander;

    public static BlockMonitor monitor;
    
    public static BlockBaseOre ores;
    public static BlockBaseStorage storages;

    public static void init(){
    	alloyfurnace = new BlockAlloyFurnace();
    	projectTable = new BlockProjectTable();
    	electricalfurnace = new BlockElectricalFurnace();
    	particle_block = new BlockParticleBlock();
    	
    	cpu = new BlockCPU();
    	disk_drive = new BlockDiskDrive();
    	io_expander = new BlockIOExpander();
    	monitor = new BlockMonitor();
    	
    	ores = new BlockBaseOre();
    	storages = new BlockBaseStorage();
    }
    
    public static void register(){
    	registerBlock(alloyfurnace);
    	registerBlock(projectTable);
    	registerBlock(electricalfurnace);
    	registerBlock(particle_block);
        registerBlock(cpu);
        registerBlock(disk_drive);
        registerBlock(io_expander);
        registerBlock(monitor);
        
        registerBlock(ores);
        registerBlock(storages);
    }
    
    public static void registerRenders(){
        registerRender(alloyfurnace);
        registerRender(projectTable);
        registerRender(electricalfurnace);
        registerRender(particle_block);
        registerRender(cpu);
        registerRender(disk_drive);
        registerRender(io_expander);
        registerRender(monitor);
        
        registerRender(ores);
        registerRender(storages);
    }
    
    public static void registerBlock(Block block) {
		RebornRegistry.registerBlock(block);
	}
	
	public static void registerRender(Block block) {
		RebornRegistry.registerItemModel(block, 0);
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
