package net.thegaminghuskymc.huskylib.utils.color;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.huskylib.utils.math.MathHelper;

public abstract class Color {

    /*public static IConfigType<Color> configRGB = new IConfigType<Color>() {
        @Override
        public String configValue(Color entry) {
            String s = Long.toString(((long) entry.rgb()) << 32 >>> 32, 16);
            while (s.length() < 6) {
                s = "0" + s;
            }
            return "0x" + s.toUpperCase();
        }

        private final Pattern patternRGB = Pattern.compile("(\\d+),(\\d+),(\\d+)");

        @Override
        public Color valueOf(String text) throws Exception {
            Matcher matcherRGB = patternRGB.matcher(text.replaceAll("\\s", ""));
            if (matcherRGB.matches()) {
                return new ColorRGBA(Integer.parseInt(matcherRGB.group(1)), Integer.parseInt(matcherRGB.group(2)), Integer.parseInt(matcherRGB.group(3)), 0xFF);
            }

            int hex = (int) Long.parseLong(text.replace("0x", ""), 16);
            return new ColorRGBA(hex << 8 | 0xFF);
        }
    };*/

    public byte r;
    public byte g;
    public byte b;
    public byte a;

    public Color(int r, int g, int b, int a) {
        this.r = (byte) r;
        this.g = (byte) g;
        this.b = (byte) b;
        this.a = (byte) a;
    }

    public Color(Color Color) {
        r = Color.r;
        g = Color.g;
        b = Color.b;
        a = Color.a;
    }

    @SideOnly (Side.CLIENT)
    public void glColor() {
        GlStateManager.color((r & 0xFF) / 255F, (g & 0xFF) / 255F, (b & 0xFF) / 255F, (a & 0xFF) / 255F);
    }

    @SideOnly (Side.CLIENT)
    public void glColor(int a) {
        GlStateManager.color((r & 0xFF) / 255F, (g & 0xFF) / 255F, (b & 0xFF) / 255F, a / 255F);
    }

    public abstract int pack();

    public abstract float[] packArray();

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[0x" + Integer.toHexString(pack()).toUpperCase() + "]";
    }

    public Color add(Color Color2) {
        a += Color2.a;
        r += Color2.r;
        g += Color2.g;
        b += Color2.b;
        return this;
    }

    public Color sub(Color Color2) {
        int ia = (a & 0xFF) - (Color2.a & 0xFF);
        int ir = (r & 0xFF) - (Color2.r & 0xFF);
        int ig = (g & 0xFF) - (Color2.g & 0xFF);
        int ib = (b & 0xFF) - (Color2.b & 0xFF);
        a = (byte) (ia < 0 ? 0 : ia);
        r = (byte) (ir < 0 ? 0 : ir);
        g = (byte) (ig < 0 ? 0 : ig);
        b = (byte) (ib < 0 ? 0 : ib);
        return this;
    }

    public Color invert() {
        a = (byte) (0xFF - (a & 0xFF));
        r = (byte) (0xFF - (r & 0xFF));
        g = (byte) (0xFF - (g & 0xFF));
        b = (byte) (0xFF - (b & 0xFF));
        return this;
    }

    public Color multiply(Color Color2) {
        a = (byte) ((a & 0xFF) * ((Color2.a & 0xFF) / 255D));
        r = (byte) ((r & 0xFF) * ((Color2.r & 0xFF) / 255D));
        g = (byte) ((g & 0xFF) * ((Color2.g & 0xFF) / 255D));
        b = (byte) ((b & 0xFF) * ((Color2.b & 0xFF) / 255D));
        return this;
    }

    public Color scale(double d) {
        a = (byte) ((a & 0xFF) * d);
        r = (byte) ((r & 0xFF) * d);
        g = (byte) ((g & 0xFF) * d);
        b = (byte) ((b & 0xFF) * d);
        return this;
    }

    public Color interpolate(Color Color2, double d) {
        return this.add(Color2.copy().sub(this).scale(d));
    }

    public Color multiplyC(double d) {
        r = (byte) MathHelper.clip((r & 0xFF) * d, 0, 255);
        g = (byte) MathHelper.clip((g & 0xFF) * d, 0, 255);
        b = (byte) MathHelper.clip((b & 0xFF) * d, 0, 255);

        return this;
    }

    public abstract Color copy();

    public int rgb() {
        return (r & 0xFF) << 16 | (g & 0xFF) << 8 | (b & 0xFF);
    }

    public int argb() {
        return (a & 0xFF) << 24 | (r & 0xFF) << 16 | (g & 0xFF) << 8 | (b & 0xFF);
    }

    public int rgba() {
        return (r & 0xFF) << 24 | (g & 0xFF) << 16 | (b & 0xFF) << 8 | (a & 0xFF);
    }

    public abstract Color set(int Color);

    public Color set(Color Color) {
        r = Color.r;
        g = Color.g;
        b = Color.b;
        a = Color.a;
        return this;
    }

    public Color set(double r, double g, double b, double a) {
        return set((int) (255 * r), (int) (255 * g), (int) (255 * b), (int) (255 * a));
    }

    public Color set(int r, int g, int b, int a) {
        this.r = (byte) r;
        this.g = (byte) g;
        this.b = (byte) b;
        this.a = (byte) a;
        return this;
    }

    public static int packRGBA(byte r, byte g, byte b, byte a) {
        return (r & 0xFF) << 24 | (g & 0xFF) << 16 | (b & 0xFF) << 8 | (a & 0xFF);
    }

    public static int packARGB(byte r, byte g, byte b, byte a) {
        return (a & 0xFF) << 24 | (r & 0xFF) << 16 | (g & 0xFF) << 8 | (b & 0xFF);
    }

    public static int packRGBA(int r, int g, int b, int a) {
        return r << 24 | g << 16 | b << 8 | a;
    }

    public static int packARGB(int r, int g, int b, int a) {
        return a << 24 | r << 16 | g << 8 | b;
    }

    public static int packRGBA(double r, double g, double b, double a) {
        return (int) (r * 255) << 24 | (int) (g * 255) << 16 | (int) (b * 255) << 8 | (int) (a * 255);
    }

    public static int packARGB(double r, double g, double b, double a) {
        return (int) (a * 255) << 24 | (int) (r * 255) << 16 | (int) (g * 255) << 8 | (int) (b * 255);
    }

    public static int packRGBA(float[] data) {
        return packRGBA(data[0], data[1], data[2], data[3]);
    }

    public static int packARGB(float[] data) {
        return packARGB(data[0], data[1], data[2], data[3]);
    }

    public static void glColorRGBA(int Color) {
        float r = ((Color >> 24) & 0xFF) / 255F;
        float g = ((Color >> 16) & 0xFF) / 255F;
        float b = ((Color >> 8) & 0xFF) / 255F;
        float a = (Color & 0xFF) / 255F;
        GlStateManager.color(r, g, b, a);
    }

    public static void glColorARGB(int Color) {
        float r = ((Color >> 16) & 0xFF) / 255F;
        float g = ((Color >> 8) & 0xFF) / 255F;
        float b = (Color & 0xFF) / 255F;
        float a = ((Color >> 24 & 0xFF)) / 255F;
        GlStateManager.color(r, g, b, a);
    }

    public boolean equals(Color Color) {
        return Color != null && rgba() == Color.rgba();
    }
}
