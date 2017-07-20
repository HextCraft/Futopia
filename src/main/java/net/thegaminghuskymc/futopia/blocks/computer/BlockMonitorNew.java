package net.thegaminghuskymc.futopia.blocks.computer;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.network.EnumDyeColor;
import net.thegaminghuskymc.huskylib.blocks.EnumBlock;

public class BlockMonitorNew extends EnumBlock<EnumDyeColor> {
	
	public static final PropertyEnum<EnumDyeColor> COLOR = PropertyEnum.create("color", EnumDyeColor.class);

	public BlockMonitorNew() {
		super(Material.IRON, "monitor", FTCreativeTabs.computer_parts, COLOR, EnumDyeColor.class, EnumDyeColor.toStringArray());
	}

}
