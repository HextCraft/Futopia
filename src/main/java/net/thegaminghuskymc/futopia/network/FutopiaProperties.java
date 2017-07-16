package net.thegaminghuskymc.futopia.network;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.item.EnumDyeColor;

public class FutopiaProperties {

	public static final PropertyEnum<EnumMaterialType> MATERIALS = PropertyEnum.create("type", EnumMaterialType.class);
	public static final PropertyEnum<EnumDyeColor> MC_COLOUR = PropertyEnum.create("color", EnumDyeColor.class);

}
