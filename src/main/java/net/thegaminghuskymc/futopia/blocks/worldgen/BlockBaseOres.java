package net.thegaminghuskymc.futopia.blocks.worldgen;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.huskylib.blocks.EnumBlock;

public class BlockBaseOres extends EnumBlock<EnumMaterialType> {

	public static final PropertyEnum<EnumMaterialType> TYPE = PropertyEnum.create("type", EnumMaterialType.class);

	public BlockBaseOres() {
		super(Material.ROCK, "ore", FTCreativeTabs.world_gen, TYPE, EnumMaterialType.class,
				EnumMaterialType.toStringArray());
	}

}