package net.thegaminghuskymc.futopia.blocks.machine;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thegaminghuskymc.futopia.network.EnumMachineTire;
import net.thegaminghuskymc.huskylib.blocks.BlockMultiBase;
import net.thegaminghuskymc.huskylib.tiles.TileEntityMachineBase;

import java.util.Random;

public class BlockMachineBase extends BlockMultiBase {

	public static final PropertyBool ACTIVE = PropertyBool.create("active");
	public static final PropertyEnum<EnumMachineTire> MACHINE_TIRE = PropertyEnum.create("machine_tire",
			EnumMachineTire.class);
	public static final PropertyEnum<EnumFacing> FACING = BlockHorizontal.FACING;
	private static final EnumFacing[] VALID_FACING = { EnumFacing.NORTH, EnumFacing.EAST, EnumFacing.SOUTH,
			EnumFacing.WEST };

	private static World world;
	private static IBlockState state;

	public BlockMachineBase(String modid, String name, TileEntity tileEntity, CreativeTabs creativetab) {
		super(modid, name, Material.IRON, creativetab);
		setHardness(5.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 1);
		setCreativeTab(creativetab);
		createTileEntity(tileEntity, world, state);

		this.setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH)
				.withProperty(ACTIVE, false).withProperty(MACHINE_TIRE, EnumMachineTire.BASIC));
	}

	public BlockMachineBase(String modid, String name, CreativeTabs creativetab) {
		this(modid, name, new TileEntityMachineBase(), creativetab);
	}

	@Override
	public BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, ACTIVE, FACING, MACHINE_TIRE);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta & 0x03))
				.withProperty(MACHINE_TIRE, EnumMachineTire.byMetadata(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(FACING).getHorizontalIndex();
	}

	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite())
				.withProperty(MACHINE_TIRE, EnumMachineTire.byMetadata(meta));
	}

	@Override
	public EnumFacing[] getValidRotations(World world, BlockPos pos) {
		return VALID_FACING;
	}

	@Override
	public boolean rotateBlock(World world, BlockPos pos, EnumFacing axis) {
		IBlockState cur = world.getBlockState(pos);

		world.setBlockState(pos, cur.withProperty(FACING, cur.getValue(FACING).rotateY()));
		return true;
	}

	public String getPreferredRenderState() {
		return "active=false,facing=north";
	}

	public TileEntity createTileEntity(TileEntity te, World world, IBlockState state) {
		return te;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
	}

}
