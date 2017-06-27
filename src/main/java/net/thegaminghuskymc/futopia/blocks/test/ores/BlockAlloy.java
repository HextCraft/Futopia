package net.thegaminghuskymc.futopia.blocks.test.ores;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.thegaminghuskymc.futopia.blocks.test.BlockBase;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.network.EnumAlloys;
import net.thegaminghuskymc.futopia.network.EnumOreType;

public class BlockAlloy extends BlockBase {

    public static PropertyEnum MATERIAL = PropertyEnum.create("material", EnumAlloys.class);

    public BlockAlloy() {
        super(Material.ROCK, "ores/ore");
        this.setDefaultState(this.blockState.getBaseState().withProperty(MATERIAL, EnumAlloys.byMeta(0)));
        this.setCreativeTab(FTCreativeTabs.main);
        this.setInternalName("alloy");
        setHarvestLevel("pickaxe", 0);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(MATERIAL, EnumAlloys.byMeta(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        EnumAlloys material = (EnumAlloys) state.getValue(MATERIAL);
        return (material.getMeta());
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, MATERIAL);
    }

    @Override
    public int damageDropped(IBlockState state) {
        return getMetaFromState(state);
    }

    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
        for (int i = 0; i < EnumAlloys.values().length; i++) {
            if (EnumAlloys.byMeta(i).isTypeSet(EnumOreType.ORE)) {
                list.add(new ItemStack(this, 1, i));
            }
        }
    }
}
