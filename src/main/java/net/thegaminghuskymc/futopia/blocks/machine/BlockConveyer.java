package net.thegaminghuskymc.futopia.blocks.machine;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.thegaminghuskymc.futopia.Reference;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.huskylib.blocks.BlockBase;

public class BlockConveyer extends BlockBase {

	public BlockConveyer() {
		super(Reference.MODID, "conveyer_belt", FTCreativeTabs.main);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0f, 0f, 0f, 1f, 2f / 16f, 1f);
	}

}