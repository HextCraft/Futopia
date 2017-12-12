package net.thegaminghuskymc.futopia.blocks.idk.Lamps;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;

import javax.annotation.Nonnull;

public class BlockLamp extends Block {

    public static final PropertyBool isUp = PropertyBool.create("up");

    public BlockLamp(Material material, String unlocalizedName, String registryName) {
        super(material);
        setUnlocalizedName(unlocalizedName);
        setRegistryName(registryName);
        this.setCreativeTab(FTCreativeTabs.main);
        this.setHardness(2f);
        this.setSoundType(SoundType.GLASS);
        this.setLightLevel(0.9375F);
        this.setDefaultState(this.blockState.getBaseState().withProperty(isUp, false));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, isUp);
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(isUp, (meta & 1) > 0);
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state) {
        if (state.getValue(isUp))
            return 1;
        else return 0;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Nonnull
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }
}
