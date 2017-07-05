package net.thegaminghuskymc.futopia.items;

import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.huskylib.items.ItemSubBase;

public class ItemSaw extends ItemSubBase {

    public ItemSaw() {
        super("saw", FTCreativeTabs.items, EnumMaterialType.toStringArray());
    }

}
