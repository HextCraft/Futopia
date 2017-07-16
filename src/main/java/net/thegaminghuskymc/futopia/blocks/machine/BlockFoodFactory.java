package net.thegaminghuskymc.futopia.blocks.machine;

import java.util.List;

import cofh.core.util.helpers.StringHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.utils.BlockNames;
import net.thegaminghuskymc.futopia.utils.Names;
import net.thegaminghuskymc.huskylib.blocks.BlockMachineBase;

public class BlockFoodFactory extends BlockMachineBase {

	public BlockFoodFactory() {
		super(Refs.MODID, BlockNames.FOOD_FACTORY, FTCreativeTabs.machines);
	}

	@Override
	public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) {
		if (!StringHelper.isShiftKeyDown()) {
			tooltip.add("Hold" + StringHelper.getDeactivationText(" Shift ")
					+ StringHelper.getFlavorText("for information."));
		} else {
			tooltip.add(Names.CraftingToolTips.FOOD_FACTORY);
		}
	}

}
