package cofh.core.world.feature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.Logger;

import com.typesafe.config.Config;

import cofh.core.world.FeatureParser;
import cofh.lib.util.WeightedRandomBlock;
import cofh.lib.util.numbers.INumberProvider;
import cofh.lib.world.feature.FeatureBase;
import cofh.lib.world.feature.FeatureBase.GenRestriction;
import cofh.lib.world.feature.FeatureGenUnderfluid;
import gnu.trove.set.hash.TIntHashSet;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.DungeonHooks.DungeonMob;

public class UnderfluidParser extends UniformParser {

	private boolean isUnderwater;

	public UnderfluidParser(boolean water) {

		isUnderwater = water;
	}

	@Override
	protected List<WeightedRandomBlock> generateDefaultMaterial() {

		return Arrays.asList(new WeightedRandomBlock(Blocks.DIRT, -1), new WeightedRandomBlock(Blocks.GRASS, -1));
	}

	@Override
	protected FeatureBase getFeature(String featureName, Config genObject, WorldGenerator gen, INumberProvider numClusters, GenRestriction biomeRes, boolean retrogen, GenRestriction dimRes, Logger log) {

		boolean water = true;
		int[] fluidList = null;
		l:
		if (genObject.hasPath("fluid")) {
			ArrayList<DungeonMob> list = new ArrayList<>();
			if (!FeatureParser.parseWeightedStringList(genObject.root().get("fluid"), list)) {
				break l;
			}
			water = false;
			TIntHashSet ints = new TIntHashSet();
			for (DungeonMob str : list) {
				
			}
			fluidList = ints.toArray();
		}

		// TODO: WorldGeneratorAdv that allows access to its material list
		List<WeightedRandomBlock> matList = defaultMaterial;
		if (genObject.hasPath("material")) {
			matList = new ArrayList<>();
			if (!FeatureParser.parseResList(genObject.root().get("material"), matList, false)) {
				log.warn("Invalid material list! Using default list.");
				matList = defaultMaterial;
			}
		}
		if (water) {
			return new FeatureGenUnderfluid(featureName, gen, matList, numClusters, biomeRes, retrogen, dimRes);
		} else {
			return new FeatureGenUnderfluid(featureName, gen, matList, fluidList, numClusters, biomeRes, retrogen, dimRes);
		}
	}

	@Override
	protected String getDefaultGenerator() {

		return isUnderwater ? "plate" : super.getDefaultGenerator();
	}

}
