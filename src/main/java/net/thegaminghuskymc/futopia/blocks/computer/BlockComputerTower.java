package net.thegaminghuskymc.futopia.blocks.computer;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.network.EnumDyeColor;
import net.thegaminghuskymc.huskylib.blocks.EnumBlock;

public class BlockComputerTower extends EnumBlock<EnumDyeColor> {

	public static final PropertyEnum<EnumDyeColor> TYPE = PropertyEnum.create("type", EnumDyeColor.class);

	public BlockComputerTower() {
		super(Material.IRON, "computer_tower", FTCreativeTabs.computer_parts, TYPE, EnumDyeColor.class,
				EnumDyeColor.toStringArray());
	}

}