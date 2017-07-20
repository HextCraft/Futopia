package net.thegaminghuskymc.futopia.tiles;

public class TileMultiBlockController extends TileMultiBlock {

	@Override
	public boolean isMaster() {
		return true;
	}
	
	@Override
	public int getMasterX() {
		return this.pos.getX();
	}
	
	@Override
	public int getMasterY() {
		return this.pos.getY();
	}
	
	@Override
	public int getMasterZ() {
		return this.pos.getZ();
	}

}
