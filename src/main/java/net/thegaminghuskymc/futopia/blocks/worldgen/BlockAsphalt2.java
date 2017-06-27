package net.thegaminghuskymc.futopia.blocks.worldgen;

import java.util.List;

import cofh.core.block.BlockCore;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.blocks.IInitializer;
import net.thegaminghuskymc.futopia.blocks.IModelRegister;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.utils.Names;

public class BlockAsphalt2 extends BlockCore implements IInitializer, IModelRegister{
	
	public static final PropertyEnum<Type> VARIANT = PropertyEnum.create("type", Type.class);
	
	public static ItemStack asphalt;
    public static ItemStack asphaltMiddleWhite;
    public static ItemStack asphaltMiddleYellow;
    public static ItemStack asphaltMiddle;
    public static ItemStack asphaltSide;
    public static ItemStack asphaltSideYellow;
    public static ItemStack asphaltSideWhite;
    public static ItemStack asphaltSidewalk;
    public static ItemStack asphaltMiddleWhiteGlowing;
    public static ItemStack asphaltMiddleYellowGlowing;
    public static ItemStack asphaltSideYellowGlowing;
    public static ItemStack asphaltSideWhiteGlowing;
    public static ItemStack asphaltSidewalkGlowing;

    public BlockAsphalt2() {
        super(Material.ROCK, Refs.MODID);

        setUnlocalizedName("asphalt");
        setCreativeTab(FTCreativeTabs.main);

        setSoundType(SoundType.STONE);
        setDefaultState(getBlockState().getBaseState().withProperty(VARIANT, Type.RAW));
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

    @Override
    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) {
        if (!GuiScreen.isShiftKeyDown()) {
            tooltip.add(Names.HelpToolTips.SHIFT_FOR_INFO);
        } else {
        	tooltip.add(Names.HelpToolTips.WIP_BLOCK);
        }
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
		return false;
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

        // @formatter:off
        RAW(0, "raw"),
        MIDDLE(1, "middle"),
        MIDDLE_WHITE(2, "middle_white"),
        MIDDLE_YELLOW(3, "middle_yellow"),
        MIDDLE_WHITE_GLOWING(4, "middle_white_glowing"),
        MIDDLE_YELLOW_GLOWING(5, "middle_yellow_glowing"),
        SIDE(1, "side"),
        SIDE_WHITE(2, "side_white"),
        SIDE_YELLOW(3, "side_yellow"),
        SIDE_WHITE_GLOWING(4, "side_white_glowing"),
        SIDE_YELLOW_GLOWING(5, "side_yellow_glowing"),
        SIDEWALK(5, "sidewalk"),
        SIDEWALK_GLOWING(5, "sidewalk_glowing");
        // @formatter: on

        private static final Type[] METADATA_LOOKUP = new Type[values().length];

        static {
            for (Type type : values()) {
                METADATA_LOOKUP[type.getMetadata()] = type;
            }
        }

        private final int metadata;
        private final String name;
        private final int light;
        private final boolean glowing;
        private final float hardness;
        private final float resistance;

        Type(int metadata, String name, boolean glowing, int light, float hardness, float resistance) {

            this.metadata = metadata;
            this.name = name;
            this.light = light;
            this.glowing = glowing;
            this.hardness = hardness;
            this.resistance = resistance;
        }

        Type(int metadata, String name, float hardness, float resistance) {
            this(metadata, name, false, 0, hardness, resistance);
        }
        
        Type(int metadata, String name, boolean glowing) {
            this(metadata, name, glowing, 0, 5.0F, 6.0F);
        }

        Type(int metadata, String name, int light) {

            this(metadata, name, false, light, 5.0F, 6.0F);
        }

        Type(int metadata, String name) {

            this(metadata, name, false, 0, 5.0F, 6.0F);
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
        
        public boolean isGlowing(){
        	return this.glowing;
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
