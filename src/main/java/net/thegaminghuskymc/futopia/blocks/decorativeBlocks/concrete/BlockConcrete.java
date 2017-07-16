package net.thegaminghuskymc.futopia.blocks.decorativeBlocks.concrete;

import static cofh.core.util.helpers.ItemHelper.registerWithHandlers;

import java.util.List;

import javax.annotation.Nonnull;

import com.mojang.realmsclient.gui.ChatFormatting;

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
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.GameData;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.blocks.IInitializer;
import net.thegaminghuskymc.futopia.blocks.IModelRegister;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.items.itemblocks.ItemBlockConcrete;
import net.thegaminghuskymc.futopia.utils.Names;
import net.thegaminghuskymc.futopia.utils.RandomThings;

public class BlockConcrete extends BlockCore implements IInitializer, IModelRegister {

	public static final PropertyEnum<Type> VARIANT = PropertyEnum.create("type", Type.class);
	/* REFERENCES */
	public static ItemStack concrete;
	public static ItemStack concreteArrangedBricks;
	public static ItemStack concreteBricks;
	public static ItemStack concreteBricksDark;
	public static ItemStack concreteFanzyBricks;
	public static ItemStack concreteOldSquares;
	public static ItemStack concreteRocks;
	public static ItemStack concreteSmallBricks;

	public BlockConcrete() {
		super(Material.ROCK, Refs.MODID);

		setUnlocalizedName("concrete");
		setCreativeTab(FTCreativeTabs.main);
		setHardness(5.0F);
		setResistance(10.0F);
		setSoundType(SoundType.STONE);
		setDefaultState(getBlockState().getBaseState().withProperty(VARIANT, Type.NORMAL));

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

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Nonnull
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.SOLID;
	}

	@Override
	public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) {
		if (!GuiScreen.isShiftKeyDown()) {
			tooltip.add("Hold " + ChatFormatting.YELLOW + "Shift" + ChatFormatting.GRAY + " for Crafting.");
		} else {
			/*
			 * tooltip.add(Names.CraftingToolTips.CRAFT_WITH);
			 * tooltip.add(Names.CraftingToolTips.CONCRETE_BLOCKS);
			 */
			tooltip.add(Names.HelpToolTips.WIP_BLOCK);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerModels() {

		for (int i = 0; i < Type.values().length; i++) {
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), i,
					new ModelResourceLocation(modName + ":" + name, "type=" + Type.byMetadata(i).getName()));
		}
	}

	@Override
	public boolean preInit() {
		this.setRegistryName("concrete");
		GameData.register_impl(this);

		ItemBlockConcrete itemBlock = new ItemBlockConcrete(this);
		itemBlock.setRegistryName(this.getRegistryName());
		GameData.register_impl(itemBlock);

		concrete = new ItemStack(this, 1, Type.NORMAL.getMetadata());
		concreteArrangedBricks = new ItemStack(this, 1, Type.ARRANGED_BRICK.getMetadata());
		concreteBricks = new ItemStack(this, 1, Type.BRICK.getMetadata());
		concreteBricksDark = new ItemStack(this, 1, Type.BRICK_DARK.getMetadata());
		concreteFanzyBricks = new ItemStack(this, 1, Type.FANCY_BRICK.getMetadata());
		concreteOldSquares = new ItemStack(this, 1, Type.OLD_SQUARES.getMetadata());
		concreteRocks = new ItemStack(this, 1, Type.ROCKS.getMetadata());
		concreteSmallBricks = new ItemStack(this, 1, Type.SMALL_BRICKS.getMetadata());

		registerWithHandlers(RandomThings.ModBlocks.CONCRETE.getUnlocalizedName(), concrete);
		registerWithHandlers(RandomThings.ModBlocks.CONCRETE_ARRANGED_BRICKS.getUnlocalizedName(),
				concreteArrangedBricks);
		registerWithHandlers(RandomThings.ModBlocks.CONCRETE_BRICKS.getUnlocalizedName(), concreteBricks);
		registerWithHandlers(RandomThings.ModBlocks.CONCRETE_BRICKS_DARK.getUnlocalizedName(), concreteBricksDark);
		registerWithHandlers(RandomThings.ModBlocks.CONCRETE_FANCY_BLOCKS.getUnlocalizedName(), concreteFanzyBricks);
		registerWithHandlers(RandomThings.ModBlocks.CONCRETE_OLD_SQUARES.getUnlocalizedName(), concreteOldSquares);
		registerWithHandlers(RandomThings.ModBlocks.CONCRETE_ROCKS.getUnlocalizedName(), concreteRocks);
		registerWithHandlers(RandomThings.ModBlocks.CONCRETE_SMALL_BRICKS.getUnlocalizedName(), concreteSmallBricks);

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

	/* TYPE */
	public enum Type implements IStringSerializable {

		// @formatter:off
		NORMAL(0, "normal"), ARRANGED_BRICK(1, "arranged_brick"), BRICK(2, "brick"), BRICK_DARK(3,
				"brick_dark"), FANCY_BRICK(4, "fancy_brick"), OLD_SQUARES(5,
						"old_squares"), ROCKS(6, "rocks"), SMALL_BRICKS(7, "small_bricks");
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