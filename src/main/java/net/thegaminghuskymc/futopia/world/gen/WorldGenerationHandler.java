package net.thegaminghuskymc.futopia.world.gen;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGenerationHandler implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

        if (random.nextDouble() < 0.7D) {
            int x = chunkX * 16 + random.nextInt(16);
            int z = chunkZ * 16 + random.nextInt(16);//20
            int y = world.getHeight(x, z) + 30 + random.nextInt(40);

            if (world.getBlockState(new BlockPos(x, 10, z)) == Blocks.LAVA && world.getHeight(x, z) <= 90) {
                FMLLog.getLogger().info("Generating volcanos....");
                new WorldGenVolcano().generate(world, random, x, y, z);
                FMLLog.getLogger().info("Done generating volcanos");
            }
        }
    }

}
