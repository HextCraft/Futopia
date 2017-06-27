package net.thegaminghuskymc.huskylib.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockNetherOreBase extends Block {
	
	public BlockNetherOreBase(String name, CreativeTabs creativetab) {
		super(Material.ROCK);
		setUnlocalizedName(name);
		setRegistryName(name);
		setHardness(5.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 1);
		setCreativeTab(creativetab);
	}

}
