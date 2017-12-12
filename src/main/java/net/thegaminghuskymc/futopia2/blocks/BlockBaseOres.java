package net.thegaminghuskymc.futopia2.blocks;

import de.keri.cubelib.block.BlockBase;
import net.minecraft.block.material.Material;
import net.thegaminghuskymc.futopia2.enums.EnumMaterialType;
import net.thegaminghuskymc.futopia2.init.FTCreativeTabs;

public class BlockBaseOres extends BlockBase {

	public BlockBaseOres() {
		super("ore", Material.ROCK, EnumMaterialType.toStringArray());
		setCreativeTab(FTCreativeTabs.main);
	}

}