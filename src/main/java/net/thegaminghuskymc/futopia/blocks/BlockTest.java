package net.thegaminghuskymc.futopia.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.tiles.TileTestBlock;

public class BlockTest extends BlockMultiBlock{

	public BlockTest() {
		super(Material.IRON);
		setUnlocalizedName("test_block");
		setRegistryName(Refs.MODID, getUnlocalizedName());
		setCreativeTab(FTCreativeTabs.main);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileTestBlock();
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isNormalCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isFullBlock(IBlockState state) {
		return false;
	}

}
