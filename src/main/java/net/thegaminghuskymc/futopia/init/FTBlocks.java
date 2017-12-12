package net.thegaminghuskymc.futopia.init;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.blocks.BlockShulkerBox;
import net.thegaminghuskymc.futopia.blocks.computer.*;
import net.thegaminghuskymc.futopia.blocks.computer.BlockMonitorNew.MonitorColors;
import net.thegaminghuskymc.futopia.blocks.conduits.BlockFluidConduit;
import net.thegaminghuskymc.futopia.blocks.conduits.BlockItemConduit;
import net.thegaminghuskymc.futopia.blocks.conduits.BlockPowerConduit;
import net.thegaminghuskymc.futopia.blocks.decorativeBlocks.*;
import net.thegaminghuskymc.futopia.blocks.machine.BlockAlloyFurnace;
import net.thegaminghuskymc.futopia.blocks.machine.BlockConveyer;
import net.thegaminghuskymc.futopia.blocks.machine.BlockElectricalFurnace;
import net.thegaminghuskymc.futopia.blocks.machine.BlockWaterTank;
import net.thegaminghuskymc.futopia.blocks.private_blocks.BlockCustomFlower;
import net.thegaminghuskymc.futopia.blocks.private_blocks.BlockMarbleDoubleSlab;
import net.thegaminghuskymc.futopia.blocks.private_blocks.BlockMarbleSlab;
import net.thegaminghuskymc.futopia.blocks.private_blocks.BlockMarbleStairs;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockBaseOres;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockBaseOresEnd;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockBaseOresNether;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockBaseStorage;
import net.thegaminghuskymc.futopia.items.itemblocks.ItemBlockCustomName;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.futopia.tiles.*;
import net.thegaminghuskymc.huskylib2.lib.items.blocks.ItemBlockBase;

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
	public static BlockBaseOresNether nether_ores;
	public static BlockBaseOresEnd end_ores;
	public static BlockBaseStorage storages;

	public static BlockSnowGlobe snowGlobe;

	public static BlockWaterTank waterTank;

	public static BlockBasaltPillar basaltPillar;
	public static BlockLimestonePillar limestonePillar;
	public static BlockMarblePillar marblePillar;
	public static BlockMeteorPillar meteorPillar;

    public static Block customFlower;
    public static Block marbleSlab;
    public static Block marbleDoubleSlab;
    public static Block marbleStairs;

    public static Block shulkerBox;

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
		monitor = new BlockMonitor();
		controller = new BlockController();

		ores = new BlockBaseOres();
		nether_ores = new BlockBaseOresNether();
		end_ores = new BlockBaseOresEnd();
		storages = new BlockBaseStorage();

//		snowGlobe = new BlockSnowGlobe();

//		waterTank = new BlockWaterTank();

//		basaltPillar = new BlockBasaltPillar();
//		limestonePillar = new BlockLimestonePillar();
//		marblePillar = new BlockMarblePillar();
//		meteorPillar = new BlockMeteorPillar();

        customFlower = new BlockCustomFlower().setRegistryName("custom_flower").setUnlocalizedName("custom_flower");
        marbleSlab = new BlockMarbleSlab().setRegistryName("marble_slab").setUnlocalizedName("marble_slab");
        marbleDoubleSlab = new BlockMarbleDoubleSlab().setRegistryName("marble_double_slab").setUnlocalizedName("marble_double_slab");
        marbleStairs = new BlockMarbleStairs().setRegistryName("marble_stairs").setUnlocalizedName("marble_stairs");

        shulkerBox = new BlockShulkerBox();
	}

	public static void register() {
		registerBlock(alloyfurnace);
		registerBlock(electricalfurnace);

		registerBlock(conveyer);

//		registerBlock(itemConduit);
//		registerBlock(powerConduit);
//		registerBlock(fluidConduit);

		registerBlock(particleSummoner);

		registerBlock(filter);
		registerBlock(projectTable);
		registerBlock(diskDrive);
		registerBlock(monitor);
		registerBlock(controller);

		registerSpecialBlock(ores);
		registerSpecialBlock(storages);
		registerSpecialBlock(nether_ores);
		registerSpecialBlock(end_ores);

//		registerBlock(snowGlobe);

//		registerBlock(waterTank);

//		registerBlock(basaltPillar);
//        registerBlock(limestonePillar);
//        registerBlock(marblePillar);
//        registerBlock(meteorPillar);

        registerBlockCustomName(customFlower);
        registerBlockCustomName(marbleSlab);
        registerBlockCustomName(marbleDoubleSlab);
        registerBlockCustomName(marbleStairs);

        registerBlock(shulkerBox);
	}

	public static void registerRenders() {
		registerRender(alloyfurnace);
		registerRender(electricalfurnace);

		registerRender(conveyer);

//		registerRender(itemConduit);
//		registerRender(powerConduit);
//		registerRender(fluidConduit);

		registerRender(particleSummoner);

		registerRender(filter);
		registerRender(projectTable);
		registerRender(diskDrive);
		registerMonitorRender(monitor);
		registerRender(controller);

		registerRenderMaterials(ores);
		registerRenderMaterials(storages);
		registerRenderMaterials(nether_ores);
		registerRenderMaterials(end_ores);

//		registerRender(snowGlobe);

//		registerRender(waterTank);

//        registerRender(basaltPillar);
//        registerRender(limestonePillar);
//        registerRender(marblePillar);
//        registerRender(meteorPillar);

        registerRender(customFlower);
        registerRender(marbleSlab);
        registerRender(marbleDoubleSlab);
        registerRender(marbleStairs);

        registerRenderColours(shulkerBox);
	}

	public static void registerBlock(Block block) {
		ForgeRegistries.BLOCKS.register(block);
		ForgeRegistries.ITEMS.register(new ItemBlockBase(block).setRegistryName(block.getRegistryName()));
	}

    private static void registerRender(Block block) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}

    private static void registerSpecialBlock(Block block) {
		ForgeRegistries.BLOCKS.register(block);
		ForgeRegistries.ITEMS.register(new ItemBlockBase(block).setRegistryName(block.getRegistryName()));
	}

    private static void registerBlockCustomName(Block block) {
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(new ItemBlockCustomName(block).setRegistryName(block.getRegistryName()));
    }

	private static void registerRenderMaterials(Block block) {
		for (EnumMaterialType types : EnumMaterialType.values()) {
			registerItemModel(block, types.getMeta(), types.getName());
		}
	}

    private static void registerRenderColours(Block block) {
        for (EnumDyeColor types : EnumDyeColor.values()) {
            registerItemModel(block, types.getMetadata(), types.getName());
        }
    }

    private static void registerMonitorRender(Block block){
		for(MonitorColors colors: MonitorColors.values()){
			registerItemModel(block, colors.getMeta(), colors.getName());
		}
	}

	public static void registerTE() {
        GameRegistry.registerTileEntity(TileAlloyFurnace.class, "tileAlloyFurnace");
        GameRegistry.registerTileEntity(TileProjectTable.class, "tileProjectTable");
        GameRegistry.registerTileEntity(TileElectricalFurnace.class, "tileElectricalFurnace");
        GameRegistry.registerTileEntity(TileDiskDrive.class, "tileDiskDrive");
        GameRegistry.registerTileEntity(TileEntityShulkerBox.class, "tileShulkerBox");
	}

    @SideOnly(Side.CLIENT)
    public static void registerItemModel(Block b, int meta, String variant) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(b), meta, new ModelResourceLocation(b.getRegistryName(), "variants=" + variant));
    }

}
