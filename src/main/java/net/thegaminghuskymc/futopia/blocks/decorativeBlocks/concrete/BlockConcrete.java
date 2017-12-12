package net.thegaminghuskymc.futopia.blocks.decorativeBlocks.concrete;

import com.mojang.realmsclient.gui.ChatFormatting;
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
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.Reference;
import net.thegaminghuskymc.futopia.blocks.BlockCore;
import net.thegaminghuskymc.futopia.blocks.IInitializer;
import net.thegaminghuskymc.futopia.blocks.IModelRegister;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.items.itemblocks.ItemBlockConcrete;
import net.thegaminghuskymc.futopia.utils.Names;

import javax.annotation.Nonnull;
import java.util.List;

import static net.thegaminghuskymc.futopia.utils.ItemHelper.registerWithHandlers;

public class BlockConcrete extends BlockCore implements IInitializer, IModelRegister {

	public static final PropertyEnum<Type> VARIANT = PropertyEnum.create("type", Type.class);
	/* REFERENCES */
	public static ItemStack concrete;
	public static ItemStack concreteArrangedBricks;
	public static ItemStack concreteBricks;
	public static ItemStack concreteBricksDark;
	public static ItemStack concreteFancyBricks;
	public static ItemStack concreteOldSquares;
	public static ItemStack concreteRocks;
	public static ItemStack concreteSmallBricks;

	public BlockConcrete() {
		super(Material.ROCK, Reference.MODID);

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
	public boolean initialize() {
		this.setRegistryName("concrete");
		ForgeRegistries.BLOCKS.register(this);

		ItemBlockConcrete itemBlock = new ItemBlockConcrete(this);
		itemBlock.setRegistryName(this.getRegistryName());
		ForgeRegistries.ITEMS.register(itemBlock);

		concrete = new ItemStack(this, 1, Type.NORMAL.getMetadata());
		concreteArrangedBricks = new ItemStack(this, 1, Type.ARRANGED_BRICK.getMetadata());
		concreteBricks = new ItemStack(this, 1, Type.BRICK.getMetadata());
		concreteBricksDark = new ItemStack(this, 1, Type.BRICK_DARK.getMetadata());
		concreteFancyBricks = new ItemStack(this, 1, Type.FANCY_BRICK.getMetadata());
		concreteOldSquares = new ItemStack(this, 1, Type.OLD_SQUARES.getMetadata());
		concreteRocks = new ItemStack(this, 1, Type.ROCKS.getMetadata());
		concreteSmallBricks = new ItemStack(this, 1, Type.SMALL_BRICKS.getMetadata());

		registerWithHandlers("blockConcrete", concrete);
		registerWithHandlers("blockConcreteArrangedBricks", concreteArrangedBricks);
		registerWithHandlers("blockConcreteBricks", concreteBricks);
		registerWithHandlers("blockConcreteBricksDark", concreteBricksDark);
		registerWithHandlers("blockConcreteFancyBricks", concreteFancyBricks);
		registerWithHandlers("blockConcreteOldSquares", concreteOldSquares);
		registerWithHandlers("blockConcreteRocks", concreteRocks);
		registerWithHandlers("blockConcreteSmallBricks", concreteSmallBricks);

		Futopia.proxy.addIModelRegister(this);

		return true;
	}

	@Override
	public boolean register() {
		return false;
	}

	/* TYPE */
	public enum Type implements IStringSerializable {

		// @formatter:off
		NORMAL(0, "normal"), 
		ARRANGED_BRICK(1, "arranged_brick"), 
		BRICK(2, "brick"), 
		BRICK_DARK(3, "brick_dark"), 
		FANCY_BRICK(4, "fancy_brick"), 
		OLD_SQUARES(5, "old_squares"), 
		ROCKS(6, "rocks"), 
		SMALL_BRICKS(7, "small_bricks");
		// @formatter: on

		private static final Type[] METADATA_LOOKUP = new Type[values().length];

		static {
			for (Type type : values()) {
				METADATA_LOOKUP[type.getMetadata()] = type;
			}
		}

		private final int metadata;
		private final String name;

		Type(int metadata, String name) {

			this.metadata = metadata;
			this.name = name;
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

	}

}