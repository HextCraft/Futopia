package net.thegaminghuskymc.futopia.client.render;

import org.lwjgl.opengl.GL11;

import codechicken.lib.colour.Colour;
import codechicken.lib.colour.ColourRGBA;
import codechicken.lib.render.CCModel;
import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.buffer.BakingVertexBuffer;
import codechicken.lib.texture.TextureUtils;
import codechicken.lib.vec.Cuboid6;
import codechicken.lib.vec.Vector3;
import codechicken.lib.vec.uv.IconTransformation;
import keri.ninetaillib.lib.render.IBlockRenderingHandler;
import keri.ninetaillib.lib.render.RenderingRegistry;
import keri.ninetaillib.lib.util.BlockAccessUtils;
import keri.ninetaillib.lib.util.ModelUtils;
import keri.ninetaillib.lib.util.RenderUtils;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.tiles.TileEntityLantern;

@SideOnly(Side.CLIENT)
public class RenderLantern implements IBlockRenderingHandler {

	public static final RenderLantern INSTANCE = new RenderLantern();
	public static EnumBlockRenderType RENDER_TYPE;
	private static CCModel[] BLOCK_MODEL_VERTICAL;
	private static CCModel[] BLOCK_MODEL_HORIZONTAL;

	static {
		RENDER_TYPE = RenderingRegistry.getNextAvailableType();
		RenderingRegistry.registerRenderingHandler(INSTANCE);
		Cuboid6[] BOUNDS_VERTICAL = new Cuboid6[] { new Cuboid6(5.5D, 0D, 5.5D, 10.5D, 1D, 10.5D),
				new Cuboid6(7D, 1D, 7D, 9D, 4D, 9D), new Cuboid6(5D, 4D, 5D, 11D, 5D, 11D),
				new Cuboid6(5D, 5D, 5D, 6D, 11D, 6D), new Cuboid6(10D, 5D, 5D, 11D, 11D, 6D),
				new Cuboid6(10D, 5D, 10D, 11D, 11D, 11D), new Cuboid6(5D, 5D, 10D, 6D, 11D, 11D),
				new Cuboid6(5D, 11D, 5D, 11D, 12D, 11D), new Cuboid6(6.75D, 5D, 6.75D, 9.25D, 5.5D, 9.25D),
				new Cuboid6(5.5D, 5D, 6D, 6D, 11D, 10D), new Cuboid6(10D, 5D, 6D, 10.5D, 11D, 10D),
				new Cuboid6(6D, 5D, 10D, 10D, 11D, 10.5D), new Cuboid6(6D, 5D, 5.5D, 10D, 11D, 6D), };
		Cuboid6[] BOUNDS_HORIZONTAL = new Cuboid6[] { new Cuboid6(5.5D, 8.5D, 15D, 10.5D, 13.5D, 16D),
				new Cuboid6(7D, 10D, 7D, 9D, 12D, 15D), new Cuboid6(5D, 2D, 5D, 11D, 3D, 11D),
				new Cuboid6(5D, 3D, 5D, 6D, 9D, 6D), new Cuboid6(10D, 3D, 5D, 11D, 9D, 6D),
				new Cuboid6(10D, 3D, 10D, 11D, 9D, 11D), new Cuboid6(5D, 3D, 10D, 6D, 9D, 11D),
				new Cuboid6(5D, 9D, 5D, 11D, 10D, 11D), new Cuboid6(6.75D, 3D, 6.75D, 9.25D, 3.5D, 9.25D),
				new Cuboid6(5.5D, 3D, 6D, 6D, 9D, 10D), new Cuboid6(10D, 3D, 6D, 10.5D, 9D, 10D),
				new Cuboid6(6D, 3D, 10D, 10D, 9D, 10.5D), new Cuboid6(6D, 3D, 5.5D, 10D, 9D, 6D), };
		BLOCK_MODEL_VERTICAL = ModelUtils.getNormalized(BOUNDS_VERTICAL);
		ModelUtils.rotate(BLOCK_MODEL_VERTICAL[0], 45D, new Vector3(0D, 1D, 0D), new Vector3(8D, 8D, 8D));
		ModelUtils.rotate(BLOCK_MODEL_VERTICAL[1], 45D, new Vector3(0D, 1D, 0D), new Vector3(8D, 8D, 8D));
		BLOCK_MODEL_HORIZONTAL = ModelUtils.getNormalized(BOUNDS_HORIZONTAL);
		ModelUtils.rotate(BLOCK_MODEL_HORIZONTAL[0], 45D, new Vector3(0D, 0D, 1D), new Vector3(8D, 11D, 15.5D));
	}

	@Override
	@SuppressWarnings("deprecation")
	public boolean renderWorld(IBlockAccess world, BlockPos pos, BufferBuilder buffer, BlockRenderLayer layer) {
		TileEntityLantern tile = (TileEntityLantern) world.getTileEntity(pos);
		EnumFacing orientation = EnumFacing.getFront(BlockAccessUtils.getBlockMetadata(world, pos));
		TextureAtlasSprite textureFuel = TextureUtils.getTexture("minecraft:blocks/coal_block");
		TextureAtlasSprite textureGlass = TextureUtils.getTexture("minecraft:blocks/glass_white");

		if (tile != null) {
			Block materialBlock = Block.getBlockFromItem(tile.getFrameMaterial().getItem());
			IBlockState materialState = materialBlock.getStateFromMeta(tile.getFrameMaterial().getMetadata());
			TextureAtlasSprite textureBase = TextureUtils.getIconsForBlock(materialState, 0)[0];
			BakingVertexBuffer parent = BakingVertexBuffer.create();
			parent.begin(GL11.GL_QUADS, DefaultVertexFormats.ITEM);
			CCRenderState renderState = CCRenderState.instance();
			renderState.reset();
			renderState.bind(parent);
			CCModel[] model = orientation.getIndex() > 1 ? BLOCK_MODEL_HORIZONTAL : BLOCK_MODEL_VERTICAL;

			for (int i = 0; i < model.length; i++) {
				CCModel part = model[i].copy();

				switch (orientation) {
				case DOWN:
					ModelUtils.rotate(part, i < 2 ? 180D : 0D, new Vector3(1D, 0D, 0D), new Vector3(8D, 8D, 8D));
					break;
				case UP:
					break;
				case NORTH:
					break;
				case EAST:
					ModelUtils.rotate(part, 270D, new Vector3(0D, 1D, 0D), new Vector3(8D, 8D, 8D));
					break;
				case SOUTH:
					ModelUtils.rotate(part, 180D, new Vector3(0D, 1D, 0D), new Vector3(8D, 8D, 8D));
					break;
				case WEST:
					ModelUtils.rotate(part, 90D, new Vector3(0D, 1D, 0D), new Vector3(8D, 8D, 8D));
					break;
				}

				if (i < 8) {
					part.render(renderState, new IconTransformation(textureBase));
				} else if (i == 8) {
					part.render(renderState, new IconTransformation(textureFuel));
				} else {
					if (layer == BlockRenderLayer.TRANSLUCENT) {
						renderState.alphaOverride = 88;
						part.setColour(tile.getGlassColor().rgba());
						part.render(renderState, new IconTransformation(textureGlass));
						renderState.alphaOverride = 255;
					}
				}
			}

			parent.finishDrawing();
			return RenderUtils.renderQuads(buffer, world, pos, parent.bake());
		}

		return false;
	}

	@Override
	public void renderDamage(IBlockAccess world, BlockPos pos, BufferBuilder buffer, TextureAtlasSprite texture) {
		CCRenderState renderState = CCRenderState.instance();
		renderState.reset();
		renderState.bind(buffer);
		EnumFacing orientation = EnumFacing.getFront(BlockAccessUtils.getBlockMetadata(world, pos));
		CCModel[] model = orientation.getIndex() > 1 ? BLOCK_MODEL_HORIZONTAL : BLOCK_MODEL_VERTICAL;

		for (int i = 0; i < model.length; i++) {
			CCModel part = model[i].copy();

			switch (orientation) {
			case DOWN:
				ModelUtils.rotate(part, i < 2 ? 180D : 0D, new Vector3(1D, 0D, 0D), new Vector3(8D, 8D, 8D));
				break;
			case UP:
				break;
			case NORTH:
				break;
			case EAST:
				ModelUtils.rotate(part, 270D, new Vector3(0D, 1D, 0D), new Vector3(8D, 8D, 8D));
				break;
			case SOUTH:
				ModelUtils.rotate(part, 180D, new Vector3(0D, 1D, 0D), new Vector3(8D, 8D, 8D));
				break;
			case WEST:
				ModelUtils.rotate(part, 90D, new Vector3(0D, 1D, 0D), new Vector3(8D, 8D, 8D));
				break;
			}

			part.render(renderState, new IconTransformation(texture));
		}
	}

	@Override
	@SuppressWarnings("deprecation")
	public void renderInventory(ItemStack stack, BufferBuilder buffer) {
		int lastBrightness = (int) OpenGlHelper.lastBrightnessY << 16 | (int) OpenGlHelper.lastBrightnessX;
		TextureAtlasSprite textureFuel = TextureUtils.getTexture("minecraft:blocks/coal_block");
		TextureAtlasSprite textureGlass = TextureUtils.getTexture("minecraft:blocks/glass_white");
		Tessellator.getInstance().draw();

		if (stack.getTagCompound() != null) {
			ItemStack frameMaterial = new ItemStack(stack.getTagCompound().getCompoundTag("frame_material"));
			Colour glassColor = new ColourRGBA(stack.getTagCompound().getInteger("glass_color"));
			Block materialBlock = Block.getBlockFromItem(frameMaterial.getItem());
			IBlockState materialState = materialBlock.getStateFromMeta(frameMaterial.getMetadata());
			TextureAtlasSprite textureBase = TextureUtils.getIconsForBlock(materialState, 0)[0];

			if (textureBase != null) {
				GlStateManager.pushMatrix();
				GlStateManager.enableLighting();
				buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.ITEM);
				CCRenderState renderState = CCRenderState.instance();
				renderState.reset();
				renderState.bind(buffer);
				renderState.brightness = lastBrightness;

				for (int i = 0; i < BLOCK_MODEL_VERTICAL.length; i++) {
					CCModel part = BLOCK_MODEL_VERTICAL[i].copy();

					if (i < 8) {
						part.render(renderState, new IconTransformation(textureBase));
					} else if (i == 8) {
						part.render(renderState, new IconTransformation(textureFuel));
					} else {
						part.setColour(glassColor.rgba());
						part.render(renderState, new IconTransformation(textureGlass));
					}
				}

				Tessellator.getInstance().draw();
				GlStateManager.popMatrix();
			}
		}

		buffer.begin(GL11.GL_QUADS, RenderUtils.getFormatWithLightMap(DefaultVertexFormats.ITEM));
	}

	@Override
	public EnumBlockRenderType getRenderType() {
		return RENDER_TYPE;
	}

}