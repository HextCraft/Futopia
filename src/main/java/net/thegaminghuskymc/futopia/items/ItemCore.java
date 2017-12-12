package net.thegaminghuskymc.futopia.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemCore extends Item {

	protected String name;
	protected String modName;

	public ItemCore() {

		this("futopia");
	}

	public ItemCore(String modName) {

		this.modName = modName;
		setHasSubtypes(true);
	}

	@Override
	public boolean isEnchantable(ItemStack stack) {

		return false;
	}

}
