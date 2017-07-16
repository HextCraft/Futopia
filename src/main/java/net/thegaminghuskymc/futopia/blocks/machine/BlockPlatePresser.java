package net.thegaminghuskymc.futopia.blocks.machine;

import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.tiles.TilePlatePresser;
import net.thegaminghuskymc.huskylib.blocks.BlockMachineBase;

/**
 * Created by TheGamingHuskyMC on 01.05.2017.
 */
public class BlockPlatePresser extends BlockMachineBase {

	public BlockPlatePresser() {
		super(Refs.MODID, "plate_presser", new TilePlatePresser(), FTCreativeTabs.machines);
	}

}
