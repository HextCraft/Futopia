package net.thegaminghuskymc.futopia.blocks.worldgen;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.huskylib2.lib.blocks.EnumBlock;

public class BlockBaseStorage extends EnumBlock<EnumMaterialType> {

	public static final PropertyEnum<EnumMaterialType> TYPE = PropertyEnum.create("type", EnumMaterialType.class);

	public BlockBaseStorage() {
		super(Material.IRON, "storage", FTCreativeTabs.main, TYPE, EnumMaterialType.class,
				EnumMaterialType.toStringArray());
	}

}
