package net.thegaminghuskymc.huskylib.utils.color;

import java.awt.image.BufferedImage;

import net.minecraft.util.ResourceLocation;
import net.thegaminghuskymc.huskylib.client.render.texture.TextureUtils;
import net.thegaminghuskymc.huskylib.utils.math.MathHelper;

public class CustomGradient {

    public int[] gradient;

    public CustomGradient(ResourceLocation textureFile) {
        BufferedImage img = TextureUtils.loadBufferedImage(textureFile);
        if (img == null) {
            throw new RuntimeException("File not found: " + textureFile.toString());
        }

        int[] data = new int[img.getWidth()];
        img.getRGB(0, 0, img.getWidth(), 1, data, 0, img.getWidth());
        gradient = new int[img.getWidth()];
        for (int i = 0; i < data.length; i++) {
            gradient[i] = (data[i] << 8) | (((data[i]) >> 24) & 0xFF);
        }
    }

    public ColorRGBA getColor(double position) {
        return new ColorRGBA(getColorI(position));
    }

    public int getColorI(double position) {
        int off = (int) MathHelper.clip(gradient.length * position, 0, gradient.length - 1);
        return gradient[off];
    }
}
