package net.thegaminghuskymc.futopia.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thegaminghuskymc.futopia.blocks.BlockMultiBlockController;
import net.thegaminghuskymc.futopia.blocks.BlockMultiBlockWalls;
import net.thegaminghuskymc.futopia.blocks.computer.BlockComputerTower;
import net.thegaminghuskymc.futopia.blocks.computer.BlockController;
import net.thegaminghuskymc.futopia.blocks.computer.BlockDiskDrive;
import net.thegaminghuskymc.futopia.blocks.computer.BlockFilter;
import net.thegaminghuskymc.futopia.blocks.computer.BlockMonitor;
import net.thegaminghuskymc.futopia.blocks.computer.BlockMonitorNew;
import net.thegaminghuskymc.futopia.blocks.computer.BlockParticleSummoner;
import net.thegaminghuskymc.futopia.blocks.computer.BlockProjectTable;
import net.thegaminghuskymc.futopia.blocks.conduits.BlockFluidConduit;
import net.thegaminghuskymc.futopia.blocks.conduits.BlockItemConduit;
import net.thegaminghuskymc.futopia.blocks.conduits.BlockPowerConduit;
import net.thegaminghuskymc.futopia.blocks.machine.BlockAlloyFurnace;
import net.thegaminghuskymc.futopia.blocks.machine.BlockConveyer;
import net.thegaminghuskymc.futopia.blocks.machine.BlockElectricalFurnace;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockBaseOres;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockBaseOresNether;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockBaseStorage;
import net.thegaminghuskymc.futopia.network.EnumDyeColor;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.futopia.tiles.TileAlloyFurnace;
import net.thegaminghuskymc.futopia.tiles.TileDiskDrive;
import net.thegaminghuskymc.futopia.tiles.TileElectricalFurnace;
import net.thegaminghuskymc.futopia.tiles.TileMultiBlock;
import net.thegaminghuskymc.futopia.tiles.TileMultiBlockController;
import net.thegaminghuskymc.futopia.tiles.TileProjectTable;
import net.thegaminghuskymc.futopia.utils.HuskyRegistry;
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
	public static BlockMonitorNew monitor;
	public static BlockController controller;
	public static BlockComputerTower computerTower;

	public static BlockBaseOres ores;
	public static BlockBaseOresNether nether_ores;
	public static BlockBaseStorage storages;
	
	public static BlockMultiBlockController multiBlockController;
	public static BlockMultiBlockWalls multiBlockWalls;

	public static void init() {
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
		monitor = new BlockMonitorNew();
		controller = new BlockController();
		computerTower = new BlockComputerTower();

		ores = new BlockBaseOres();
		nether_ores = new BlockBaseOresNether();
		storages = new BlockBaseStorage();
		
		multiBlockController = new BlockMultiBlockController();
		multiBlockWalls = new BlockMultiBlockWalls();
	}

	public static void register() {
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
		registerSpecialBlock(monitor);
		registerBlock(controller);
		registerSpecialBlock(computerTower);

		registerSpecialBlock(ores);
		registerSpecialBlock(storages);
		registerSpecialBlock(nether_ores);
		
		registerBlock(multiBlockController);
		registerBlock(multiBlockWalls);
	}

	public static void registerRenders() {
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
		registerRenderDyeColors(monitor);
		registerRender(controller);
		registerRenderDyeColors(computerTower);

		registerRenderMaterials(ores);
		registerRenderMaterials(storages);
		registerRenderMaterials(nether_ores);
		
		registerRender(multiBlockController);
		registerRender(multiBlockWalls);

		registerItemBlocks();
	}

	public static void registerBlock(Block block) {
		ForgeRegistries.BLOCKS.register(block);
		ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	public static void registerBlockOnly(Block block) {
		ForgeRegistries.BLOCKS.register(block);
	}

	public static void registerRender(Block block) {
		HuskyRegistry.registerItemModel(block, 0);
	}

	public static void registerSpecialBlock(Block block) {
		ForgeRegistries.BLOCKS.register(block);
		ForgeRegistries.ITEMS.register(new ItemBlockBase(block).setRegistryName(block.getRegistryName()));
	}

	public static void registerRenderMaterials(Block block) {
		for (EnumMaterialType types : EnumMaterialType.values()) {
			HuskyRegistry.registerItemModel(Item.getItemFromBlock(block), types.getMeta(), types.getName());
		}
	}
	
	public static void registerRenderDyeColors(Block block) {
		for (EnumDyeColor types : EnumDyeColor.values()) {
			HuskyRegistry.registerItemModel(Item.getItemFromBlock(block), types.getMeta(), types.getName());
		}
	}

	private static void registerItemBlocks() {

	}

	public static void registerTE() {
		registerTileEntity(TileAlloyFurnace.class, alloyfurnace);
		registerTileEntity(TileProjectTable.class, projectTable);
		registerTileEntity(TileElectricalFurnace.class, electricalfurnace);
		registerTileEntity(TileDiskDrive.class, diskDrive);
		registerTileEntity(TileMultiBlockController.class, multiBlockController);
		GameRegistry.registerTileEntity(TileMultiBlock.class, "tile_multi_block");
	}

	private static void registerTileEntity(Class<? extends TileEntity> tileClass, Block owner) {
		String registryName = owner.getRegistryName().getResourceDomain() + ".tile."
				+ owner.getRegistryName().getResourcePath();
		GameRegistry.registerTileEntity(tileClass, registryName);
	}

}
