package net.thegaminghuskymc.futopia.blocks.machine;

import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.thegaminghuskymc.futopia.tiles.TileFurnaceBase;
import net.thegaminghuskymc.huskylib.blocks.BlockBase;

public class BlockFurnaceBase extends BlockBase{
	
	private static World world;
	private static IBlockState state;

	public BlockFurnaceBase(String name, CreativeTabs creativetab) {
		super(name, creativetab);
		createTileEntity(new TileFurnaceBase(), world, state);
	}
	
	public BlockFurnaceBase(String name, CreativeTabs creativetab, TileEntity te) {
		super(name, creativetab);
		createTileEntity(te, world, state);
	}
	
	public TileEntity createTileEntity(TileEntity te, World world, IBlockState state) {
		return te;
	}

}
