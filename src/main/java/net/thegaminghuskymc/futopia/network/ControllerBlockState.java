package net.thegaminghuskymc.futopia.network;

import net.minecraft.util.IStringSerializable;

public enum ControllerBlockState implements IStringSerializable {

	OFFLINE, ONLINE, CONFLICTED;

	@Override
	public String getName() {
		return this.name();
	}

}