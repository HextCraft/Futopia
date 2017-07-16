package net.thegaminghuskymc.futopia.blocks.conduits;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockFluidConduit extends BlockConduitBase {

	public BlockFluidConduit() {
		super("fluid");
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return null;
	}

}
