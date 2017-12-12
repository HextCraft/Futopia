package net.thegaminghuskymc.futopia.blocks.conduits;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPowerConduit extends BlockConduitBase {

	public BlockPowerConduit() {
		super(Material.ANVIL,"power_conduit");
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return null;
	}

}
