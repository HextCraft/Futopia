package net.thegaminghuskymc.huskylib.utils;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.thegaminghuskymc.huskylib.blocks.BlockSubBase;

public class BlockAccessUtils {

    public static int getBlockMetadata(IBlockState state){
        return state.getValue(BlockSubBase.META_DATA);
    }

    public static int getBlockMetadata(IBlockAccess world, BlockPos pos){
        IBlockState state = world.getBlockState(pos).getActualState(world, pos);
        return state.getValue(BlockSubBase.META_DATA);
    }

    public static boolean setBlockMetadata(World world, BlockPos pos, int meta, int flags){
        IBlockState oldState = world.getBlockState(pos).getActualState(world, pos);
        IBlockState newState = oldState.withProperty(BlockSubBase.META_DATA, meta);
        return world.setBlockState(pos, newState, flags);
    }

    public static IBlockState getMetaState(Block block, int meta){
        return block.getDefaultState().withProperty(BlockSubBase.META_DATA, meta);
    }

}
