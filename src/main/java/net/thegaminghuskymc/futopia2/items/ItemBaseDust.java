package net.thegaminghuskymc.futopia2.items;

import de.keri.cubelib.item.ItemBase;
import net.thegaminghuskymc.futopia2.enums.EnumMaterialType;
import net.thegaminghuskymc.futopia2.init.FTCreativeTabs;

public class ItemBaseDust extends ItemBase {

	public ItemBaseDust() {
		super("dust", EnumMaterialType.toStringArray());
		setCreativeTab(FTCreativeTabs.items);
	}

}
