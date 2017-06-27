package net.thegaminghuskymc.futopia.items.materials;

import net.minecraft.creativetab.CreativeTabs;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.huskylib.items.ItemSubBase;

public class ItemBasePlate extends ItemSubBase {

    public ItemBasePlate(CreativeTabs tabs) {
        super("plate", tabs, EnumMaterialType.toStringArray());
    }

}
