package net.thegaminghuskymc.futopia.world.gen;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.init.FTBlocks;
import net.thegaminghuskymc.futopia.init.OtherBlocks;

public class OreGen implements IWorldGenerator {
	
	//World Generators
	private WorldGenerator ores;
	private WorldGenerator marble;
	private WorldGenerator basalt;
	private WorldGenerator limestone;
	private WorldGenerator meteor;
	
	public OreGen() {
		ores = new WorldGenMinable(FTBlocks.ores.getDefaultState(), 18);
		marble = new WorldGenMinable(OtherBlocks.marble.getStateFromMeta(0), 18);
		basalt = new WorldGenMinable(OtherBlocks.basalt.getStateFromMeta(0), 18);
		limestone = new WorldGenMinable(OtherBlocks.limestone.getStateFromMeta(0), 18);
		meteor = new WorldGenMinable(OtherBlocks.meteor.getStateFromMeta(0), 18);
	}
	
	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

		int heightDiff = maxHeight - minHeight + 1;
		for (int i = 0; i < chancesToSpawn; i ++) {
			int x = chunk_X * 16 + rand.nextInt(16);
		        int y = minHeight + rand.nextInt(heightDiff);
		        int z = chunk_Z * 16 + rand.nextInt(16);
		        generator.generate(world, rand, new BlockPos(x, y, z));
		        Futopia.LOGGER.finer("Generating" + generator.toString());
		}
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,IChunkProvider chunkProvider) {
		switch(world.provider.getDimension()) {
		case 1: //OverWorld
			this.runGenerator(ores, world, random, chunkX, chunkZ, 1, 0, 128);
			this.runGenerator(marble, world, random, chunkX, chunkZ, 1, 0, 128);
			this.runGenerator(basalt, world, random, chunkX, chunkZ, 1, 0, 128);
			this.runGenerator(meteor, world, random, chunkX, chunkZ, 1, 0, 128);
			this.runGenerator(limestone, world, random, chunkX, chunkZ, 1, 0, 128);
		}
	}

}
