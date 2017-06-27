package cofh.lib.world.biome;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.LoaderState;

import java.util.HashMap;
import java.util.Set;

public class BiomeDictionaryArbiter {

	private static HashMap<Biome, Type[]> types = new HashMap<>();
	private static HashMap<Type, Biome[]> biomes = new HashMap<>();
	private static boolean loaded = Loader.instance().isInState(LoaderState.AVAILABLE);

	public static Set<Type> getTypesForBiome(Biome biome) {

		if (loaded) {
			
		}
		loaded = Loader.instance().isInState(LoaderState.AVAILABLE);
		return BiomeDictionary.getTypes(biome);
	}

	public static Set<Biome> getTypesForBiome(Type type) {

		if (loaded) {
			
		}
		loaded = Loader.instance().isInState(LoaderState.AVAILABLE);
		return BiomeDictionary.getBiomes(type);
	}

	private BiomeDictionaryArbiter() {

		throw new IllegalArgumentException();
	}
}
