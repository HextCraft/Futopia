package net.thegaminghuskymc.futopia.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.utils.StringHelper;
import net.thegaminghuskymc.huskylib.items.ItemBase;

public class ItemWindowsWasher extends ItemBase {

    public ItemWindowsWasher() {
        super("windows_washer", FTCreativeTabs.materials);
    }

    @Override
    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) {
        if (!StringHelper.isShiftKeyDown()) {
            tooltip.add("Hold " + StringHelper.getDeactivationText("Shift") + StringHelper.getFlavorText(" for information."));
        } else {
            tooltip.add(StringHelper.getNoticeText("This is used to clean your windows"));
            tooltip.add(StringHelper.getNoticeText("Expirience the POWER of THE FUTURE!"));
            tooltip.add(StringHelper.getNoticeText("It can get the TOUGH STRAINS OUT!"));
            tooltip.add(StringHelper.getNoticeText("Get it at the store for $19.99."));
            tooltip.add(StringHelper.getNoticeText("Please don't drink the contents of this bottle."));
            tooltip.add(StringHelper.getNoticeText("Like serioustly, are you that retarded?"));
        }
    }

}