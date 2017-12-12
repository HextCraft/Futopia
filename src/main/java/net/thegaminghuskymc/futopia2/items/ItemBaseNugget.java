package net.thegaminghuskymc.futopia2.items;

import de.keri.cubelib.item.ItemBase;
import net.thegaminghuskymc.futopia2.enums.EnumMaterialType;
import net.thegaminghuskymc.futopia2.init.FTCreativeTabs;

public class ItemBaseNugget extends ItemBase {

	public ItemBaseNugget() {
		super("nugget", EnumMaterialType.toStringArray());
		setCreativeTab(FTCreativeTabs.items);
	}

}
