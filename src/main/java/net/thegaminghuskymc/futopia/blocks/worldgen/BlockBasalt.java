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
import net.thegaminghuskymc.futopia.items.itemblocks.ItemBlockBasalt;

import static net.thegaminghuskymc.futopia.utils.ItemHelper.registerWithHandlers;

public class BlockBasalt extends BlockCore implements IInitializer, IModelRegister {

	public static final PropertyEnum<Type> VARIANT = PropertyEnum.create("type", Type.class);
	/* REFERENCES */
	public static ItemStack basalt;
	public static ItemStack basaltCobble;
	public static ItemStack basaltPaver;
	public static ItemStack basaltBrick;
	public static ItemStack basaltFancy;
	public static ItemStack basaltCrackedLava;
	public static ItemStack basaltBrickCracked;
	public static ItemStack basaltBrickSmall;
	public static ItemStack basaltTile;
	public static ItemStack basaltPillar;

	public BlockBasalt() {
		super(Material.ROCK, Reference.MODID);

		setUnlocalizedName("basalt");
		setCreativeTab(FTCreativeTabs.world_gen);

		setSoundType(SoundType.STONE);
		setDefaultState(getBlockState().getBaseState().withProperty(VARIANT, Type.RAW));
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
	@SideOnly(Side.CLIENT)
	public void registerModels() {

		for (int i = 0; i < Type.values().length; i++) {
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), i, new ModelResourceLocation(modName + ":" + name, "type=" + Type.byMetadata(i).getName()));
		}

	}

	@Override
	public boolean initialize() {

		setRegistryName("basalt");
		ForgeRegistries.BLOCKS.register(this);

		ItemBlockBasalt itemBlock = new ItemBlockBasalt(this);
		itemBlock.setRegistryName(this.getRegistryName());
		ForgeRegistries.ITEMS.register(itemBlock);

		basalt = new ItemStack(this, 1, Type.RAW.getMetadata());
		basaltCobble = new ItemStack(this, 1, Type.COBBLE.getMetadata());
		basaltPaver = new ItemStack(this, 1, Type.PAVER.getMetadata());
		basaltBrick = new ItemStack(this, 1, Type.BRICK.getMetadata());
		basaltFancy = new ItemStack(this, 1, Type.FANCY.getMetadata());
		basaltCrackedLava = new ItemStack(this, 1, Type.CRACKED_LAVA.getMetadata());
		basaltBrickCracked = new ItemStack(this, 1, Type.BRICK_CRACKED.getMetadata());
		basaltBrickSmall = new ItemStack(this, 1, Type.BRICK_SMALL.getMetadata());
		basaltTile = new ItemStack(this, 1, Type.TILE.getMetadata());
        basaltPillar = new ItemStack(this, 1, Type.PILLAR.getMetadata());

		registerWithHandlers("blockBasalt", basalt);
		registerWithHandlers("blockBasaltCobble", basaltCobble);
		registerWithHandlers("blockBasaltPaver", basaltPaver);
		registerWithHandlers("blockBasaltBrick", basaltBrick);
		registerWithHandlers("blockBasaltFancy", basaltFancy);
		registerWithHandlers("blockBasaltCrackedLava", basaltCrackedLava);
		registerWithHandlers("blockBasaltBrickCracked", basaltBrickCracked);
		registerWithHandlers("blockBasaltBrickSmall", basaltBrickSmall);
		registerWithHandlers("blockBasaltTile", basaltTile);
		registerWithHandlers("blockBasaltPillar", basaltPillar);

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
		RAW(0, "raw"),
		COBBLE(1, "cobble"),
		PAVER(2, "paver"),
		BRICK(3, "brick"),
		FANCY(4, "fancy"),
		CRACKED_LAVA(5, "cracked_lava"),
		BRICK_CRACKED(6, "brick_cracked"),
		BRICK_SMALL(7, "brick_small"),
		TILE(8, "tile"),
        PILLAR(9, "pillar");
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