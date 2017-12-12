package net.thegaminghuskymc.futopia.blocks.conduits;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockItemConduit extends BlockConduitBase {

	public BlockItemConduit() {
		super(Material.ANVIL,"item_conduit");
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return null;
	}

}
