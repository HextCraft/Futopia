package net.thegaminghuskymc.futopia.init;

import java.util.Arrays;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.blocks.computer.BlockCPU;
import net.thegaminghuskymc.futopia.blocks.computer.BlockDiskDrive;
import net.thegaminghuskymc.futopia.blocks.computer.BlockIOExpander;
import net.thegaminghuskymc.futopia.blocks.machine.BlockAlloyFurnace;
import net.thegaminghuskymc.futopia.blocks.machine.BlockElectricalFurnace;
import net.thegaminghuskymc.futopia.blocks.machine.BlockParticleBlock;
import net.thegaminghuskymc.futopia.blocks.machine.BlockProjectTable;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockBaseOre;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockBaseStorage;
import net.thegaminghuskymc.futopia.utils.BlockNames;
import net.thegaminghuskymc.huskylib.blocks.BlockBase;
import net.thegaminghuskymc.huskylib.tiles.IAutoRegisterTileEntity;

@GameRegistry.ObjectHolder(Refs.MODID)
@Mod.EventBusSubscriber(modid = Refs.MODID)
public class FTBlocksNew {
	
	@GameRegistry.ObjectHolder(BlockNames.ALLOYFURNACE_NAME)
	public final static BlockAlloyFurnace alloyFurnace = null;
	@GameRegistry.ObjectHolder(BlockNames.PROJECT_TABLENAME)
	public final static BlockProjectTable projectTable = null;
	@GameRegistry.ObjectHolder(BlockNames.ELECTRICALFURNACE_NAME)
	public final static BlockElectricalFurnace electricalFurnace = null;
	@GameRegistry.ObjectHolder(BlockNames.PARTICLE_BLOCKNAME)
	public final static BlockParticleBlock particleBlock = null;
	@GameRegistry.ObjectHolder(BlockNames.BLOCKCPU_NAME)
	public final static BlockCPU cpu = null;
	@GameRegistry.ObjectHolder(BlockNames.BLOCKDISKDRIVE_NAME)
	public final static BlockDiskDrive diskDrive = null;
	@GameRegistry.ObjectHolder(BlockNames.BLOCKIOEXPANDER_NAME)
	public final static BlockIOExpander io_expander = null;
	@GameRegistry.ObjectHolder(BlockNames.ORE)
	public final static BlockBaseOre ores = null;
	@GameRegistry.ObjectHolder(BlockNames.STORAGE)
	public final static BlockBaseStorage storages = null;
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		Block[] blocks = new Block[]
		{
			new BlockAlloyFurnace(),
			new BlockProjectTable(),
			new BlockElectricalFurnace(),
			new BlockParticleBlock(),
			new BlockCPU(),
			new BlockDiskDrive(),
			new BlockIOExpander()
		};

		event.getRegistry().registerAll(blocks);

		Arrays.stream(blocks)
			.filter(block -> block instanceof IAutoRegisterTileEntity)
			.map(block -> (IAutoRegisterTileEntity)block)
			.forEach(block -> GameRegistry.registerTileEntity(block.getTileEntityClass(), block.getTileEntityRegistryName()));
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		BlockBase[] blocks = new BlockBase[]
		{
			alloyFurnace,
			projectTable,
			electricalFurnace,
			particleBlock,
			cpu,
			diskDrive,
			io_expander
		};

        event.getRegistry().registerAll(Arrays.stream(blocks)
            .map(BlockBase::createItemBlock)
            .toArray(Item[]::new));
	}

	@SubscribeEvent
	public static void registerItems(ModelRegistryEvent event)
	{
		BlockBase[] blocks = new BlockBase[]
		{
				alloyFurnace,
				projectTable,
				electricalFurnace,
				particleBlock,
				cpu,
				diskDrive,
				io_expander
		};

        Arrays.stream(blocks)
            .forEach(block -> block.registerItemModels(Item.getItemFromBlock(block)));
    }

}
