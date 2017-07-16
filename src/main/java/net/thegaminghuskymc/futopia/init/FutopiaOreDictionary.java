package net.thegaminghuskymc.futopia.init;

import java.util.stream.IntStream;

import org.apache.commons.lang3.StringUtils;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.oredict.OreDictionary;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;

public class FutopiaOreDictionary {

	public static void init() {
		IntStream.range(0, EnumMaterialType.values().length)
				.forEach(meta -> registerWithHandlers(
						"oreFutopia" + StringUtils.capitalize(EnumMaterialType.values()[meta].getName()),
						new ItemStack(FTBlocks.ores, 1, meta)));
		IntStream.range(0, EnumMaterialType.values().length)
				.forEach(meta -> registerWithHandlers(
						"oreNetherFutopia" + StringUtils.capitalize(EnumMaterialType.values()[meta].getName()),
						new ItemStack(FTBlocks.nether_ores, 1, meta)));
		IntStream.range(0, EnumMaterialType.values().length)
				.forEach(meta -> registerWithHandlers(
						"storageFutopia" + StringUtils.capitalize(EnumMaterialType.values()[meta].getName()),
						new ItemStack(FTBlocks.storages, 1, meta)));

		IntStream.range(0, EnumMaterialType.values().length)
				.forEach(meta -> registerWithHandlers(
						"gearFutopia" + StringUtils.capitalize(EnumMaterialType.values()[meta].getName()),
						new ItemStack(FTItems.gears, 1, meta)));
		IntStream.range(0, EnumMaterialType.values().length)
				.forEach(meta -> registerWithHandlers(
						"alloyFutopia" + StringUtils.capitalize(EnumMaterialType.values()[meta].getName()),
						new ItemStack(FTItems.ingots, 1, meta)));
		IntStream.range(0, EnumMaterialType.values().length)
				.forEach(meta -> registerWithHandlers(
						"nuggetFutopia" + StringUtils.capitalize(EnumMaterialType.values()[meta].getName()),
						new ItemStack(FTItems.nuggets, 1, meta)));
		IntStream.range(0, EnumMaterialType.values().length)
				.forEach(meta -> registerWithHandlers(
						"dustFutopia" + StringUtils.capitalize(EnumMaterialType.values()[meta].getName()),
						new ItemStack(FTItems.dusts, 1, meta)));
		IntStream.range(0, EnumMaterialType.values().length)
				.forEach(meta -> registerWithHandlers(
						"shardFutopia" + StringUtils.capitalize(EnumMaterialType.values()[meta].getName()),
						new ItemStack(FTItems.shards, 1, meta)));
		IntStream.range(0, EnumMaterialType.values().length)
				.forEach(meta -> registerWithHandlers(
						"plateFutopia" + StringUtils.capitalize(EnumMaterialType.values()[meta].getName()),
						new ItemStack(FTItems.plates, 1, meta)));
	}

	private static void registerWithHandlers(String oreName, ItemStack stack) {
		OreDictionary.registerOre(oreName, stack);
		FMLInterModComms.sendMessage("ForgeMicroblock", "microMaterial", stack);
	}

}
