package net.thegaminghuskymc.futopia.client.model;

import java.util.Collection;
import java.util.Collections;
import java.util.function.Function;

import com.google.common.collect.ImmutableSet;

import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.common.model.TRSRTransformation;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.client.model.bakedmodel.PipeBakedModel;

public class PipeModel implements IModel {
    @Override
    public IBakedModel bake(IModelState state, VertexFormat format,
    		Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter) {
        return new PipeBakedModel(state, format, bakedTextureGetter);
    }

    @Override
    public Collection<ResourceLocation> getDependencies() {
        return Collections.emptySet();
    }

    @Override
    public Collection<ResourceLocation> getTextures() {
        return ImmutableSet.of(new ResourceLocation(Refs.MODID, "blocks/isbmtexture"));
    }

    @Override
    public IModelState getDefaultState() {
        return TRSRTransformation.identity();
    }
}
