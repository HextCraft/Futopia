package net.thegaminghuskymc.futopia.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;

public class BlockOreBase extends Block {
	
	public BlockOreBase(String name) {
		super(Material.ROCK);
		setUnlocalizedName(name);
		setRegistryName(name);
		setHardness(5.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 1);
		setCreativeTab(FTCreativeTabs.main);
	}
	
	/*@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune){
		if(this.getDefaultState() == MTBlocks.rQOre){
			return MTItems.rQuartz;
		}
		else if(this.getDefaultState() == MTBlocks.plOre){
			return MTItems.pIron;
		}
		else
			return Item.getItemFromBlock(this);
	}*/

}
