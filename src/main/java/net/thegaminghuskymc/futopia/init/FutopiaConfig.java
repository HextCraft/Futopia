package net.thegaminghuskymc.futopia.init;

import keri.ninetaillib.lib.config.ConfigCategories;
import keri.ninetaillib.lib.config.ConfigProperties;
import keri.ninetaillib.lib.config.ModConfigHandler;
import keri.ninetaillib.lib.config.property.ConfigBoolean;
import keri.ninetaillib.lib.config.property.ConfigIntArray;
import keri.ninetaillib.lib.config.property.ConfigInteger;
import net.thegaminghuskymc.futopia.Refs;

@ModConfigHandler(modid = Refs.MODID, fileName = "Futopia")
public class FutopiaConfig {

	public static final String CATEGORY_CLIENT_N = "client";
	private static final String CATEGORY_CLIENT_D = "Config options related to the client side of Futopia";

	public static final String CATEGORY_INTEGRATION_N = "integration";
	private static final String CATEGORY_INTEGRATION_D = "Config options related to mod integration modules from Futopia";

	public static final String CATEGORY_WORLD_N = "world";
	private static final String CATEGORY_WORLD_D = "Config options related to world gen from Futopia";

	private static final String GUI_THEME_K = "guiTheme";
	private static final String GUI_THEME_C = "Change the color on the gui's";

	private static final String INTEGRATION_WAILA_K = "integrationWaila";
	private static final String INTEGRATION_WAILA_C = "Enable or disable WAILA integration";

	private static final String INTEGRATION_TE_K = "integrationThermalExpansion";
	private static final String INTEGRATION_TE_D = "Enable or disable Thermal Expansion integration";

	private static final String INTEGRATION_TF_K = "integrationThermalFoundation";
	private static final String INTEGRATION_TF_D = "Enable or disable Thermal Foundation integration";

	private static final String INTEGRATION_CHISEL_K = "integrationChisel";
	private static final String INTEGRATION_CHISEL_D = "Enable or disable Chisel integration";

	private static final String INTEGRATION_TIC_K = "integrationTConstruct";
	private static final String INTEGRATION_TIC_D = "Enable or disable Tinkers Construct integration";

	private static final String ORE_GEN_WEIGHT_K = "oreGenerationWeight";
	private static final String ORE_GEN_WEIGHT_C = "Change the ore generation weight (only modify when you know what you're doing!)";

	private static final String ORE_RED_K = "oreFutopiaRed";
	private static final String ORE_RED_C = "Chance, min height, max height, min vein size, max vein size";
	private static final String ORE_BLUE_K = "oreFutopiaBlue";
	private static final String ORE_BLUE_C = "Chance, min height, max height, min vein size, max vein size";
	private static final String ORE_PURPLE_K = "oreFutopiaPurple";
	private static final String ORE_PURPLE_C = "Chance, min height, max height, min vein size, max vein size";
	private static final String ORE_GREEN_K = "oreFutopiaGreen";
	private static final String ORE_GREEN_C = "Chance, min height, max height, min vein size, max vein size";
	private static final String ORE_ZINC_K = "oreFutopiaZinc";
	private static final String ORE_ZINC_C = "Chance, min height, max height, min vein size, max vein size";
	private static final String ORE_TUNGSTEN_K = "oreFutopiaTungsten";
	private static final String ORE_TUNGSTEN_C = "Chance, min height, max height, min vein size, max vein size";
	private static final String ORE_BRASS_K = "oreFutopiaBrass";
	private static final String ORE_BRASS_C = "Chance, min height, max height, min vein size, max vein size";
	private static final String ORE_TESSELITE_K = "oreFutopiaTesselite";
	private static final String ORE_TESSELITE_C = "Chance, min height, max height, min vein size, max vein size";
	private static final String ORE_PINK_K = "oreFutopiaPink";
	private static final String ORE_PINK_C = "Chance, min height, max height, min vein size, max vein size";
	private static final String ORE_YELLOW_K = "oreFutopiaYellow";
	private static final String ORE_YELLOW_C = "Chance, min height, max height, min vein size, max vein size";
	private static final String ORE_CYAN_K = "oreFutopiaCyan";
	private static final String ORE_CYAN_C = "Chance, min height, max height, min vein size, max vein size";
	private static final String ORE_LIGHT_BLUE_K = "oreFutopiaLightBlue";
	private static final String ORE_LIGHT_BLUE_C = "Chance, min height, max height, min vein size, max vein size";

	private static final String ORE_N_RED_K = "oreNetherFutopiaRed";
	private static final String ORE_N_RED_C = "Chance, min height, max height, min vein size, max vein size";
	private static final String ORE_N_BLUE_K = "oreNetherFutopiaBlue";
	private static final String ORE_N_BLUE_C = "Chance, min height, max height, min vein size, max vein size";
	private static final String ORE_N_PURPLE_K = "oreNetherFutopiaPurple";
	private static final String ORE_N_PURPLE_C = "Chance, min height, max height, min vein size, max vein size";
	private static final String ORE_N_GREEN_K = "oreNetherFutopiaGreen";
	private static final String ORE_N_GREEN_C = "Chance, min height, max height, min vein size, max vein size";
	private static final String ORE_N_ZINC_K = "oreNetherFutopiaZinc";
	private static final String ORE_N_ZINC_C = "Chance, min height, max height, min vein size, max vein size";
	private static final String ORE_N_TUNGSTEN_K = "oreNetherFutopiaTungsten";
	private static final String ORE_N_TUNGSTEN_C = "Chance, min height, max height, min vein size, max vein size";
	private static final String ORE_N_BRASS_K = "oreNetherFutopiaBrass";
	private static final String ORE_N_BRASS_C = "Chance, min height, max height, min vein size, max vein size";
	private static final String ORE_N_TESSELITE_K = "oreNetherFutopiaTesselite";
	private static final String ORE_N_TESSELITE_C = "Chance, min height, max height, min vein size, max vein size";
	private static final String ORE_N_PINK_K = "oreNetherFutopiaPink";
	private static final String ORE_N_PINK_C = "Chance, min height, max height, min vein size, max vein size";
	private static final String ORE_N_YELLOW_K = "oreNetherFutopiaYellow";
	private static final String ORE_N_YELLOW_C = "Chance, min height, max height, min vein size, max vein size";
	private static final String ORE_N_CYAN_K = "oreNetherFutopiaCyan";
	private static final String ORE_N_CYAN_C = "Chance, min height, max height, min vein size, max vein size";
	private static final String ORE_N_LIGHT_BLUE_K = "oreNetherFutopiaLightBlue";
	private static final String ORE_N_LIGHT_BLUE_C = "Chance, min height, max height, min vein size, max vein size";

	@ModConfigHandler.ConfigCategories
	public void addCategories(ConfigCategories categories) {
		categories.addCategory(CATEGORY_CLIENT_N, CATEGORY_CLIENT_D);
		categories.addCategory(CATEGORY_INTEGRATION_N, CATEGORY_INTEGRATION_D);
		categories.addCategory(CATEGORY_WORLD_N, CATEGORY_WORLD_D);
	}

	@ModConfigHandler.ConfigProperties
	public void addProperties(ConfigProperties properties) {
		properties.addProperty(GUI_THEME_K,
				new ConfigInteger(GUI_THEME_K, GUI_THEME_C, CATEGORY_CLIENT_N, 32, 16, 128));
		properties.addProperty(INTEGRATION_WAILA_K,
				new ConfigBoolean(INTEGRATION_WAILA_K, INTEGRATION_WAILA_C, CATEGORY_INTEGRATION_N, true));
		properties.addProperty(INTEGRATION_TE_K,
				new ConfigBoolean(INTEGRATION_TE_K, INTEGRATION_TE_D, CATEGORY_INTEGRATION_N, true));
		properties.addProperty(INTEGRATION_TF_K,
				new ConfigBoolean(INTEGRATION_TF_K, INTEGRATION_TF_D, CATEGORY_INTEGRATION_N, true));
		properties.addProperty(INTEGRATION_CHISEL_K,
				new ConfigBoolean(INTEGRATION_CHISEL_K, INTEGRATION_CHISEL_D, CATEGORY_INTEGRATION_N, true));
		properties.addProperty(INTEGRATION_TIC_K,
				new ConfigBoolean(INTEGRATION_TIC_K, INTEGRATION_TIC_D, CATEGORY_INTEGRATION_N, true));
		properties.addProperty(ORE_GEN_WEIGHT_K,
				new ConfigInteger(ORE_GEN_WEIGHT_K, ORE_GEN_WEIGHT_C, CATEGORY_WORLD_N, 1, 0, 10));

		properties.addProperty(ORE_RED_K,
				new ConfigIntArray(ORE_RED_K, CATEGORY_WORLD_N, ORE_RED_C, new int[] { 3, 20, 52, 4, 8 }));
		properties.addProperty(ORE_BLUE_K,
				new ConfigIntArray(ORE_BLUE_K, CATEGORY_WORLD_N, ORE_BLUE_C, new int[] { 3, 20, 52, 4, 8 }));
		properties.addProperty(ORE_PURPLE_K,
				new ConfigIntArray(ORE_PURPLE_K, CATEGORY_WORLD_N, ORE_PURPLE_C, new int[] { 3, 20, 52, 4, 8 }));
		properties.addProperty(ORE_GREEN_K,
				new ConfigIntArray(ORE_GREEN_K, CATEGORY_WORLD_N, ORE_GREEN_C, new int[] { 3, 20, 52, 4, 8 }));
		properties.addProperty(ORE_ZINC_K,
				new ConfigIntArray(ORE_ZINC_K, CATEGORY_WORLD_N, ORE_ZINC_C, new int[] { 3, 20, 52, 4, 8 }));
		properties.addProperty(ORE_TUNGSTEN_K,
				new ConfigIntArray(ORE_TUNGSTEN_K, CATEGORY_WORLD_N, ORE_TUNGSTEN_C, new int[] { 3, 20, 52, 4, 8 }));
		properties.addProperty(ORE_BRASS_K,
				new ConfigIntArray(ORE_BRASS_K, CATEGORY_WORLD_N, ORE_BRASS_C, new int[] { 3, 20, 52, 4, 8 }));
		properties.addProperty(ORE_TESSELITE_K,
				new ConfigIntArray(ORE_TESSELITE_K, CATEGORY_WORLD_N, ORE_TESSELITE_C, new int[] { 3, 20, 52, 4, 8 }));
		properties.addProperty(ORE_PINK_K,
				new ConfigIntArray(ORE_PINK_K, CATEGORY_WORLD_N, ORE_PINK_C, new int[] { 3, 20, 52, 4, 8 }));
		properties.addProperty(ORE_YELLOW_K,
				new ConfigIntArray(ORE_YELLOW_K, CATEGORY_WORLD_N, ORE_YELLOW_C, new int[] { 3, 20, 52, 4, 8 }));
		properties.addProperty(ORE_CYAN_K,
				new ConfigIntArray(ORE_CYAN_K, CATEGORY_WORLD_N, ORE_CYAN_C, new int[] { 3, 20, 52, 4, 8 }));
		properties.addProperty(ORE_LIGHT_BLUE_K, new ConfigIntArray(ORE_LIGHT_BLUE_K, CATEGORY_WORLD_N,
				ORE_LIGHT_BLUE_C, new int[] { 3, 20, 52, 4, 8 }));

		properties.addProperty(ORE_N_RED_K,
				new ConfigIntArray(ORE_N_RED_K, CATEGORY_WORLD_N, ORE_N_RED_C, new int[] { 2, 10, 122, 4, 7 }));
		properties.addProperty(ORE_N_BLUE_K,
				new ConfigIntArray(ORE_N_BLUE_K, CATEGORY_WORLD_N, ORE_N_BLUE_C, new int[] { 2, 10, 122, 4, 7 }));
		properties.addProperty(ORE_N_PURPLE_K,
				new ConfigIntArray(ORE_N_PURPLE_K, CATEGORY_WORLD_N, ORE_N_PURPLE_C, new int[] { 2, 10, 122, 4, 7 }));
		properties.addProperty(ORE_N_GREEN_K,
				new ConfigIntArray(ORE_N_GREEN_K, CATEGORY_WORLD_N, ORE_N_GREEN_C, new int[] { 2, 10, 122, 4, 7 }));
		properties.addProperty(ORE_N_ZINC_K,
				new ConfigIntArray(ORE_N_ZINC_K, CATEGORY_WORLD_N, ORE_N_ZINC_C, new int[] { 2, 10, 122, 4, 7 }));
		properties.addProperty(ORE_N_TUNGSTEN_K, new ConfigIntArray(ORE_N_TUNGSTEN_K, CATEGORY_WORLD_N,
				ORE_N_TUNGSTEN_C, new int[] { 2, 10, 122, 4, 7 }));
		properties.addProperty(ORE_N_BRASS_K,
				new ConfigIntArray(ORE_N_BRASS_K, CATEGORY_WORLD_N, ORE_N_BRASS_C, new int[] { 2, 10, 122, 4, 7 }));
		properties.addProperty(ORE_N_TESSELITE_K, new ConfigIntArray(ORE_N_TESSELITE_K, CATEGORY_WORLD_N,
				ORE_N_TESSELITE_C, new int[] { 2, 10, 122, 4, 7 }));
		properties.addProperty(ORE_N_PINK_K,
				new ConfigIntArray(ORE_N_PINK_K, CATEGORY_WORLD_N, ORE_N_PINK_C, new int[] { 2, 10, 122, 4, 7 }));
		properties.addProperty(ORE_N_YELLOW_K,
				new ConfigIntArray(ORE_N_YELLOW_K, CATEGORY_WORLD_N, ORE_N_YELLOW_C, new int[] { 2, 10, 122, 4, 7 }));
		properties.addProperty(ORE_N_CYAN_K,
				new ConfigIntArray(ORE_N_CYAN_K, CATEGORY_WORLD_N, ORE_N_CYAN_C, new int[] { 2, 10, 122, 4, 7 }));
		properties.addProperty(ORE_N_LIGHT_BLUE_K, new ConfigIntArray(ORE_N_LIGHT_BLUE_K, CATEGORY_WORLD_N,
				ORE_N_LIGHT_BLUE_C, new int[] { 2, 10, 122, 4, 7 }));
	}

}