package net.thegaminghuskymc.futopia.items;

import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.network.EnumUpgradeType;
import net.thegaminghuskymc.huskylib.items.ItemSubBase;

public class ItemUpgrades extends ItemSubBase {

	public ItemUpgrades() {
		super("upgrade", FTCreativeTabs.items, EnumUpgradeType.toStringArray());
	}

}
