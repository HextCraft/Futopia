package net.thegaminghuskymc.futopia.items;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.GameData;

public abstract class ItemFoodBase extends ItemFood {

	@SideOnly(Side.CLIENT)
	private TextureAtlasSprite texture;
	private String modid;
	private String itemName;

	public ItemFoodBase(String modid, String itemName, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		this.modid = modid;
		this.itemName = itemName;
		this.register();
	}

	public ItemFoodBase(String modid, String itemName, int amount, boolean isWolfFood) {
		super(amount, isWolfFood);
		this.modid = modid;
		this.itemName = itemName;
		this.register();
	}

	private void register() {
		this.setRegistryName(this.modid, this.itemName);
		this.setUnlocalizedName(this.modid + "." + this.itemName);
		this.setCreativeTab(getCreativeTab());

		GameData.register_impl(this);
	}

	@Override
	public CreativeTabs getCreativeTab() {
		return CreativeTabs.FOOD;
	}

	public String getModId() {
		return this.modid;
	}

	public String getInternalName() {
		return this.itemName;
	}

}
