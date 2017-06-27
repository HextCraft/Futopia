package net.thegaminghuskymc.futopia.items.materials;

import net.minecraft.creativetab.CreativeTabs;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.huskylib.items.ItemSubBase;

public class ItemBaseIngot extends ItemSubBase {

    public ItemBaseIngot(CreativeTabs tabs) {
        super("alloy", tabs, EnumMaterialType.toStringArray());
    }

}
