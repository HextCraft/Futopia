package net.thegaminghuskymc.futopia.utils.test.helpers;

import java.util.Map;

import org.lwjgl.opengl.GL11;

import com.google.common.collect.Maps;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.vertex.VertexBuffer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.Vec3d;

public enum RenderHelper {
    INSTANCE;

    private final Map<EnumFacing, Vec3d> rotations = Maps.newEnumMap(EnumFacing.class);

    private RenderHelper() {
        rotations.put(EnumFacing.UP, Vec3d.ZERO);
        rotations.put(EnumFacing.DOWN, new Vec3d(180, 0, 0));
        EnumFacing face = EnumFacing.SOUTH;
        for (int a = 0; a < 360; a += 90) {
            rotations.put(face, new Vec3d(90, 0, a));
            face = face.rotateY();
        }
    }

    public static void setGLColorFromInt(int color) {
        setGLColorFromIntPlusAlpha(0xFF_00_00_00 | color);
    }

    public static void setGLColorFromIntPlusAlpha(int color) {
        float alpha = (color >> 24 & 255) / 255.0F;
        float red = (color >> 16 & 255) / 255.0F;
        float green = (color >> 8 & 255) / 255.0F;
        float blue = (color & 255) / 255.0F;

        GlStateManager.color(red, green, blue, alpha);
    }

    public static void setWorldRendererRGB(BufferBuilder worldRenderer, Vec3d color) {
        worldRenderer.color((float) color.x, (float) color.y, (float) color.z, 1f);
    }

    public static void addWorldRendererVertex(BufferBuilder worldRenderer, Vec3d vertex) {
        worldRenderer.pos(vertex.x, vertex.y, vertex.z);
    }

    public static void putWorldRendererColorMultiplier(BufferBuilder worldRenderer, Vec3d color, int index) {
        worldRenderer.putColorMultiplier((float) color.x, (float) color.y, (float) color.z, index);
    }

    public static void translate(Vec3d vector) {
        GL11.glTranslated(vector.x, vector.y, vector.z);
    }

    public static void vertex3d(Vec3d vec) {
        GL11.glVertex3d(vec.x, vec.y, vec.z);
    }

  /*  public static void vertex3f(Vec3d vec) {
        vertex3f(Utils.convertFloat(vec));
    }

    public static void vertex3f(Vector3f vec) {
        GL11.glVertex3f(vec.x, vec.y, vec.z);
    }*/

    /** Rotates the current matrix to face the specified direction, assuming you want to draw your models upwards */
    public static void rotate(EnumFacing face) {
        rotate(INSTANCE.rotations.get(face));
    }

    public static void rotate(Vec3d rotation) {
        GL11.glRotated(rotation.x, 1, 0, 0);
        GL11.glRotated(rotation.y, 0, 1, 0);
        GL11.glRotated(rotation.z, 0, 0, 1);
    }
}
