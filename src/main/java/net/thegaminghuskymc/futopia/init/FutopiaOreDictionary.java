package net.thegaminghuskymc.futopia.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.oredict.OreDictionary;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.IntStream;

public class FutopiaOreDictionary {

	public static void init() {
		IntStream.range(0, EnumMaterialType.values().length).forEach(meta -> registerWithHandlers("oreFutopia" + StringUtils.capitalize(EnumMaterialType.values()[meta].getName()),
				new ItemStack(FTBlocksAlt.ores, 1, meta)));
		IntStream.range(0, EnumMaterialType.values().length)
				.forEach(meta -> registerWithHandlers(
						"oreNetherFutopia" + StringUtils.capitalize(EnumMaterialType.values()[meta].getName()),
						new ItemStack(FTBlocksAlt.nether_ores, 1, meta)));
		IntStream.range(0, EnumMaterialType.values().length)
				.forEach(meta -> registerWithHandlers(
						"storageFutopia" + StringUtils.capitalize(EnumMaterialType.values()[meta].getName()),
						new ItemStack(FTBlocksAlt.storages, 1, meta)));

		IntStream.range(0, EnumMaterialType.values().length)
				.forEach(meta -> registerWithHandlers(
						"gearFutopia" + StringUtils.capitalize(EnumMaterialType.values()[meta].getName()),
						new ItemStack(FTItemsAlt.gears, 1, meta)));
		IntStream.range(0, EnumMaterialType.values().length)
				.forEach(meta -> registerWithHandlers(
						"alloyFutopia" + StringUtils.capitalize(EnumMaterialType.values()[meta].getName()),
						new ItemStack(FTItemsAlt.ingots, 1, meta)));
		IntStream.range(0, EnumMaterialType.values().length)
				.forEach(meta -> registerWithHandlers(
						"nuggetFutopia" + StringUtils.capitalize(EnumMaterialType.values()[meta].getName()),
						new ItemStack(FTItemsAlt.nuggets, 1, meta)));
		IntStream.range(0, EnumMaterialType.values().length)
				.forEach(meta -> registerWithHandlers(
						"dustFutopia" + StringUtils.capitalize(EnumMaterialType.values()[meta].getName()),
						new ItemStack(FTItemsAlt.dusts, 1, meta)));
		IntStream.range(0, EnumMaterialType.values().length)
				.forEach(meta -> registerWithHandlers(
						"shardFutopia" + StringUtils.capitalize(EnumMaterialType.values()[meta].getName()),
						new ItemStack(FTItemsAlt.shards, 1, meta)));
		IntStream.range(0, EnumMaterialType.values().length)
				.forEach(meta -> registerWithHandlers(
						"plateFutopia" + StringUtils.capitalize(EnumMaterialType.values()[meta].getName()),
						new ItemStack(FTItemsAlt.plates, 1, meta)));
	}

	private static void registerWithHandlers(String oreName, ItemStack stack) {
		OreDictionary.registerOre(oreName, stack);
		OreDictionary.doesOreNameExist(oreName);
		FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", stack);
	}

}
