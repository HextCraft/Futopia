package net.thegaminghuskymc.futopia2.blocks;

import de.keri.cubelib.block.BlockBase;
import net.minecraft.block.material.Material;
import net.thegaminghuskymc.futopia2.enums.EnumMaterialType;
import net.thegaminghuskymc.futopia2.init.FTCreativeTabs;

public class BlockBaseOresNether extends BlockBase {

	public BlockBaseOresNether() {
		super("nether_ore", Material.ROCK, EnumMaterialType.toStringArray());
		setCreativeTab(FTCreativeTabs.main);
	}

}