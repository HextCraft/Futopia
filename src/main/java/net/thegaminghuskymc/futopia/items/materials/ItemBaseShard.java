package net.thegaminghuskymc.futopia.items.materials;

import net.minecraft.creativetab.CreativeTabs;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.huskylib.items.ItemSubBase;

public class ItemBaseShard extends ItemSubBase {

    public ItemBaseShard(CreativeTabs tabs) {
        super("shard", tabs, EnumMaterialType.toStringArray());
    }

}
