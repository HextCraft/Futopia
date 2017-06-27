package net.thegaminghuskymc.huskylib.client.render.texture;

import java.util.function.Function;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;

public class PlaceholderTexture extends TextureAtlasSprite {

    protected PlaceholderTexture(String par1) {
        super(par1);
    }

    @Override
    public boolean hasCustomLoader(IResourceManager manager, ResourceLocation location) {
        return true;
    }
    
    @Override
    public boolean load(IResourceManager manager, ResourceLocation location,
    		Function<ResourceLocation, TextureAtlasSprite> textureGetter) {
    	return true;
    }
    
}
