package net.thegaminghuskymc.futopia.utils;

import net.minecraft.client.resources.I18n;
import net.thegaminghuskymc.futopia.Refs;

public class Translations {

    public static final String CONTAINER_FABRICATOR = translate("container", "fabricator");
    public static final String TOOLTIP_PRESS = translate("tooltip", "press");
    public static final String TOOLTIP_INFO = translate("tooltip", "info");
    public static final String TOOLTIP_SHIFT = translate("tooltip", "shift");
    public static final String TOOLTIP_UPGRADE_TYPE = translate("tooltip", "upgrade_type");
    public static final String TOOLTIP_WITHER_PROOF = translate("tooltip", "wither_proof");

    private static String translate(String prefix, String key){
        return I18n.format(prefix + "." + Refs.MODID + "." + key + ".name");
    }

    @SuppressWarnings("unused")
	private static String translate(String prefix, String key, String suffix){
        return I18n.format(prefix + "." + Refs.MODID + "." + key + "." + suffix);
    }

}
