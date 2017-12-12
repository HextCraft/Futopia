package net.thegaminghuskymc.futopia.items;

import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.huskylib.items.ItemSubBase;

public class ItemHammer extends ItemSubBase {

	public ItemHammer() {
		super("hammer", FTCreativeTabs.tools, EnumMaterialType.toStringArray());
	}

}
