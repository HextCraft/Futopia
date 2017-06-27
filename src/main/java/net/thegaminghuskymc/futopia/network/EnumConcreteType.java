package net.thegaminghuskymc.futopia.network;

import net.minecraft.util.IStringSerializable;

public enum EnumConcreteType implements IStringSerializable {

    NORMAL(0, "normal"),
    ARRANGED_BRICK(1, "arranged_brick"),
    BRICK(2, "brick"),
    BRICK_DARK(3, "brick_dark"),
    FANCY_BRICK(4, "fancy_brick"),
    OLD_SQUARES(5, "old_squares"),
    ROCKS(6, "rocks"),
    SMALL_BRICKS(7, "small_bricks");

    private String name;
    private int ID;

    EnumConcreteType(int ID, String name) {
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
