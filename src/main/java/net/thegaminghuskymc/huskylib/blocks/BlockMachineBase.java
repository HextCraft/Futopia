package net.thegaminghuskymc.huskylib.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.thegaminghuskymc.huskylib.tiles.TileEntityMachineBase;

public class BlockMachineBase extends Block {
	
	private static World world;
	private static IBlockState state;
	
	public BlockMachineBase(String name, TileEntity tileEntity, CreativeTabs creativetab) {
		super(Material.ROCK);
		setUnlocalizedName(name);
		setRegistryName(name);
		setHardness(5.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 1);
		setCreativeTab(creativetab);
		createTileEntity(tileEntity, world, state);
	}
	
	public BlockMachineBase(String name, CreativeTabs creativetab){
		this(name, new TileEntityMachineBase(), creativetab);
	}

	public TileEntity createTileEntity(TileEntity te, World world, IBlockState state) {
		return te;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune){
		return Item.getItemFromBlock(this);
	}

}
