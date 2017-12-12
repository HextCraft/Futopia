/*******************************************************************************
 * HellFirePvP / Astral Sorcery 2017
 *
 * This project is licensed under GNU GENERAL PUBLIC LICENSE Version 3.
 * The source code is available on github: https://github.com/HellFirePvP/AstralSorcery
 * For further details, see the License file there.
 ******************************************************************************/

package net.thegaminghuskymc.futopia.blocks.private_blocks;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;

import java.util.Random;

/**
 * This class is part of the Astral Sorcery Mod
 * The complete source code for this mod can be found on github.
 * Class: BlockMarbleSlab
 * Created by HellFirePvP
 * Date: 05.07.2017 / 18:47
 */
public class BlockMarbleSlab extends BlockSlab {

    public static final PropertyEnum<EnumType> MARBLE_TYPE = PropertyEnum.create("marbletype", EnumType.class);

    public BlockMarbleSlab() {
        super(Material.ROCK, MapColor.QUARTZ);
        IBlockState state = this.blockState.getBaseState();
        if(!isDouble()) {
            state = state.withProperty(HALF, EnumBlockHalf.BOTTOM);
        }
        setDefaultState(state.withProperty(MARBLE_TYPE, EnumType.BRICKS));
        setSoundType(SoundType.STONE);
        setCreativeTab(FTCreativeTabs.main);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(this);
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        return new ItemStack(this, 1, state.getValue(MARBLE_TYPE).ordinal());
    }

    @Override
    public String getUnlocalizedName(int meta) {
        return super.getUnlocalizedName() + "." + EnumType.byMetadata(meta).getName();
    }

    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> items) {
        for (EnumType type : EnumType.values()) {
            items.add(new ItemStack(this, 1, type.ordinal()));
        }
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        IBlockState iblockstate = getDefaultState().withProperty(MARBLE_TYPE, EnumType.byMetadata(meta & 7));
        if(!isDouble()) {
            iblockstate = iblockstate.withProperty(HALF, (meta & 8) == 0 ? EnumBlockHalf.BOTTOM : EnumBlockHalf.TOP);
        }
        return iblockstate;
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int i = state.getValue(MARBLE_TYPE).ordinal();
        if(!isDouble()) {
            if (state.getValue(HALF) == EnumBlockHalf.TOP) {
                i |= 8;
            }
        }
        return i;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return isDouble() ? new BlockStateContainer(this, MARBLE_TYPE) : new BlockStateContainer(this, HALF, MARBLE_TYPE);
    }

    @Override
    public int damageDropped(IBlockState state) {
        return state.getValue(MARBLE_TYPE).ordinal();
    }

    @Override
    public boolean isDouble() {
        return false;
    }

    @Override
    public IProperty<?> getVariantProperty() {
        return MARBLE_TYPE;
    }

    @Override
    public Comparable<?> getTypeForItem(ItemStack stack) {
        return EnumType.byMetadata(stack.getMetadata() & 7);
    }

    public enum EnumType implements IStringSerializable {

        BRICKS;

        @Override
        public String getName() {
            return name().toLowerCase();
        }

        public static EnumType byMetadata(int meta) {
            if (meta < 0 || meta >= values().length) {
                meta = 0;
            }
            return values()[meta];
        }
    }

}
