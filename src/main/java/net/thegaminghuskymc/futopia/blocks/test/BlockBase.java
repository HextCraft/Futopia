package net.thegaminghuskymc.futopia.blocks.test;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.utils.test.Platform;
import net.thegaminghuskymc.futopia.utils.test.interfaces.IOrientable;
import net.thegaminghuskymc.futopia.utils.test.interfaces.IOrientableBlock;

public abstract class BlockBase extends Block {

	protected boolean isInventory = false;
	protected String resourcePath = "";
	protected String internalName = "";
	protected boolean fallInstantly = false;

	protected BlockBase(Material material, String resourcePath) {
		super(material);
		setHardness(2.2F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 0);
		this.resourcePath = resourcePath;
	}

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		if (hasGravity(worldIn, pos))
			worldIn.scheduleUpdate(pos, this, 2);

		super.onBlockAdded(worldIn, pos, state);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if (hasGravity(worldIn, pos))
			worldIn.scheduleUpdate(pos, this, 2);

		super.neighborChanged(state, worldIn, pos, blockIn, fromPos);
	}

	public static boolean func_185759_i(IBlockState p_185759_0_) {
		Block block = p_185759_0_.getBlock();
		Material material = p_185759_0_.getMaterial();
		return block == net.minecraft.init.Blocks.FIRE || material == Material.AIR || material == Material.WATER
				|| material == Material.LAVA;
	}

	public String getInternalName() {
		return internalName;
	}

	public void setInternalName(String internalName) {
		this.internalName = internalName;
	}

	public boolean hasGravity(World worldIn, BlockPos pos) {
		return false;
	}

	@Override
	public String getUnlocalizedName() {
		String blockName = getUnwrappedUnlocalizedName(super.getUnlocalizedName());

		return String.format("tile.%s.%s", Refs.MODID, blockName);
	}

	private String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

	@Override
	public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer player,
			boolean willHarvest) {
		return willHarvest || super.removedByPlayer(state, world, pos, player, false);
	}

	@Override
	public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity te,
			ItemStack stack) {
		super.harvestBlock(worldIn, player, pos, state, te, stack);
		worldIn.setBlockToAir(pos);
	}

	@Override
	public boolean rotateBlock(World world, BlockPos pos, EnumFacing axis) {
		final IOrientable rotatable = this.getOrientable(world, pos);
		if (rotatable != null && rotatable.canRotateVertically()) {
			if (this.hasCustomRotation()) {
				this.customRotateBlock(rotatable, axis);
				return true;
			} else {
				EnumFacing forward = rotatable.getForward();

				for (int rs = 0; rs < 4; rs++) {
					forward = Platform.rotateAround(forward, axis);

					if (this.isValidOrientation(world, pos, forward)) {
						rotatable.setFacing(forward);
						return true;
					}
				}
			}
		}

		return super.rotateBlock(world, pos, axis);
	}

	protected boolean hasCustomRotation() {
		return false;
	}

	protected void customRotateBlock(final IOrientable rotatable, final EnumFacing axis) {

	}

	public boolean isValidOrientation(final World world, final BlockPos pos, final EnumFacing forward) {
		return true;
	}

	public IOrientable getOrientable(final IBlockAccess world, final BlockPos pos) {
		if (this instanceof IOrientableBlock)
			return this.getOrientable(world, pos);
		return null;
	}

	@Override
	public EnumFacing[] getValidRotations(World world, BlockPos pos) {
		return new EnumFacing[0];
	}

	/*@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockRenderer() {
		final String resourcePath = String.format("%s:%s", Refs.MODID, this.resourcePath);

		ModelLoader.setCustomStateMapper(this, new DefaultStateMapper() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return new ModelResourceLocation(resourcePath, getPropertyString(state.getProperties()));
			}
		});
	}

	@SuppressWarnings({ "deprecation", "null" })
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockItemRenderer() {
		final String resourcePath = String.format("%s:%s", Refs.MODID, this.resourcePath);

		NonNullList<ItemStack> subBlocks = null;
		getSubBlocks(getCreativeTabToDisplayOn(), subBlocks);

		for (ItemStack itemStack : subBlocks) {
			IBlockState blockState = this.getStateFromMeta(itemStack.getItemDamage());
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), itemStack.getItemDamage(),
					new ModelResourceLocation(resourcePath, Platform.getPropertyString(blockState.getProperties())));

		}
	}*/
}