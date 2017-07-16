package net.thegaminghuskymc.futopia.items;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;

public class ItemSeedBase extends ItemSeeds {

	public ItemSeedBase(String name, Block crop) {
		super(crop, Blocks.FARMLAND);
		setUnlocalizedName(name + "_seed");
		setRegistryName(name + "_seed");
		setCreativeTab(FTCreativeTabs.items);
	}

}
