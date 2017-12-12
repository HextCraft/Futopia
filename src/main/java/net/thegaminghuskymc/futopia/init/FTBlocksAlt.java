package net.thegaminghuskymc.futopia.init;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import net.thegaminghuskymc.futopia.Reference;
import net.thegaminghuskymc.futopia.blocks.computer.*;
import net.thegaminghuskymc.futopia.blocks.computer.BlockMonitorNew.MonitorColors;
import net.thegaminghuskymc.futopia.blocks.conduits.BlockFluidConduit;
import net.thegaminghuskymc.futopia.blocks.conduits.BlockItemConduit;
import net.thegaminghuskymc.futopia.blocks.conduits.BlockPowerConduit;
import net.thegaminghuskymc.futopia.blocks.decorativeBlocks.BlockSnowGlobe;
import net.thegaminghuskymc.futopia.blocks.machine.BlockAlloyFurnace;
import net.thegaminghuskymc.futopia.blocks.machine.BlockConveyer;
import net.thegaminghuskymc.futopia.blocks.machine.BlockElectricalFurnace;
import net.thegaminghuskymc.futopia.blocks.machine.BlockWaterTank;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockBaseOres;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockBaseOresNether;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockBaseStorage;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.futopia.tiles.*;
import net.thegaminghuskymc.huskylib2.lib.items.blocks.ItemBlockBase;

import java.util.HashSet;

//@Mod.EventBusSubscriber
public class FTBlocksAlt {

    public static final HashSet<Block> blocks = new HashSet<>();
    public static final HashSet<Block> special_blocks = new HashSet<>();
    public static final HashSet<Item> item_blocks = new HashSet<>();
    public static final HashSet<Item> special_item_blocks = new HashSet<>();

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
    public static BlockBaseStorage storages;

    public static BlockSnowGlobe snowGlobe;

    public static BlockWaterTank waterTank;

    public static void init() {
        blocks.add(alloyfurnace = new BlockAlloyFurnace());
        blocks.add(electricalfurnace = new BlockElectricalFurnace());

        blocks.add(conveyer = new BlockConveyer());

        blocks.add(itemConduit = new BlockItemConduit());
        blocks.add(powerConduit = new BlockPowerConduit());
        blocks.add(fluidConduit = new BlockFluidConduit());

        blocks.add(particleSummoner = new BlockParticleSummoner());

        blocks.add(filter = new BlockFilter());
        blocks.add(projectTable = new BlockProjectTable());
        blocks.add(diskDrive = new BlockDiskDrive());
        blocks.add(monitor = new BlockMonitor());
        blocks.add(controller = new BlockController());

        special_blocks.add(ores = new BlockBaseOres());
        special_blocks.add(nether_ores = new BlockBaseOresNether());
        special_blocks.add(storages = new BlockBaseStorage());

        blocks.add(snowGlobe = new BlockSnowGlobe());

        blocks.add(waterTank = new BlockWaterTank());

        item_blocks.add(new ItemBlockBase(alloyfurnace).setRegistryName(alloyfurnace.getRegistryName()));
        item_blocks.add(new ItemBlockBase(electricalfurnace).setRegistryName(electricalfurnace.getRegistryName()));

        item_blocks.add(new ItemBlockBase(conveyer).setRegistryName(conveyer.getRegistryName()));

        item_blocks.add(new ItemBlockBase(itemConduit).setRegistryName(itemConduit.getRegistryName()));
        item_blocks.add(new ItemBlockBase(powerConduit).setRegistryName(powerConduit.getRegistryName()));
        item_blocks.add(new ItemBlockBase(fluidConduit).setRegistryName(fluidConduit.getRegistryName()));

        item_blocks.add(new ItemBlockBase(particleSummoner).setRegistryName(particleSummoner.getRegistryName()));

        item_blocks.add(new ItemBlockBase(filter).setRegistryName(filter.getRegistryName()));
        item_blocks.add(new ItemBlockBase(projectTable).setRegistryName(projectTable.getRegistryName()));
        item_blocks.add(new ItemBlockBase(diskDrive).setRegistryName(diskDrive.getRegistryName()));
        item_blocks.add(new ItemBlockBase(monitor).setRegistryName(monitor.getRegistryName()));
        item_blocks.add(new ItemBlockBase(controller).setRegistryName(controller.getRegistryName()));

        special_item_blocks.add(new ItemBlockBase(ores).setRegistryName(ores.getRegistryName()));
        special_item_blocks.add(new ItemBlockBase(nether_ores).setRegistryName(nether_ores.getRegistryName()));
        special_item_blocks.add(new ItemBlockBase(storages).setRegistryName(storages.getRegistryName()));

        item_blocks.add(new ItemBlockBase(snowGlobe).setRegistryName(snowGlobe.getRegistryName()));

        item_blocks.add(new ItemBlockBase(waterTank).setRegistryName(waterTank.getRegistryName()));
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        for(Block b : blocks) {
            event.getRegistry().register(b);
        }
        for(Block b : special_blocks) {
            event.getRegistry().register(b);
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        for(Item i : item_blocks) {
            event.getRegistry().register(i);
        }
        for(Item i : special_item_blocks) {
            event.getRegistry().register(i);
        }
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        for(Block b : blocks) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(b), 0, new ModelResourceLocation(b.getRegistryName(), "inventory"));
        }
        for(Block b : special_blocks) {
            if(b == monitor) {
                registerMonitorRender(b);
            }
            if(b == ores || b == nether_ores || b == storages) {
                registerRenderMaterials(b);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    private static void registerRenderMaterials(Block block) {
        for (EnumMaterialType  types : EnumMaterialType.values()) {
            registerItemModel(block, types.getMeta(), types.getName());
        }
    }

    @SideOnly(Side.CLIENT)
    private static void registerMonitorRender(Block block) {
        for (MonitorColors colors : MonitorColors.values()) {
            registerItemModel(block, colors.getMeta(), colors.getName());
        }
    }

    public static void registerTE() {
        registerTileEntity(TileAlloyFurnace.class, alloyfurnace);
        registerTileEntity(TileProjectTable.class, projectTable);
        registerTileEntity(TileElectricalFurnace.class, electricalfurnace);
        registerTileEntity(TileDiskDrive.class, diskDrive);
        registerTileEntity(TileEntityWaterTank.class, waterTank);
    }

    private static void registerTileEntity(Class<? extends TileEntity> tileClass, Block owner) {
        String registryName = owner.getRegistryName().getResourceDomain() + ".tile."
        + owner.getRegistryName().getResourcePath();
        GameRegistry.registerTileEntity(tileClass, registryName);
    }

    @SideOnly(Side.CLIENT)
    public static void registerItemModel(Block b, int meta, String variant) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(b), meta, new ModelResourceLocation(b.getRegistryName(), "variants=" + variant));
    }

    @Mod.EventBusSubscriber(modid = Reference.MODID)
    public class RegistrationHandler {
        @SubscribeEvent
        public void registerItems(final RegistryEvent.Register<Item> event) {
            final IForgeRegistry<Item> registry = event.getRegistry();

            for (Item item : item_blocks) {
                registry.register(item);
            }
        }
    }

}
