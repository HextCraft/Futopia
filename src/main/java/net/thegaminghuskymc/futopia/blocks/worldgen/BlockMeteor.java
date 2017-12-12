package net.thegaminghuskymc.futopia.blocks.worldgen;

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
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.Reference;
import net.thegaminghuskymc.futopia.blocks.BlockCore;
import net.thegaminghuskymc.futopia.blocks.IInitializer;
import net.thegaminghuskymc.futopia.blocks.IModelRegister;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.items.itemblocks.ItemBlockMeteor;

import javax.annotation.Nonnull;

import static net.thegaminghuskymc.futopia.utils.ItemHelper.registerWithHandlers;

public class BlockMeteor extends BlockCore implements IInitializer, IModelRegister {

	public static final PropertyEnum<Type> VARIANT = PropertyEnum.create("type", Type.class);
	/* REFERENCES */
	public static ItemStack meteor;
	public static ItemStack meteorBricks;

	public BlockMeteor() {
		super(Material.ROCK, Reference.MODID);

		setUnlocalizedName("meteor");
		setCreativeTab(FTCreativeTabs.world_gen);

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
	@SideOnly(Side.CLIENT)
	public void registerModels() {

        for (int i = 0; i < Type.values().length; i++) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), i, new ModelResourceLocation(modName + ":" + name, "type=" + Type.byMetadata(i).getName()));
        }
	}

	@Override
	public boolean initialize() {
		this.setRegistryName("meteor");
		ForgeRegistries.BLOCKS.register(this);

		ItemBlockMeteor itemBlock = new ItemBlockMeteor(this);
		itemBlock.setRegistryName(this.getRegistryName());
		ForgeRegistries.ITEMS.register(itemBlock);

		meteor = new ItemStack(this, 1, Type.NORMAL.getMetadata());
		meteorBricks = new ItemStack(this, 1, Type.BRICKS.getMetadata());

		registerWithHandlers("blockMeteor", meteor);
		registerWithHandlers("blockMeteorBricks", meteorBricks);

		Futopia.proxy.addIModelRegister(this);

		return true;
	}

	@Override
	public boolean register() {
		return true;
	}

	/* TYPE */
	public enum Type implements IStringSerializable {

		// @formatter:off
		NORMAL(0, "normal"),
		BRICKS(1, "bricks");

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