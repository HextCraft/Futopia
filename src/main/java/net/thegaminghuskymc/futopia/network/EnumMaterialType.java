package net.thegaminghuskymc.futopia.network;

import net.minecraft.util.IStringSerializable;

public enum EnumMaterialType implements IStringSerializable{

    RED("red", 0),
    BLUE("blue", 1),
    PURPLE("purple", 2),
    GREEN("green", 3),
    ZINC("zinc", 4),
    TUNGSTEN("tungsten", 5),
    BRASS("brass", 6),
    TESSELITE("tesselite", 7);

    public static final EnumMaterialType[] VALUES = new EnumMaterialType[]{
            RED,
            BLUE,
            PURPLE,
            GREEN,
            ZINC,
            TUNGSTEN,
            BRASS,
            TESSELITE
    };

    private int index;
    private String name;

    EnumMaterialType(String name, int index){
        this.index = index;
        this.name = name;
    }

    public int getMeta(){
        return this.index;
    }

    public String getName(){
        return this.name;
    }

    public static String[] toStringArray(){
        String[] array = new String[VALUES.length];

        for(int i = 0; i < array.length; i++){
            array[i] = VALUES[i].name;
        }

        return array;
    }
    
    public String test(){
		return toStringArray().toString();
    }

}
