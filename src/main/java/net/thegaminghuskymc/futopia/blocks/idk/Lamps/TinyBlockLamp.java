package net.thegaminghuskymc.futopia.blocks.idk.Lamps;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by LiLRichy on 7/21/2016.
 */
public class TinyBlockLamp extends BlockLamp {

    private static final AxisAlignedBB axisAlignedBB = new AxisAlignedBB(0.35D, 0.0D, 0.65D, 0.65D, 0.35D, 0.35D);
    private static final AxisAlignedBB axisAlignedBBUP = new AxisAlignedBB(0.35D, 0.65D, 0.65D, 0.65D, 1.0D, 0.35D);

    public TinyBlockLamp(String unlocalizedName, String registryName) {
        super(Material.GLASS, unlocalizedName, registryName);
    }

    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox,
    		List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean p_185477_7_) {

        if (state.getValue(isUp))
            addCollisionBoxToList(pos, entityBox, collidingBoxes, axisAlignedBBUP);
        else
            addCollisionBoxToList(pos, entityBox, collidingBoxes, axisAlignedBB);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        if (state.getValue(isUp))
            return axisAlignedBBUP;
        else return axisAlignedBB;
    }
}
