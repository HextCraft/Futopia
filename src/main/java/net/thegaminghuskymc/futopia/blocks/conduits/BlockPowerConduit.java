package net.thegaminghuskymc.futopia.blocks.conduits;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPowerConduit extends BlockConduitBase {

	public BlockPowerConduit() {
		super("power");
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return null;
	}

}
