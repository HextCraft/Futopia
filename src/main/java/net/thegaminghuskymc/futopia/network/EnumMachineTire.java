package net.thegaminghuskymc.futopia.network;

import net.minecraft.util.IStringSerializable;

public enum EnumMachineTire implements IStringSerializable {

	BASIC(0, "basic"), TIRE_1(1, "tire_1"), TIRE_2(2, "tire_2"), TIRE_3(3, "tire_3"), TIRE_4(4, "tire_4"), CREATIVE(5,
			"creative");

	public static final EnumMachineTire[] VALUES = new EnumMachineTire[] { BASIC, TIRE_1, TIRE_2, TIRE_3, TIRE_4,
			CREATIVE };

	private static final EnumMachineTire[] METADATA_LOOKUP = new EnumMachineTire[values().length];

	public int ID;
	public String name;

	EnumMachineTire(int ID, String name) {
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

	public static EnumMachineTire byMetadata(int metadata) {

		if (metadata < 0 || metadata >= METADATA_LOOKUP.length) {
			metadata = 0;
		}
		return METADATA_LOOKUP[metadata];
	}

	public static String[] toStringArray() {
		String[] array = new String[VALUES.length];

		for (int i = 0; i < array.length; i++) {
			array[i] = VALUES[i].name;
		}

		return array;
	}

}
