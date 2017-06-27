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
import net.thegaminghuskymc.futopia.network.EnumOreType;
import net.thegaminghuskymc.futopia.network.EnumOres;

public class BlockOre extends BlockBase {

    @SuppressWarnings("rawtypes")
	public static PropertyEnum MATERIAL = PropertyEnum.create("material", EnumOres.class);

    @SuppressWarnings("unchecked")
	public BlockOre() {
        super(Material.ROCK, "ores/ore");
        this.setDefaultState(this.blockState.getBaseState().withProperty(MATERIAL, EnumOres.byMeta(0)));
        this.setCreativeTab(FTCreativeTabs.world_gen);
        this.setInternalName("ore");
        setHarvestLevel("pickaxe", 0);
    }

    @SuppressWarnings("unchecked")
	@Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(MATERIAL, EnumOres.byMeta(meta));
    }

    @SuppressWarnings("unchecked")
	@Override
    public int getMetaFromState(IBlockState state) {
        EnumOres material = (EnumOres) state.getValue(MATERIAL);
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
        for (int i = 0; i < EnumOres.values().length; i++) {
            if (EnumOres.byMeta(i).isTypeSet(EnumOreType.ORE)) {
                list.add(new ItemStack(this, 1, i));
            }
        }
    }
}