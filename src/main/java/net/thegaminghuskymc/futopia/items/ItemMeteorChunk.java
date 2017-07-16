package net.thegaminghuskymc.futopia.items;

import java.util.List;

import cofh.core.util.helpers.StringHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.huskylib.items.ItemBase;

public class ItemMeteorChunk extends ItemBase {

	public ItemMeteorChunk() {
		super("meteor_chunk", FTCreativeTabs.items);
	}

	@Override
	public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) {
		if (!StringHelper.isShiftKeyDown()) {
			tooltip.add("Hold " + StringHelper.getDeactivationText("Shift")
					+ StringHelper.getFlavorText(" for information."));
		} else {
			tooltip.add(StringHelper.getInfoText("Drops frome meteor blocks"));
			tooltip.add(StringHelper.getInfoText("Can be used to craft meteor blocks"));
		}
	}

}
