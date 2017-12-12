package net.thegaminghuskymc.futopia2.items;

import de.keri.cubelib.item.ItemBase;
import net.thegaminghuskymc.futopia2.enums.EnumMaterialType;
import net.thegaminghuskymc.futopia2.init.FTCreativeTabs;

public class ItemBaseIngot extends ItemBase {

	public ItemBaseIngot() {
		super("alloy", EnumMaterialType.toStringArray());
		setCreativeTab(FTCreativeTabs.items);
	}

}
