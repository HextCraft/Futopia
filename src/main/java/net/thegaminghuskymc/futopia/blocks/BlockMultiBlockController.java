package net.thegaminghuskymc.futopia.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.tiles.TileMultiBlockController;

public class BlockMultiBlockController extends BlockMultiBlock{

	public BlockMultiBlockController() {
		super(Material.IRON);
		setUnlocalizedName("multiblock_controller");
		setRegistryName(Refs.MODID, "multiblock_controller");
		setCreativeTab(FTCreativeTabs.main);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileMultiBlockController();
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return true;
	}
	
	@Override
	public boolean isNormalCube(IBlockState state) {
		return true;
	}
	
	@Override
	public boolean isFullBlock(IBlockState state) {
		return true;
	}

}
