package net.thegaminghuskymc.futopia.blocks.conduits;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockFluidConduit extends BlockConduitBase {

	public BlockFluidConduit() {
		super(Material.ANVIL,"fluid_conduit");
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return null;
	}

}
