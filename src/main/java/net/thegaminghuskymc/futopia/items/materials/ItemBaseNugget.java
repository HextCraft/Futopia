package net.thegaminghuskymc.futopia.items.materials;

import net.minecraft.creativetab.CreativeTabs;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.huskylib.items.ItemSubBase;

public class ItemBaseNugget extends ItemSubBase {

    public ItemBaseNugget(CreativeTabs tabs) {
        super("nugget", tabs, EnumMaterialType.toStringArray());
    }

}
