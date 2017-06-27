package net.thegaminghuskymc.futopia.network;

import net.minecraft.util.IStringSerializable;

public enum ClearGlassType implements IStringSerializable {

    NORMAL("normal", 0, new float[]{0.427F, 0.471F, 0.604F}),
    BLACK("black", 1, new float[]{0.427F, 0.471F, 0.604F}),
    BLUE("blue", 2, new float[]{0.427F, 0.471F, 0.604F}),
    BROWN("brown", 3, new float[]{0.427F, 0.471F, 0.604F}),
    CYAN("cyan", 4, new float[]{0.427F, 0.471F, 0.604F}),
    GRAY("gray", 5, new float[]{0.427F, 0.471F, 0.604F}),
    GREEN("green", 6, new float[]{0.427F, 0.471F, 0.604F}),
    LIGHT_BLUE("light_blue", 7, new float[]{0.427F, 0.471F, 0.604F}),
    LIME("lime", 8, new float[]{0.427F, 0.471F, 0.604F}),
    MAGENTA("magenta", 9, new float[]{0.427F, 0.471F, 0.604F}),
    ORANGE("orange", 10, new float[]{0.427F, 0.471F, 0.604F}),
    PINK("pink", 11, new float[]{0.427F, 0.471F, 0.604F}),
    PURPLE("purple", 12, new float[]{0.427F, 0.471F, 0.604F}),
    RED("red", 13, new float[]{0.427F, 0.471F, 0.604F}),
    SILVER("silver", 14, new float[]{0.427F, 0.471F, 0.604F}),
    YELLOW("yellow", 15, new float[]{0.427F, 0.471F, 0.604F});

    public static final ClearGlassType[] METADATA_LOOKUP = new ClearGlassType[values().length];

    static {
        for (ClearGlassType type : values()) {
            METADATA_LOOKUP[type.getMetadata()] = type;
        }
    }

    public final int metadata;
    public final String name;
    public final int light;
    public final float[] beaconMult;

    ClearGlassType(String name, int metadata, int light, float[] beaconMult) {
        this.metadata = metadata;
        this.name = name;
        this.light = light;
        this.beaconMult = beaconMult;
    }

    ClearGlassType(String name, int metadata, float[] beaconMult) {

        this(name, metadata, 0, beaconMult);
    }

    public static String[] toStringArray() {
        String[] names = new String[values().length];

        for (int i = 0; i < values().length; i++) {
            names[i] = values()[i].getName();
        }

        return names;
    }

    public static ClearGlassType byMetadata(int metadata) {

        if (metadata < 0 || metadata >= METADATA_LOOKUP.length) {
            metadata = 0;
        }
        return METADATA_LOOKUP[metadata];
    }

    public int getID() {
        return this.metadata;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public int getLight() {

        return this.light;
    }

    public int getMetadata() {
        return this.metadata;
    }

}
