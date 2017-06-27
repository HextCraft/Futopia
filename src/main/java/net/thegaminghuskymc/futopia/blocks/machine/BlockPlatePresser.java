package net.thegaminghuskymc.futopia.blocks.machine;

import net.thegaminghuskymc.futopia.blocks.BlockMachineBase;
import net.thegaminghuskymc.futopia.tiles.TilePlatePresser;

/**
 * Created by TheGamingHuskyMC on 01.05.2017.
 */
public class BlockPlatePresser extends BlockMachineBase {

    public BlockPlatePresser() {
        super("plate_presser", new TilePlatePresser());
    }
    
}
