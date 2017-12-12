package net.thegaminghuskymc.futopia.blocks.computer;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.thegaminghuskymc.futopia.Reference;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.network.EnumPlacingType;
import net.thegaminghuskymc.huskylib2.lib.blocks.BlockBase2;

public class BlockComputerBase extends BlockBase2 {

    public static PropertyEnum PLACING = PropertyEnum.create("placing", EnumPlacingType.class);
    public static PropertyBool ACTIVE = PropertyBool.create("online");
    public static PropertyEnum<EnumFacing> FACING = BlockHorizontal.FACING;

    public BlockComputerBase(String name) {
        super(Reference.MODID, name, FTCreativeTabs.computer_parts);
        this.getDefaultState().withProperty(FACING, EnumFacing.NORTH).withProperty(ACTIVE, false);
    }

    @Override
    public boolean hasCustomBreakingProgress(IBlockState state) {
        return true;
    }

    public BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING, ACTIVE);
    }

    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta));
    }

    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getHorizontalIndex();
    }

    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY,
                                      float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    public EnumFacing[] getValidRotations(World world, BlockPos pos) {
        return EnumFacing.HORIZONTALS;
    }

    public boolean rotateBlock(World world, BlockPos pos, EnumFacing axis) {
        IBlockState cur = world.getBlockState(pos);

        world.setBlockState(pos, cur.withProperty(FACING, cur.getValue(FACING).rotateY()));
        return true;
    }

    public String preferredRenderState() {
        return  "online=false,facing=north";
    }

    public int getPackedLightmapCoords(IBlockState state, IBlockAccess source, BlockPos pos) {
        if (MinecraftForgeClient.getRenderLayer() == BlockRenderLayer.CUTOUT) {
            return 15728880;
        } else
            return super.getPackedLightmapCoords(state, source, pos);
    }

    public boolean canRenderInLayer(IBlockState state, BlockRenderLayer layer) {
        return layer == BlockRenderLayer.CUTOUT;
    }

}