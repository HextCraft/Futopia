package net.thegaminghuskymc.futopia.utils.test.helpers;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

public class BufferBuilderHelper {

    private BufferBuilder rend;

    public BufferBuilderHelper(BufferBuilder rend) {
        this.rend = rend;
    }

    public void startDrawingQuads() {
        rend.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
    }

    public BufferBuilder pos(double x, double y, double z) {
        return rend.pos(x, y, z);
    }

    public BufferBuilder pos(float x, float y, float z) {
        return rend.pos(x, y, z);
    }

    public void setTranslation(int x, int y, int z) {
        rend.setTranslation(x, y, z);
    }

    public void addVertexWithUV(double x, double y, double z, float u, float v) {
        rend.pos(x, y, z).tex(u, v).endVertex();
    }

    public void normal(float x, float y, float z) {
        rend.normal(x, y, z);
    }

    public void setBrightness(int brightness) {
        //TODO Find replacement for setBrightness method
    }

    public void color(float r, float g, float b, float a) {
        rend.color(r, g, b, a);
    }
}