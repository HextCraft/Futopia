package net.thegaminghuskymc.futopia.blocks.worldgen;

import net.minecraft.block.material.Material;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.huskylib.blocks.BlockSubBase;

public class BlockBaseOres extends BlockSubBase{

	public BlockBaseOres() {
		super("ore", Material.ROCK, FTCreativeTabs.world_gen, EnumMaterialType.toStringArray());
	}

}
