// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MathHelper.java

package net.thegaminghuskymc.futopia.utils;

import java.util.Random;

public final class MathHelper
{

    private MathHelper()
    {
    }

    public static double sin(double d)
    {
        return SIN_TABLE[(int)((float)d * 10430.38F) & 0xffff];
    }

    public static double cos(double d)
    {
        return SIN_TABLE[(int)((float)d * 10430.38F + 16384F) & 0xffff];
    }

    public static int clamp(int a, int min, int max)
    {
        return a >= min ? a <= max ? a : max : min;
    }

    public static float clamp(float a, float min, float max)
    {
        return a >= min ? a <= max ? a : max : min;
    }

    public static double clamp(double a, double min, double max)
    {
        return a >= min ? a <= max ? a : max : min;
    }

    public static float approachLinear(float a, float b, float max)
    {
        return a <= b ? b - a >= max ? a + max : b : a - b >= max ? a - max : b;
    }

    public static double approachLinear(double a, double b, double max)
    {
        return a <= b ? b - a >= max ? a + max : b : a - b >= max ? a - max : b;
    }

    public static float interpolate(float a, float b, float d)
    {
        return a + (b - a) * d;
    }

    public static double interpolate(double a, double b, double d)
    {
        return a + (b - a) * d;
    }

    public static double approachExp(double a, double b, double ratio)
    {
        return a + (b - a) * ratio;
    }

    public static double approachExp(double a, double b, double ratio, double cap)
    {
        double d = (b - a) * ratio;
        if(Math.abs(d) > cap)
            d = Math.signum(d) * cap;
        return a + d;
    }

    public static double retreatExp(double a, double b, double c, double ratio, 
            double kick)
    {
        double d = (Math.abs(c - a) + kick) * ratio;
        if(d > Math.abs(b - a))
            return b;
        else
            return a + Math.signum(b - a) * d;
    }

    public static double clip(double value, double min, double max)
    {
        if(value > max)
            value = max;
        else
        if(value < min)
            value = min;
        return value;
    }

    public static boolean between(double a, double x, double b)
    {
        return a <= x && x <= b;
    }

    public static int approachExpI(int a, int b, double ratio)
    {
        int r = (int)Math.round(approachExp(a, b, ratio));
        return r != a ? r : b;
    }

    public static int retreatExpI(int a, int b, int c, double ratio, int kick)
    {
        int r = (int)Math.round(retreatExp(a, b, c, ratio, kick));
        return r != a ? r : b;
    }

    public static int round(double d)
    {
        return (int)(d + 0.5D);
    }

    public static int ceil(double d)
    {
        return (int)(d + 0.99990000000000001D);
    }

    public static int floor(double d)
    {
        int i = (int)d;
        return d >= (double)i ? i : i - 1;
    }

    public static float minF(float a, float b)
    {
        return a >= b ? b : a;
    }

    public static float minF(int a, float b)
    {
        return (float)a >= b ? b : a;
    }

    public static float minF(float a, int b)
    {
        return a >= (float)b ? b : a;
    }

    public static float maxF(float a, float b)
    {
        return a <= b ? b : a;
    }

    public static float maxF(int a, float b)
    {
        return (float)a <= b ? b : a;
    }

    public static float maxF(float a, int b)
    {
        return a <= (float)b ? b : a;
    }

    public static double maxAbs(double a, double b)
    {
        if(a < 0.0D)
            a = -a;
        if(b < 0.0D)
            b = -b;
        return a <= b ? b : a;
    }

    public static int setBit(int mask, int bit, boolean value)
    {
        mask |= (value ? 1 : 0) << bit;
        return mask;
    }

    public static boolean isBitSet(int mask, int bit)
    {
        return (mask & 1 << bit) != 0;
    }

    public static final Random RANDOM = new Random();
    public static final double PHI = 1.618034D;
    public static final double SIN_TABLE[];

    static 
    {
        SIN_TABLE = new double[0x10000];
        for(int i = 0; i < 0x10000; i++)
            SIN_TABLE[i] = Math.sin(((double)i / 65536D) * 2D * 3.1415926535897931D);

        SIN_TABLE[0] = 0.0D;
        SIN_TABLE[16384] = 1.0D;
        SIN_TABLE[32768] = 0.0D;
        SIN_TABLE[49152] = -1D;
    }
}
