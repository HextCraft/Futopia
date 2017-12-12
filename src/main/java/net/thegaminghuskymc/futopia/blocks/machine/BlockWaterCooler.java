package net.thegaminghuskymc.futopia.blocks.machine;

import net.minecraft.block.state.IBlockState;
import net.thegaminghuskymc.futopia.Reference;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.huskylib.blocks.BlockBase;

public class BlockWaterCooler extends BlockBase {

	public BlockWaterCooler() {
		super(Reference.MODID, "water_cooler", FTCreativeTabs.machines);
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