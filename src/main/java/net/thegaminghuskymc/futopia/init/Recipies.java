package net.thegaminghuskymc.futopia.init;

import cofh.core.util.helpers.RecipeHelper;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.huskylib.utils.HLCraftingHelper;

@SuppressWarnings("unused")
public class Recipies {

	public static void init() {
		addSawRecipes();
		addHammerRecipes();
		addDustRecipes();
		addPlateRecipes();
		addBlockRecipes();
		addItemRecipes();
	}

	private static void addSawRecipes() {
		registerSaws(EnumMaterialType.VALUES);
	}

	private static void addHammerRecipes() {
		registerHammers(EnumMaterialType.VALUES);
	}

	private static void addPlateRecipes() {
		registerPlates(EnumMaterialType.VALUES);
	}

	private static void addDustRecipes() {
		registerDusts(EnumMaterialType.VALUES);
	}

	private static void addNuggetRecipes() {
		registerNuggets(EnumMaterialType.VALUES);
	}

	private static void addItemRecipes() {
		registerGears(EnumMaterialType.VALUES);
		registerSmeltingDusts(EnumMaterialType.VALUES);
	}

	private static void addBlockRecipes() {
		addBlockRecipe(new ItemStack(FTBlocks.particleSummoner), new Object[] { "RBG", "GRB", "BGR", 'B',
				"alloyFutopiaBlue", 'R', "alloyFutopiaRed", 'G', "alloyFutopiaGreen" });

		registerSmeltingOres(EnumMaterialType.VALUES);
		registerStorageBlocks(EnumMaterialType.VALUES);
		registerReversedStorageBlocks(EnumMaterialType.VALUES);
	}

	public static void registerSmeltingOres(EnumMaterialType... types) {

		for (EnumMaterialType type : types) {
			RecipeHelper.addSmelting(new ItemStack(FTBlocks.ores, 1, type.getMeta()),
					new ItemStack(FTItems.ingots, 1, type.getMeta()), 0.0F);
		}

	}

	public static void registerSmeltingDusts(EnumMaterialType... types) {

		for (EnumMaterialType type : types) {
			addSmelting(new ItemStack(FTItems.dusts, 9, type.getMeta()),
					new ItemStack(FTItems.ingots, 1, type.getMeta()), 0.0F);
		}

	}

	public static void registerStorageBlocks(EnumMaterialType... types) {

		for (EnumMaterialType type : types) {
			RecipeHelper.addStorageRecipe(new ItemStack(FTBlocks.storages, 1, type.getMeta()),
					new ItemStack(FTItems.ingots, 1, type.getMeta()));
		}

	}

	public static void registerReversedStorageBlocks(EnumMaterialType... types) {

		for (EnumMaterialType type : types) {
			RecipeHelper.addReverseStorageRecipe(new ItemStack(FTItems.ingots, 1, type.getMeta()),
					new ItemStack(FTBlocks.storages, 1, type.getMeta()));
		}

	}

	public static void registerGears(EnumMaterialType... types) {

		for (EnumMaterialType type : types) {
			addGearRecipe(new ItemStack(FTItems.gears, 1, type.getMeta()),
					new ItemStack(FTItems.ingots, 1, type.getMeta()));
		}

	}

	public static void registerNuggets(EnumMaterialType... types) {

		for (EnumMaterialType type : types) {
			addNuggetRecipe(new ItemStack(FTItems.nuggets, 4, type.getMeta()),
					new ItemStack(FTItems.ingots, 1, type.getMeta()));
		}

	}

	public static void registerDusts(EnumMaterialType... types) {

		for (EnumMaterialType type : types) {
			addDustRecipe(new ItemStack(FTItems.dusts, 4, type.getMeta()),
					new ItemStack(FTItems.ingots, 1, type.getMeta()));
		}

	}

	public static void registerPlates(EnumMaterialType... types) {

		for (EnumMaterialType type : types) {
			addPlateRecipe(new ItemStack(FTItems.plates, 1, type.getMeta()),
					new ItemStack(FTItems.ingots, 1, type.getMeta()));
		}

	}

	public static void registerSaws(EnumMaterialType... types) {

		for (EnumMaterialType type : types) {
			addSawRecipe(new ItemStack(FTItems.saw, 1, type.getMeta()),
					new ItemStack(FTItems.ingots, 1, type.getMeta()));
		}

	}

	public static void registerHammers(EnumMaterialType... types) {

		for (EnumMaterialType type : types) {
			addSawRecipe(new ItemStack(FTItems.hammer, 1, type.getMeta()),
					new ItemStack(FTItems.ingots, 1, type.getMeta()));
		}

	}

	private static void addBlockRecipe(Block block, String material) {
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(block), new Object[] { "AAA", "AAA", "AAA", 'A', material });
	}

	private static void addBlockRecipe(ItemStack out, Object[] recipe) {
		HLCraftingHelper.addShapedOreRecipe(out, recipe);
	}

	private static void addBlockRecipe(Block block, Item material) {
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(block), new Object[] { "AAA", "AAA", "AAA", 'A', material });
	}

	private static void addBlockRecipe(ItemStack material, ItemStack block) {
		HLCraftingHelper.addShapedOreRecipe(block, new Object[] { "AAA", "AAA", "AAA", 'A', material });
	}

	private static void addToolsetRecipe(Item[] toolset, String material) {
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(toolset[0]), " X ", " X ", " C ", 'X', material, 'C',
				Items.STICK);
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(toolset[1]), "XXX", " C ", " C ", 'X', material, 'C',
				Items.STICK);
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(toolset[2]), " X ", " C ", " C ", 'X', material, 'C',
				Items.STICK);
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(toolset[3]), "XX ", "XC ", " C ", 'X', material, 'C',
				Items.STICK);
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(toolset[4]), "XX ", " C ", " C ", 'X', material, 'C',
				Items.STICK);
	}

	private static void addGearRecipe(ItemStack gear, String material) {
		HLCraftingHelper.addShapedOreRecipe(gear, " X ", "XCX", " X ", 'X', material, 'C', Items.IRON_INGOT);
	}

	private static void addGearRecipe(ItemStack gear, ItemStack material) {
		HLCraftingHelper.addShapedOreRecipe(gear, " X ", "XCX", " X ", 'X', material, 'C', Items.IRON_INGOT);
	}

	private static void addPlateRecipe(ItemStack plates, String material) {
		HLCraftingHelper.addShapedOreRecipe(plates, "XX ", "XX ", 'X', material);
	}

	private static void addPlateRecipe(ItemStack plates, Item material) {
		HLCraftingHelper.addShapedOreRecipe(plates, "XX ", "XX ", 'X', material);
	}

	private static void addPlateRecipe(ItemStack plates, ItemStack material) {
		HLCraftingHelper.addShapedOreRecipe(plates, "XX ", "XX ", 'X', material);
	}

	private static void addDustRecipe(ItemStack dusts, String material) {
		HLCraftingHelper.addShapedOreRecipe(dusts, " X ", 'X', material);
	}

	private static void addDustRecipe(ItemStack dusts, ItemStack material) {
		HLCraftingHelper.addShapedOreRecipe(dusts, " X ", 'X', material);
	}

	private static void addNuggetRecipe(ItemStack nuggets, String material) {
		HLCraftingHelper.addShapedOreRecipe(nuggets, " X ", 'X', material);
	}

	private static void addNuggetRecipe(ItemStack nuggets, ItemStack material) {
		HLCraftingHelper.addShapedOreRecipe(nuggets, " X ", 'X', material);
	}

	private static void addHammerRecipe(ItemStack hammers, String material) {
		HLCraftingHelper.addShapedOreRecipe(hammers, "XCX", "XCX", " C ", 'X', material, 'C', Items.STICK);
	}

	private static void addHammerRecipe(ItemStack hammers, ItemStack material) {
		HLCraftingHelper.addShapedOreRecipe(hammers, "XCX", "XCX", " C ", 'X', material, 'C', Items.STICK);
	}

	private static void addSawRecipe(ItemStack saws, String material) {
		Block P = Blocks.PLANKS;
		HLCraftingHelper.addShapedOreRecipe(saws, new Object[] { "XX ", " XP", "  P", 'X', material, 'P', P });
	}

	private static void addSawRecipe(ItemStack saws, ItemStack material) {
		Block P = Blocks.PLANKS;
		HLCraftingHelper.addShapedOreRecipe(saws, new Object[] { "XX ", " XP", "  P", 'X', material, 'P', P });
	}

	private static void addArmorsetRecipe(Item[] armorset, String material) {
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(armorset[0]), "XXX", "X X", "   ", 'X', material);
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(armorset[1]), "X X", "XXX", "XXX", 'X', material);
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(armorset[2]), "XXX", "X X", "X X", 'X', material);
		HLCraftingHelper.addShapedOreRecipe(new ItemStack(armorset[3]), "   ", "X X", "X X", 'X', material);
	}

	public static ItemStack cloneStack(Item item, int stackSize) {
		if (item == null)
			return null;
		else
			return new ItemStack(item, stackSize);
	}

	public static ItemStack cloneStack(Block item, int stackSize) {
		if (item == null)
			return null;
		else
			return new ItemStack(item, stackSize);
	}

	public static ItemStack cloneStack(ItemStack stack, int stackSize) {
		if (stack == null) {
			return null;
		} else {
			ItemStack retStack = stack.copy();
			retStack.getCount();
			return retStack;
		}
	}

	public static ItemStack cloneStack(ItemStack stack) {
		return stack != null ? stack.copy() : null;
	}

	public static boolean addSmelting(ItemStack out, Item in) {
		if ((out == null) | (in == null)) {
			return false;
		} else {
			FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), 0.0F);
			return true;
		}
	}

	public static boolean addSmelting(ItemStack out, Block in) {
		if ((out == null) | (in == null)) {
			return false;
		} else {
			FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), 0.0F);
			return true;
		}
	}

	public static boolean addSmelting(ItemStack out, ItemStack in) {
		if ((out == null) | (in == null)) {
			return false;
		} else {
			FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), 0.0F);
			return true;
		}
	}

	public static boolean addSmelting(ItemStack out, Item in, float XP) {
		if ((out == null) | (in == null)) {
			return false;
		} else {
			FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), XP);
			return true;
		}
	}

	public static boolean addSmelting(ItemStack out, Block in, float XP) {
		if ((out == null) | (in == null)) {
			return false;
		} else {
			FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), XP);
			return true;
		}
	}

	public static boolean addSmelting(ItemStack out, ItemStack in, float XP) {
		if ((out == null) | (in == null)) {
			return false;
		} else {
			FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), XP);
			return true;
		}
	}

}
