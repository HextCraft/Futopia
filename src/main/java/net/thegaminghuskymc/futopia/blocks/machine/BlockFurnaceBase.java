package net.thegaminghuskymc.futopia.blocks.machine;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.Reference;
import net.thegaminghuskymc.futopia.client.gui.GuiHandler;
import net.thegaminghuskymc.futopia.tiles.TileFurnaceBase;
import net.thegaminghuskymc.huskylib.blocks.BlockBase;

public class BlockFurnaceBase extends BlockBase {

	public static final PropertyBool ACTIVE = PropertyBool.create("active");
	public static final PropertyEnum<EnumFacing> FACING = BlockHorizontal.FACING;

	private static final EnumFacing[] VALID_FACING = { EnumFacing.NORTH, EnumFacing.EAST, EnumFacing.SOUTH,
			EnumFacing.WEST };

	private static World world;
	private static IBlockState state;

	public BlockFurnaceBase(String name, CreativeTabs creativetab) {
		super(Reference.MODID, name, creativetab);
		createTileEntity(new TileFurnaceBase(), world, state);

		this.setDefaultState(
				blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(ACTIVE, false));
	}

	public BlockFurnaceBase(String name, CreativeTabs creativetab, TileEntity te) {
		super(Reference.MODID, name, creativetab);
		createTileEntity(te, world, state);

		this.setDefaultState(
				blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(ACTIVE, false));
	}

	@Override
	public BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, FACING, ACTIVE);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta & 0x03));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(FACING).getHorizontalIndex();
	}

	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}

	@Override
	public EnumFacing[] getValidRotations(World world, BlockPos pos) {
		return VALID_FACING;
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		if (worldIn.isRemote & !playerIn.isSneaking()) {
			playerIn.openGui(Futopia.INSTANCE, GuiHandler.FURNACE_BASE, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}

		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
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

}
