package net.thegaminghuskymc.futopia.network;

import net.minecraft.util.IStringSerializable;

public enum EnumPlacingType implements IStringSerializable{
	
	BLOCK(0, "block"),
	NORTH(1, "north"),
	SOUTH(2, "south"),
	EAST(3, "east"),
	WEST(4, "west"),
	UP(5, "up"),
	DOWN(6, "down");
	
	private int ID;
	private String name;
	
	private EnumPlacingType(int ID, String name) {
		this.ID = ID;
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}
	
	public int getID() {
		return this.ID;
	}

}
