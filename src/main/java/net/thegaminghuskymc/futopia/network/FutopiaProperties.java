package net.thegaminghuskymc.futopia.network;

import net.minecraft.block.properties.PropertyEnum;

public class FutopiaProperties {

    public static final PropertyEnum<EnumMaterialType> MATERIALS = PropertyEnum.create("type", EnumMaterialType.class);
    public static final PropertyEnum<EnumMarbleType> MARBLE_TYPE = PropertyEnum.create("type", EnumMarbleType.class);
    public static final PropertyEnum<EnumBasaltType> BASALT_TYPE = PropertyEnum.create("type", EnumBasaltType.class);
    public static final PropertyEnum<EnumLimestoneType> LIMESTONE_TYPE = PropertyEnum.create("type", EnumLimestoneType.class);
    public static final PropertyEnum<EnumMeteorType> METEOR_TYPE = PropertyEnum.create("type", EnumMeteorType.class);
    public static final PropertyEnum<EnumConcreteType> CONCRETE = PropertyEnum.create("type", EnumConcreteType.class);

}
