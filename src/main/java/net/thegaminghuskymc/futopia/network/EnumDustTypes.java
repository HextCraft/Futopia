package net.thegaminghuskymc.futopia.network;

import net.minecraft.util.IStringSerializable;

public enum EnumDustTypes implements IStringSerializable{
	
	ALMANDINE("almandine", 0),
	ALUMINUM("aluminum", 1),
	ANDRADITE("andradite", 2),
	ASHES("ashes", 3),
	BASALT("basalt", 4),
	BAUXITE("bauxite", 5),
	BRASS("brass", 6),
	BRONZE("bronze", 7),
	CALCITE("calcite", 8),
	CHARCOAL("charcoal", 9),
	CHROME("chrome", 10),
	CINNABAR("cinnabar", 11),
	CLAY("clay", 12),
	COAL("coal", 13),
	COPPER("copper", 14),
	DARK_ASHES("dark_ashes", 15),
	DIAMOND("diamond", 16),
	ELECTRUM("electrum", 17),
	EMERALD("emerald", 18),
	ENDER_EYE("ender_eye", 19),
	ENDER_PEARL("ender_pearl", 20),
	ENDSTONE("endstone", 21),
	FLINT("flint", 22),
	GALENA("galena", 23),
	GOLD("gold", 24),
	GROSSULAR("grossular", 25),
	INVAR("invar", 26),
	IRON("iron", 27),
	LAZURITE("lazurite", 28),
	LEAD("lead", 29),
	MAGNESIUM("magnesium", 30),
	MANGANESE("manganese", 31),
	MARBLE("marble", 32),
	NETHERRACK("netherrack", 33),
	NICKEL("nickel", 34),
	OBSIDIAN("obsidian", 35),
	PERIDOT("peridot", 36),
	PHOSPHOROUS("phosphorous", 37),
	PLATINUM("platinum", 38),
	PYRITE("pyrite", 39),
	PYROPE("pyrope", 40),
	RED_GARNET("red_garnet", 41),
	RUBY("ruby", 42),
	SALTPETER("saltpeter", 43),
	SAPPHITE("sapphire", 44),
	SAW_DUST("saw_dust", 45),
	SILVER("silver", 46),
	SODALITE("sodalite", 47),
	SPESSARTINE("spessartine", 48),
	SPHALERITE("sphalerite", 49),
	STEEL("steel", 50),
	SULFUR("sulfur", 51),
	TIN("tin", 52),
	TITANIUM("titanium", 53),
	TUNGSTEN("tungsten", 54),
	UVAROVITE("uvarovite", 55),
	YELLOW_GARNET("yellow_garnet", 56),
	ZINC("zinc", 57),
	ANDESITE("andesite", 58),
	DIORITE("diorite", 59),
	GRANITE("granite", 60);

	private String name;
    private int ID;

    EnumDustTypes(String name, int ID) {
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
