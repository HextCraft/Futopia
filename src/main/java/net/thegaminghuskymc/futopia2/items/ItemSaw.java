package net.thegaminghuskymc.futopia2.items;

import de.keri.cubelib.item.ItemBase;
import net.thegaminghuskymc.futopia2.enums.EnumMaterialType;
import net.thegaminghuskymc.futopia2.init.FTCreativeTabs;

public class ItemSaw extends ItemBase {

	public ItemSaw() {
		super("saw", EnumMaterialType.toStringArray());
		setCreativeTab(FTCreativeTabs.items);
	}

}
