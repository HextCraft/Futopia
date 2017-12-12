package net.thegaminghuskymc.futopia.world.gen;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockBasalt;
import net.thegaminghuskymc.futopia.init.FTBlocksAlt;
import net.thegaminghuskymc.futopia.init.FTItemsAlt;
import net.thegaminghuskymc.futopia.init.OtherBlocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorldGenVolcano {

    private static final int MAX_VOLCANO_RADIUS = 200;
    private static final Block ALTAR_BLOCKS = FTBlocksAlt.storages;

    public void generate(World world, Random rand, int middleX, int volcanoHeight, int middleZ) {
        List<Pos>[] distMap = calculateDistMap();
        boolean first = true;
        int centreWorldHeight = world.getHeight(middleX, middleZ);
        for (int dist = 0; dist < distMap.length; dist++) {
            List<Pos> distList = distMap[dist];
            boolean isFinished = true;
            for (Pos p : distList) {
                int worldHeight = world.getHeight(p.x + middleX, p.z + middleZ) - 1;
                int posHeight = first ? volcanoHeight : getNewVolcanoHeight(worldHeight, rand, dist);
                if (posHeight >= 0 && (posHeight > worldHeight || canReplace(world, new BlockPos(p.x + middleX, posHeight, p.z + middleZ)))) {
                    if (!first) {
                        for (int i = posHeight; i > 0 && (i > worldHeight || canReplace(world, new BlockPos(p.x + middleX, i, p.z + middleZ))); i--) {
                            world.setBlockState(new BlockPos(p.x + middleX, i, p.z + middleZ), OtherBlocks.basalt.getDefaultState());
                        }
                        for (int i = posHeight + 1; i < volcanoHeight; i++) {
                            if (canReplace(world, new BlockPos(p.x + middleX, i, p.z + middleZ))
                                    && world.getBlockState(new BlockPos(p.x + middleX, i, p.z + middleZ)).getMaterial() != Material.WATER)
                                world.setBlockState(new BlockPos(p.x + middleX, i, p.z + middleZ), Blocks.AIR.getDefaultState());
                        }
                    }
                    isFinished = false;
                }
                first = false;
            }
            if (isFinished)
                break;
        }
        generateLavaColumn(world, new BlockPos(middleX, volcanoHeight, middleZ), rand);
        generateLootChamber(world, middleX, rand.nextInt(volcanoHeight - 20 - centreWorldHeight) + centreWorldHeight, middleZ, rand);
    }

    private boolean canReplace(World world, BlockPos pos) {

        if (world.isAirBlock(pos))
            return true;
        IBlockState block = world.getBlockState(pos);
        Material material = block.getMaterial();
        return material == Material.WOOD || material == Material.CACTUS || material == Material.LEAVES || material == Material.PLANTS
                || material == Material.VINE || block == Blocks.WATER || block == Blocks.FLOWING_WATER;
    }

    private void generateLavaColumn(World world, BlockPos pos, Random rand) {

         world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()), Blocks.LAVA.getDefaultState());
        if (rand.nextDouble() < 0.5D) {
            world.setBlockState(pos, OtherBlocks.basalt.getDefaultState().withProperty(BlockBasalt.VARIANT, BlockBasalt.Type.CRACKED_LAVA));
        } else {
            world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), Blocks.LAVA.getDefaultState());
            world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()), Blocks.LAVA.getDefaultState());// This block set, which does update neighbors, will make the lava above update.
        }
        for (int y = pos.getY() - 1; y >= 10; y--) {
            if (world.getBlockState(new BlockPos(pos.getX(), y, pos.getZ())) != Blocks.BEDROCK) {
                world.setBlockState(new BlockPos(pos.getX() + 1, y, pos.getZ()), OtherBlocks.basalt.getDefaultState().withProperty(BlockBasalt.VARIANT, BlockBasalt.Type.RAW));
                world.setBlockState(new BlockPos(pos.getX() - 1, y, pos.getZ()), OtherBlocks.basalt.getDefaultState().withProperty(BlockBasalt.VARIANT, BlockBasalt.Type.RAW));
                world.setBlockState(new BlockPos(pos.getX(), y, pos.getZ() + 1), OtherBlocks.basalt.getDefaultState().withProperty(BlockBasalt.VARIANT, BlockBasalt.Type.RAW));
                world.setBlockState(new BlockPos(pos.getX(), y, pos.getZ() - 1), OtherBlocks.basalt.getDefaultState().withProperty(BlockBasalt.VARIANT, BlockBasalt.Type.RAW));
                world.setBlockState(new BlockPos(pos.getX(), y, pos.getZ()), Blocks.LAVA.getDefaultState());
            }
        }
    }

    /**
     * Saves an array of relative Positions with distance to origin. The index is the distance, the element the positions with that distance to the
     * origin.
     */
    @SuppressWarnings("unchecked")
    private List<Pos>[] calculateDistMap() {

        List<Pos>[] distMap = new List[MAX_VOLCANO_RADIUS];
        for (int x = -MAX_VOLCANO_RADIUS; x <= MAX_VOLCANO_RADIUS; x++) {
            for (int z = -MAX_VOLCANO_RADIUS; z <= MAX_VOLCANO_RADIUS; z++) {
                int dist = (int) Math.sqrt(x * x + z * z);
                if (dist < MAX_VOLCANO_RADIUS) {
                    List<Pos> distList = distMap[dist];
                    if (distList == null) {
                        distList = new ArrayList<Pos>();
                        distMap[dist] = distList;
                    }
                    distList.add(new Pos(x, z));
                }
            }
        }
        return distMap;
    }

    private int getNewVolcanoHeight(int worldHeight, Random rand, int distFromCenter) {

        int neighborCount = 0;
        int totalHeight = 0;
        if (neighborCount != 0) {
            double avgHeight = (double) totalHeight / neighborCount;
            if ((int) avgHeight < worldHeight + 2 && rand.nextInt(5) != 0)
                return (int) avgHeight - 2;
            int blocksDown;
            if (distFromCenter < 2) {
                blocksDown = 0;
            } else if (distFromCenter == 2) {
                blocksDown = rand.nextInt(2);
            } else {
                blocksDown = (int) (Math.pow(avgHeight - worldHeight + 1, 1.2) * 0.005D + (rand.nextDouble() - 0.5) * 3 + 0.4D);
            }
            if (blocksDown < 0)
                blocksDown = 0;
            int newHeight = (int) avgHeight - blocksDown;
            return newHeight;
        } else {
            return -1;
        }
    }

    private void generateLootChamber(World world, int middleX, int startY, int middleZ, Random rand) {
        int roomSize = 9;
        int roomHeight = 5;
        int startX = middleX - roomSize / 2;
        int startZ = middleZ - roomSize / 2;

        for (int x = startX; x < startX + roomSize; x++) {
            for (int y = startY; y < startY + roomHeight; y++) {
                for (int z = startZ; z < startZ + roomSize; z++) {
                    int xOffset = Math.abs(x - middleX);
                    int zOffset = Math.abs(z - middleZ);
                    if (xOffset != 0 || zOffset != 0) {
                        boolean spawnGlass = xOffset <= 1 && zOffset <= 1;
                        world.setBlockState(new BlockPos(x, y, z), spawnGlass ? OtherBlocks.limestone.getDefaultState() : Blocks.AIR.getDefaultState());
                    }
                }
            }
        }

        for (EnumFacing d : EnumFacing.VALUES) {
            if (d != EnumFacing.UP && d != EnumFacing.DOWN) {
                if (rand.nextInt(2) == 0) {
                    generateAltar(world, new BlockPos(middleX + d.getFrontOffsetX() * roomSize / 2, startY - 1, middleZ + d.getFrontOffsetZ() * roomSize / 2), rand, d);
                }
            }
        }
    }

    private void generateAltar(World world, BlockPos pos, Random rand, EnumFacing dir) {
        generateLootChest(world, new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), rand, dir);
        EnumFacing opDir = dir.getOpposite();
        Block altarBlock = ALTAR_BLOCKS;
        setAltarBlockAndPossiblyTrap(world, new BlockPos(pos.getX(), pos.getY(), pos.getZ()), rand, altarBlock);
        setAltarBlockAndPossiblyTrap(world, new BlockPos(pos.getX() + opDir.getFrontOffsetX(), pos.getY(), pos.getZ() + opDir.getFrontOffsetZ()), rand, altarBlock);
        EnumFacing sideDir = dir.getOpposite();
        setAltarBlockAndPossiblyTrap(world, new BlockPos(pos.getX() + sideDir.getFrontOffsetX(), pos.getY(), pos.getZ() + sideDir.getFrontOffsetZ()), rand, altarBlock);
        setAltarBlockAndPossiblyTrap(world, new BlockPos(pos.getX() + sideDir.getFrontOffsetX() + opDir.getFrontOffsetX(), pos.getY(), pos.getZ() + sideDir.getFrontOffsetZ() + opDir.getFrontOffsetZ()), rand,
                altarBlock);
        sideDir = sideDir.getOpposite();
        setAltarBlockAndPossiblyTrap(world, new BlockPos(pos.getX() + sideDir.getFrontOffsetX(), pos.getY(), pos.getZ() + sideDir.getFrontOffsetX()), rand, altarBlock);
        setAltarBlockAndPossiblyTrap(world, new BlockPos(pos.getX() + sideDir.getFrontOffsetX() + opDir.getFrontOffsetX(), pos.getY(), pos.getZ() + sideDir.getFrontOffsetZ() + opDir.getFrontOffsetZ()), rand,
                altarBlock);

    }

    private void setAltarBlockAndPossiblyTrap(World world, BlockPos pos, Random rand, Block altarBlock) {
        world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()), altarBlock.getDefaultState());
        if (rand.nextInt(6) == 0) {
            world.setBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()), Blocks.TNT.getDefaultState());
            world.setBlockState(new BlockPos(pos.getX(), pos.getY() - 2, pos.getZ()), Blocks.REDSTONE_BLOCK.getDefaultState());
        }
    }

    private void generateLootChest(World world, BlockPos pos, Random rand, EnumFacing dir) {
        world.setBlockState(pos, Blocks.CHEST.getDefaultState());
        if (rand.nextInt(5) == 0) {
            ((TileEntityChest) world.getTileEntity(pos)).setInventorySlotContents(13,
                    new ItemStack(FTItemsAlt.ingots, 5 + rand.nextInt(10)));
        }
    }

    private static class Pos {

        public final int x, z;

        public Pos(int x, int z) {

            this.x = x;
            this.z = z;
        }

        @Override
        public boolean equals(Object object) {
            if (object instanceof Pos) {
                Pos pos = (Pos) object;
                return pos.x == x && pos.z == z;
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return (x << 13) + z;
        }
    }
}
