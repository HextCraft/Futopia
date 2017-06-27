package net.thegaminghuskymc.futopia.network;

import net.minecraft.util.IStringSerializable;

public enum EnumBasaltType implements IStringSerializable {

    NORMAL("normal", 0),
    COBBLE("cobble", 1),
    PAVER("paver", 2),
    BRICK("brick", 3),
    FANCY("fancy", 4),
    CRACKED_LAVA("cracked_lava", 5),
    BRICK_CRACKED("brick_cracked", 6),
    BRICK_SMALL("brick_small", 7),
    TILE("tile", 8);

    private String name;
    private int ID;

    EnumBasaltType(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    public static String[] toStringArray() {
        String[] names = new String[values().length];

        for (int i = 0; i < values().length; i++) {
            names[i] = values()[i].getName();
        }

        return names;
    }

    public int getID() {
        return this.ID;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
