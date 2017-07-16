package net.thegaminghuskymc.futopia.blocks.worldgen;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.huskylib.blocks.EnumBlock;

public class BlockBaseOresNether extends EnumBlock<EnumMaterialType> {

	public static final PropertyEnum<EnumMaterialType> TYPE = PropertyEnum.create("type", EnumMaterialType.class);

	public BlockBaseOresNether() {
		super(Material.ROCK, "nether_ore", FTCreativeTabs.world_gen, TYPE, EnumMaterialType.class,
				EnumMaterialType.toStringArray());
	}

}