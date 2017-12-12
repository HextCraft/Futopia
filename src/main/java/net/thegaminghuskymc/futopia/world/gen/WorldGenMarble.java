package net.thegaminghuskymc.futopia.world.gen;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.*;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class WorldGenMarble extends WorldGenMinable {

    LinkedList marbleVein = new LinkedList();
    HashSet    veinsList  = new HashSet();
    IBlockState block;
    int   numberOfBlocks;

    public WorldGenMarble(IBlockState block, int num) {

        super(block, num);
        this.numberOfBlocks = num;
    }

    private void addBlock(int x, int y, int z, int num) {

        List marbleCandidate = Arrays.asList(x, y, z);
        if (this.veinsList.contains(marbleCandidate)) return;
        this.marbleVein.addLast(Arrays.asList(x, y, z, num));
        this.veinsList.add(marbleCandidate);
    }

    private void searchBlock(World world, int x, int y, int z, int num) {

        if (world.isAirBlock(new BlockPos(x - 1, y, z)) || world.isAirBlock(new BlockPos(x + 1, y, z)) || world.isAirBlock(new BlockPos(x, y - 1, z)) || world.isAirBlock(new BlockPos(x, y + 1, z))
                || world.isAirBlock(new BlockPos(x, y, z - 1)) || world.isAirBlock(new BlockPos(x, y, z + 1))) {
            num = 6;
        }
        addBlock(x - 1, y, z, num);
        addBlock(x + 1, y, z, num);
        addBlock(x, y - 1, z, num);
        addBlock(x, y + 1, z, num);
        addBlock(x, y, z - 1, num);
        addBlock(x, y, z + 1, num);
    }

    @Override
    public boolean generate(World world, Random rand, BlockPos position) {

        if (!world.isValid(position)) {
            return false;
        }

        int i = position.getY();
        while (world.getBlockState(position) != Blocks.STONE) {
            if (i > 96) return false; // Don't generate marble over y96
            i++;
            addBlock(position.getX(), i, position.getZ(), 6);
        }
        while ((this.marbleVein.size() > 0) && (this.numberOfBlocks > 0)) {
            List blocksToGenerate = (List) this.marbleVein.removeFirst();
            Integer[] blockToSet = (Integer[]) blocksToGenerate.toArray();
            if (world.getBlockState(position) == Blocks.STONE) {
                world.setBlockState(position, this.block);
                if (blockToSet[3] > 0) {
                    searchBlock(world, blockToSet[0], blockToSet[1], blockToSet[2], blockToSet[3] - 1);
                }
                this.numberOfBlocks -= 1;
            }
        }
        return true;
    }
}
