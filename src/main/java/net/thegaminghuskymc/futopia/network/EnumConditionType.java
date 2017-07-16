package net.thegaminghuskymc.futopia.network;

import net.minecraft.util.IStringSerializable;

public enum EnumConditionType implements IStringSerializable {

	ONLINE(0, "online"), OFFLINE(1, "offline"), CONFLICTED(2, "conflicted");

	private int ID;
	private String name;

	private EnumConditionType(int ID, String name) {
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
