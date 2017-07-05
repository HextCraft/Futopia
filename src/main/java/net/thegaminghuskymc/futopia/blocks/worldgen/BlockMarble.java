package net.thegaminghuskymc.futopia.blocks.worldgen;

import static cofh.core.util.helpers.ItemHelper.registerWithHandlers;

import javax.annotation.Nonnull;

import cofh.core.block.BlockCore;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.GameData;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.blocks.IInitializer;
import net.thegaminghuskymc.futopia.blocks.IModelRegister;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.items.itemblocks.ItemBlockMarble;

public class BlockMarble extends BlockCore implements IInitializer, IModelRegister {

    public static final PropertyEnum<Type> VARIANT = PropertyEnum.create("type", Type.class);

    public static ItemStack marble;
    public static ItemStack marblePaver;
    public static ItemStack marbleBrick;
    public static ItemStack marbleFancy;
    public static ItemStack marbleBrickSmall;
    public static ItemStack marbleTile;
    public static ItemStack marblePillar;

    public BlockMarble() {
        super(Material.ROCK, Refs.MODID);

        setUnlocalizedName("marble");
        setCreativeTab(FTCreativeTabs.main);
        setHardness(5.0F);
        setResistance(10.0F);
        setSoundType(SoundType.STONE);
        setDefaultState(getBlockState().getBaseState().withProperty(VARIANT, Type.RAW));

        setHarvestLevel("pickaxe", 2);
    }

    @Override
    protected BlockStateContainer createBlockState() {

        return new BlockStateContainer(this, VARIANT);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {

        for (int i = 0; i < Type.METADATA_LOOKUP.length; i++) {
            list.add(new ItemStack(this, 1, i));
        }
    }

    /* TYPE METHODS */
    @Override
    public IBlockState getStateFromMeta(int meta) {

        return this.getDefaultState().withProperty(VARIANT, Type.byMetadata(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {

        return state.getValue(VARIANT).getMetadata();
    }

    @Override
    public int damageDropped(IBlockState state) {

        return state.getValue(VARIANT).getMetadata();
    }

    @Nonnull
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.SOLID;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerModels() {

        for (int i = 0; i < Type.values().length; i++) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), i, new ModelResourceLocation(modName + ":" + name, "type=" + Type.byMetadata(i).getName()));
        }
    }

    @Override
    public boolean preInit() {
        setRegistryName("marble");
        GameData.register_impl(this);

        ItemBlockMarble itemBlock = new ItemBlockMarble(this);
        itemBlock.setRegistryName(this.getRegistryName());
        GameData.register_impl(itemBlock);

        marble = new ItemStack(this, 1, Type.RAW.getMetadata());
        marblePaver = new ItemStack(this, 1, Type.PAVER.getMetadata());
        marbleBrick = new ItemStack(this, 1, Type.BRICK.getMetadata());
        marbleFancy = new ItemStack(this, 1, Type.FANCY.getMetadata());
        marbleBrickSmall = new ItemStack(this, 1, Type.BRICK_SMALL.getMetadata());
        marbleTile = new ItemStack(this, 1, Type.TILE.getMetadata());
        marblePillar = new ItemStack(this, 1, Type.PILLAR.getMetadata());

        registerWithHandlers("blockMarble", marble);
        registerWithHandlers("blockMarblePaver", marblePaver);
        registerWithHandlers("blockMarbleBrick", marbleBrick);
        registerWithHandlers("blockMarbleFancy", marbleFancy);
        registerWithHandlers("blockMarbleBrickSmall", marbleBrickSmall);
        registerWithHandlers("blockMarbleTile", marbleTile);
        registerWithHandlers("blockMarblePillar", marblePillar);

        return true;
    }

    @Override
    public boolean initialize() {
        return false;
    }

    @Override
    public boolean postInit() {
        return false;
    }

    public enum Type implements IStringSerializable {

        RAW(0, "raw"),
        PAVER(1, "paver"),
        BRICK(2, "brick"),
        FANCY(3, "fancy"),
        BRICK_SMALL(4, "brick_small"),
        TILE(5, "tile"),
        PILLAR(6, "pillar");

        private static final Type[] METADATA_LOOKUP = new Type[values().length];

        static {
            for (Type type : values()) {
                METADATA_LOOKUP[type.getMetadata()] = type;
            }
        }

        private final int metadata;
        private final String name;
        private final int light;
        private final float hardness;
        private final float resistance;

        Type(int metadata, String name, int light, float hardness, float resistance) {

            this.metadata = metadata;
            this.name = name;
            this.light = light;
            this.hardness = hardness;
            this.resistance = resistance;
        }

        Type(int metadata, String name, float hardness, float resistance) {
            this(metadata, name, 0, hardness, resistance);
        }

        Type(int metadata, String name, int light) {

            this(metadata, name, light, 5.0F, 6.0F);
        }

        Type(int metadata, String name) {

            this(metadata, name, 0, 5.0F, 6.0F);
        }

        public static Type byMetadata(int metadata) {

            if (metadata < 0 || metadata >= METADATA_LOOKUP.length) {
                metadata = 0;
            }
            return METADATA_LOOKUP[metadata];
        }

        public int getMetadata() {
            return this.metadata;
        }

        @Override
        public String getName() {

            return this.name;
        }

        public int getLight() {

            return this.light;
        }

        public float getHardness() {

            return this.hardness;
        }

        public float getResistance() {

            return this.resistance;
        }
    }

}