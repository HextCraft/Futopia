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
import net.thegaminghuskymc.futopia.network.EnumAlloys;
import net.thegaminghuskymc.futopia.network.EnumOreType;
import net.thegaminghuskymc.futopia.utils.test.interfaces.IProvideRecipe;
import net.thegaminghuskymc.huskylib.utils.HLCraftingHelper;

public class BlockAlloyBlock extends BlockBase implements IProvideRecipe {

    public static final PropertyEnum<EnumAlloys> MATERIAL = PropertyEnum.create("material", EnumAlloys.class);

    public BlockAlloyBlock() {
        super(Material.ROCK, "ores/oreBlock");
        this.setDefaultState(this.blockState.getBaseState().withProperty(MATERIAL, EnumAlloys.byMeta(0)));
        this.setCreativeTab(FTCreativeTabs.main);
        this.setInternalName("alloy_block");
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(MATERIAL, EnumAlloys.byMeta(meta));
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
        for (int i = 0; i < EnumAlloys.values().length; i++) {
            if (EnumAlloys.byMeta(i).isTypeSet(EnumOreType.BLOCK)) {
                list.add(new ItemStack(this, 1, i));
            }
        }
    }

    @Override
    public void RegisterRecipes() {
        for (EnumAlloys ore : EnumAlloys.values()) {
            if (ore.isTypeSet(EnumOreType.BLOCK) && ore.isTypeSet(EnumOreType.INGOT)) {
            	HLCraftingHelper.addShapedOreRecipe(Blocks.BLOCK_ALLOY_BLOCK.getStack(1, ore.getMeta()),
                        "xxx",
                        "xxx",
                        "xxx",

                        'x', "ingot" + ore.getAlloyName()
                );
            }
        }
    }
}