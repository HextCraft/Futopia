package net.thegaminghuskymc.futopia.blocks.machine;

import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.tiles.TileAlloyFurnace;
import net.thegaminghuskymc.futopia.utils.BlockNames;

public class BlockAlloyFurnace extends BlockFurnaceBase {

    public BlockAlloyFurnace() {
        super(BlockNames.ALLOYFURNACE_NAME, FTCreativeTabs.machines, new TileAlloyFurnace());
    }

}