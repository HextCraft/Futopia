package net.thegaminghuskymc.futopia.items.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.futopia.blocks.computer.BlockMonitorNew;
import net.thegaminghuskymc.futopia.utils.ItemHelper;

public class ItemBlockMonitor extends ItemBlockCore {

	public ItemBlockMonitor(Block block) {

		super(block);
		setHasSubtypes(true);
		setMaxDamage(0);
		setRegistryName(block.getRegistryName());
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {

		return "tile.monitor." + BlockMonitorNew.MonitorColors.byMetadata(ItemHelper.getItemDamage(stack)).getName() + ".name";
	}

}