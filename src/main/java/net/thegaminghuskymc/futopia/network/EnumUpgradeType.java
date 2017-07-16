package net.thegaminghuskymc.futopia.network;

import net.minecraft.util.IStringSerializable;

public enum EnumUpgradeType implements IStringSerializable {

	BASIC(0, "basic"), 
	CAPACITY(1, "capacity"), 
	POWER(2, "power"), 
	SPEED(3, "speed"), 
	BASE(4, "base"), 
	CREATIVE(5, "creative");

	public static final EnumUpgradeType[] VALUES = new EnumUpgradeType[] { BASIC, CAPACITY, POWER, SPEED, BASE,
			CREATIVE };

	private static final EnumUpgradeType[] METADATA_LOOKUP = new EnumUpgradeType[values().length];

	public int ID;
	public String name;

	EnumUpgradeType(int ID, String name) {
		this.ID = ID;
		this.name = name;
	}

	public int getMeta() {
		return this.ID;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public static String[] toStringArray() {
		String[] array = new String[VALUES.length];

		for (int i = 0; i < array.length; i++) {
			array[i] = VALUES[i].name;
		}

		return array;
	}

}
