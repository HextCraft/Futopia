package net.thegaminghuskymc.futopia2.blocks;

import de.keri.cubelib.block.BlockBase;
import net.minecraft.block.material.Material;
import net.thegaminghuskymc.futopia2.enums.EnumMaterialType;
import net.thegaminghuskymc.futopia2.init.FTCreativeTabs;

public class BlockBaseStorage extends BlockBase {

	public BlockBaseStorage() {
		super("storage", Material.IRON, EnumMaterialType.toStringArray());
		setCreativeTab(FTCreativeTabs.main);
	}

}
