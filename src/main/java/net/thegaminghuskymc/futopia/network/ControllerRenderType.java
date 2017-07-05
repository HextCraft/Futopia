package net.thegaminghuskymc.futopia.network;

import net.minecraft.util.IStringSerializable;

public enum ControllerRenderType implements IStringSerializable {
	
	BLOCK, 
	COLUMN_X, 
	COLUMN_Y, 
	COLUMN_Z, 
	INSIDE_A, 
	INSIDE_B;

	@Override
	public String getName() {
		return this.name();
	}

}