package net.thegaminghuskymc.futopia.blocks.machine;

import net.thegaminghuskymc.futopia.blocks.BlockMachineBase;
import net.thegaminghuskymc.futopia.tiles.TileAlloyFurnace;
import net.thegaminghuskymc.futopia.utils.BlockNames;

public class BlockAlloyFurnace extends BlockMachineBase {

    public BlockAlloyFurnace() {
        super(BlockNames.ALLOYFURNACE_NAME, new TileAlloyFurnace());
    }

}