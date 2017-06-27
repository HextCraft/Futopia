package net.thegaminghuskymc.futopia.items.materials;

import net.minecraft.creativetab.CreativeTabs;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.huskylib.items.ItemSubBase;

public class ItemBaseDust extends ItemSubBase {

    public ItemBaseDust(CreativeTabs tabs) {
        super("dust", tabs, EnumMaterialType.toStringArray());
    }

}
