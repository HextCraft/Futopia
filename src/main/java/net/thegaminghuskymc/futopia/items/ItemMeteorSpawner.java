package net.thegaminghuskymc.futopia.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.utils.StringHelper;
import net.thegaminghuskymc.huskylib.items.ItemBase;

import java.util.List;

public class ItemMeteorSpawner extends ItemBase {

	public ItemMeteorSpawner() {
		super("meteor_spawner", FTCreativeTabs.items);
	}

	@Override
	public void addInformation(ItemStack stack, World playerIn, List<String> tooltip, ITooltipFlag advanced) {
		if (!StringHelper.isShiftKeyDown()) {
			tooltip.add("Hold " + StringHelper.getDeactivationText("Shift")
					+ StringHelper.getFlavorText(" for information."));
		} else {
			tooltip.add(StringHelper.getActivationText("This is used to spawn meteors"));
			tooltip.add(StringHelper.getActivationText("Do not abuse it!"));
		}
	}

}