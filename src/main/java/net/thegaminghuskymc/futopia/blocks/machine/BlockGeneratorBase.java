package net.thegaminghuskymc.futopia.blocks.machine;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.utils.Names;
import net.thegaminghuskymc.futopia.utils.StringHelper;
import net.thegaminghuskymc.huskylib.tiles.TileEntityBase;

import java.util.List;

public class BlockGeneratorBase extends BlockMachineBase {

	public BlockGeneratorBase(String modid, String name) {
		super(modid, name + "_generator", new TileEntityBase(), FTCreativeTabs.machines);
	}

	public BlockGeneratorBase(String modid, String name, TileEntity te) {
		super(modid, name + "_generator", te, FTCreativeTabs.machines);
	}

	@Override
	public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) {
		if (!StringHelper.isShiftKeyDown()) {
			tooltip.add(Names.HelpToolTips.SHIFT_FOR_INFO);
		} else {
			tooltip.add(Names.CraftingToolTips.GENERATOR);
		}
	}

}
