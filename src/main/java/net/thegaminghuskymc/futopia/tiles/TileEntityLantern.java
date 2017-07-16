package net.thegaminghuskymc.futopia.tiles;

import codechicken.lib.colour.Colour;
import codechicken.lib.colour.ColourRGBA;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class TileEntityLantern extends TileEntityReliquia {

	private ItemStack frameMaterial = ItemStack.EMPTY;
	private Colour glassColor = new ColourRGBA(255, 255, 255, 255);

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		this.frameMaterial = new ItemStack(tag.getCompoundTag("frame_material"));
		this.glassColor = new ColourRGBA(tag.getInteger("glass_color"));
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setTag("frame_material", this.frameMaterial.writeToNBT(new NBTTagCompound()));
		tag.setInteger("glass_color", this.glassColor.rgba());
		return tag;
	}

	public void setFrameMaterial(ItemStack material) {
		this.frameMaterial = material;
	}

	public ItemStack getFrameMaterial() {
		return this.frameMaterial;
	}

	public void setGlassColor(Colour color) {
		this.glassColor = color;
	}

	public Colour getGlassColor() {
		return this.glassColor;
	}

}