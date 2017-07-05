package net.thegaminghuskymc.futopia.blocks.conduits;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockItemConduit extends BlockConduitBase {
	
    public BlockItemConduit() {
        super("item");
    }

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return null;
	}

}
