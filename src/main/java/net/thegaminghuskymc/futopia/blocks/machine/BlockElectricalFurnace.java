package net.thegaminghuskymc.futopia.blocks.machine;

import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.tiles.TileElectricalFurnace;
import net.thegaminghuskymc.futopia.utils.BlockNames;

public class BlockElectricalFurnace extends BlockFurnaceBase {

	public BlockElectricalFurnace() {
		super(BlockNames.ELECTRICALFURNACE_NAME, FTCreativeTabs.machines, new TileElectricalFurnace());
	}

}