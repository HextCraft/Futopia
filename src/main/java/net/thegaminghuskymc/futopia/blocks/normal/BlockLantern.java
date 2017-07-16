package net.thegaminghuskymc.futopia.blocks.normal;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import codechicken.lib.colour.ColourRGBA;
import codechicken.lib.texture.TextureUtils;
import codechicken.lib.util.ItemNBTUtils;
import codechicken.lib.util.ItemUtils;
import keri.ninetaillib.lib.util.BlockAccessUtils;
import keri.ninetaillib.lib.util.EnumDyeColor;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.client.render.RenderLantern;
import net.thegaminghuskymc.futopia.init.FTBlocks;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.futopia.tiles.TileEntityLantern;
import net.thegaminghuskymc.futopia.utils.StackUtils;

public class BlockLantern extends BlockReliquia<TileEntityLantern> {

	private static final ItemStack[] FRAME_MATERIALS = new ItemStack[] { new ItemStack(Blocks.GOLD_BLOCK, 1, 0),
			new ItemStack(Blocks.IRON_BLOCK, 1, 0), new ItemStack(Blocks.LAPIS_BLOCK, 1, 0),
			new ItemStack(Blocks.STONEBRICK, 1, 0), new ItemStack(Blocks.NETHER_BRICK, 1, 0),
			new ItemStack(FTBlocks.ores, 1, EnumMaterialType.VALUES.length) };

	public BlockLantern() {
		super("lantern", Material.IRON);
		this.setHardness(1.4F);
		this.setLightLevel(0.9375F);
	}

	@Override
	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityLantern.class, "tile." + Refs.MODID + ".lantern");
	}

	@Nullable
	@Override
	public TileEntityLantern createNewTileEntity(World world, int meta) {
		return new TileEntityLantern();
	}

	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {
		EnumFacing orientation = null;
		int pitch = Math.round(placer.rotationPitch);

		if (pitch >= 40) {
			orientation = EnumFacing.UP;
		} else if (pitch <= -40) {
			orientation = EnumFacing.DOWN;
		} else {
			orientation = EnumFacing.fromAngle(placer.rotationYaw).getOpposite();
		}

		BlockAccessUtils.setBlockMetadata(world, pos, orientation.getIndex(), 3);
		TileEntityLantern tile = (TileEntityLantern) world.getTileEntity(pos);

		if (tile != null && stack.getTagCompound() != null) {
			if (!world.isRemote) {
				tile.setGlassColor(new ColourRGBA(stack.getTagCompound().getInteger("glass_color")));
				tile.setFrameMaterial(new ItemStack(stack.getTagCompound().getCompoundTag("frame_material")));
				tile.markDirty();
				tile.sendUpdatePacket(pos, true);
			}
		}
	}

	@Override
	public void onBlockHarvested(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
		TileEntityLantern tile = (TileEntityLantern) world.getTileEntity(pos);

		if (tile != null) {
			if (!world.isRemote) {
				if (!player.capabilities.isCreativeMode) {
					ItemStack stack = StackUtils.getLanternStack(tile.getGlassColor(), tile.getFrameMaterial());
					ItemUtils.dropItem(world, pos, stack);
				}
			}
		}

		super.onBlockHarvested(world, pos, state, player);
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		return Lists.newArrayList();
	}

	@Override
	@SuppressWarnings("deprecation")
	public SoundType getSoundType(IBlockState state, World world, BlockPos pos, @Nullable Entity entity) {
		TileEntityLantern tile = (TileEntityLantern) world.getTileEntity(pos);

		if (tile != null) {
			Block materialBlock = Block.getBlockFromItem(tile.getFrameMaterial().getItem());
			IBlockState materialState = materialBlock.getStateFromMeta(tile.getFrameMaterial().getMetadata());
			return materialBlock.getSoundType(materialState, world, pos, entity);
		}

		return super.getSoundType(state, world, pos, entity);
	}

	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings("deprecation")
	public TextureAtlasSprite getIcon(IBlockAccess world, BlockPos pos, int side) {
		TileEntityLantern tile = (TileEntityLantern) world.getTileEntity(pos);

		if (tile != null) {
			Block materialBlock = Block.getBlockFromItem(tile.getFrameMaterial().getItem());
			IBlockState materialState = materialBlock.getStateFromMeta(tile.getFrameMaterial().getMetadata());
			return TextureUtils.getIconsForBlock(materialState, 0)[0];
		}

		return TextureUtils.getMissingSprite();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand) {
		int meta = BlockAccessUtils.getBlockMetadata(world, pos);
		double posX = pos.getX() + 0.5D;
		double posY = pos.getY() + (meta > 1 ? 0.4D : 0.46D);
		double posZ = pos.getZ() + 0.5D;
		double speedX = 0D;
		double speedY = 0D;
		double speedZ = 0D;
		world.spawnParticle(EnumParticleTypes.FLAME, posX, posY, posZ, speedX, speedY, speedZ, new int[0]);
	}

	@Override
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
		for (ItemStack material : FRAME_MATERIALS) {
			for (EnumDyeColor color : EnumDyeColor.VALUES) {
				ItemStack stack = new ItemStack(this, 1, 0);
				ItemNBTUtils.validateTagExists(stack);
				stack.getTagCompound().setTag("frame_material", material.copy().writeToNBT(new NBTTagCompound()));
				stack.getTagCompound().setInteger("glass_color", color.getColor().rgba());
				list.add(stack);
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return RenderLantern.RENDER_TYPE;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean canRenderInLayer(IBlockState state, BlockRenderLayer layer) {
		return layer == BlockRenderLayer.SOLID || layer == BlockRenderLayer.TRANSLUCENT;
	}

}