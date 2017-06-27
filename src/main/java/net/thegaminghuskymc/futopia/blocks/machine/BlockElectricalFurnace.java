package net.thegaminghuskymc.futopia.blocks.machine;

import net.thegaminghuskymc.futopia.blocks.BlockMachineBase;
import net.thegaminghuskymc.futopia.tiles.TileElectricalFurnace;
import net.thegaminghuskymc.futopia.utils.BlockNames;

public class BlockElectricalFurnace extends BlockMachineBase{

    public BlockElectricalFurnace() {
        super(BlockNames.ELECTRICALFURNACE_NAME, new TileElectricalFurnace());
    }

}