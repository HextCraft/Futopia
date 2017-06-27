package net.thegaminghuskymc.futopia.items.materials;

import net.minecraft.creativetab.CreativeTabs;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.huskylib.items.ItemSubBase;

public class ItemBaseGear extends ItemSubBase {

    public ItemBaseGear(CreativeTabs tabs) {
        super("gear", tabs, EnumMaterialType.toStringArray());
    }

}
