package net.thegaminghuskymc.futopia.blocks.test.ores;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.thegaminghuskymc.futopia.blocks.test.BlockBase;
import net.thegaminghuskymc.futopia.blocks.test.Blocks;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.network.EnumOreType;
import net.thegaminghuskymc.futopia.network.EnumOres;
import net.thegaminghuskymc.futopia.utils.test.interfaces.IProvideRecipe;
import net.thegaminghuskymc.huskylib.utils.HLCraftingHelper;

public class BlockOreBlock extends BlockBase implements IProvideRecipe {

    public static final PropertyEnum<EnumOres> MATERIAL = PropertyEnum.create("material", EnumOres.class);

    public BlockOreBlock() {
        super(Material.ROCK, "ores/oreBlock");
        this.setDefaultState(this.blockState.getBaseState().withProperty(MATERIAL, EnumOres.byMeta(0)));
        this.setCreativeTab(FTCreativeTabs.main);
        this.setInternalName("ore_block");
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(MATERIAL, EnumOres.byMeta(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return (state.getValue(MATERIAL)).getMeta();
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
            if (EnumOres.byMeta(i).isTypeSet(EnumOreType.BLOCK)) {
                list.add(new ItemStack(this, 1, i));
            }
        }
    }

    @Override
    public void RegisterRecipes() {
        for (EnumOres ore : EnumOres.values()) {
            if (ore.isTypeSet(EnumOreType.BLOCK) && ore.isTypeSet(EnumOreType.INGOT)) {
                HLCraftingHelper.addShapedOreRecipe(Blocks.BLOCK_ORE_BLOCK.getStack(1, ore.getMeta()),
                        "xxx",
                        "xxx",
                        "xxx",

                        'x', "ingot" + ore.getOreName()
                );
            }
        }
    }
}
