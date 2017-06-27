// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ColorHelper.java

package net.thegaminghuskymc.futopia.utils;


public final class ColorHelper
{

    private ColorHelper()
    {
    }

    public static int getDyeColor(int color)
    {
        return color >= 0 && color <= 15 ? DYE_COLORS[color] : 0xffffff;
    }

    public static final int DYE_BLACK = 0x191919;
    public static final int DYE_RED = 0xcc4c4c;
    public static final int DYE_GREEN = 0x667f33;
    public static final int DYE_BROWN = 0x7f664c;
    public static final int DYE_BLUE = 0x3366cc;
    public static final int DYE_PURPLE = 0xb266e5;
    public static final int DYE_CYAN = 0x4c99b2;
    public static final int DYE_LIGHT_GRAY = 0x999999;
    public static final int DYE_GRAY = 0x4c4c4c;
    public static final int DYE_PINK = 0xf2b2cc;
    public static final int DYE_LIME = 0x7fcc19;
    public static final int DYE_YELLOW = 0xe5e533;
    public static final int DYE_LIGHT_BLUE = 0x99b2f2;
    public static final int DYE_MAGENTA = 0xe57fd8;
    public static final int DYE_ORANGE = 0xf2b233;
    public static final int DYE_WHITE = 0xffffff;
    public static final int DYE_COLORS[] = {
        0x191919, 0xcc4c4c, 0x667f33, 0x7f664c, 0x3366cc, 0xb266e5, 0x4c99b2, 0x999999, 0x4c4c4c, 0xf2b2cc, 
        0x7fcc19, 0xe5e533, 0x99b2f2, 0xe57fd8, 0xf2b233, 0xffffff
    };
    public static final String WOOL_COLOR_CONFIG[] = {
        "White", "Orange", "Magenta", "LightBlue", "Yellow", "Lime", "Pink", "Gray", "LightGray", "Cyan", 
        "Purple", "Blue", "Brown", "Green", "Red", "Black"
    };

}
