package net.thegaminghuskymc.futopia.blocks.decorativeBlocks;

import net.minecraft.block.state.IBlockState;
import net.thegaminghuskymc.futopia.Reference;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.huskylib.blocks.BlockBase;

public class BlockSnowGlobe extends BlockBase{

	public BlockSnowGlobe() {
		super(Reference.MODID, "snow_globe", FTCreativeTabs.main);
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isFullBlock(IBlockState state) {
		return false;
	}

}
