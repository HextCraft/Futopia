package net.thegaminghuskymc.futopia.blocks.machine;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumBlockRenderType;
import net.thegaminghuskymc.futopia.blocks.BlockMachineBase;
import net.thegaminghuskymc.futopia.utils.BlockNames;

public class BlockWindmillController extends BlockMachineBase {

    public BlockWindmillController() {
        super(BlockNames.WINDMILL_NAME);
    }

    @Override
    public boolean isNormalCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {

        return false;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

}
