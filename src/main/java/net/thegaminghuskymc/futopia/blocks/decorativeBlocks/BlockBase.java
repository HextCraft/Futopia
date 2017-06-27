package net.thegaminghuskymc.futopia.blocks.decorativeBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.model.ModelLoader;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.blocks.normal.IModeledBlock;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.huskylib.RebornRegistry;

public class BlockBase extends Block implements IModeledBlock {
	
	public Item itemBlock = null;
	public boolean isOpaqueCube = true, isFullCube = true, isBeaconBase = false;
	public BlockRenderLayer layer = BlockRenderLayer.SOLID;
	
	public BlockBase(Material material, String name, boolean addToTab){
		super(material);
		setUnlocalizedName(name);
		setRegistryName(Refs.MODID+":"+name);
		if (addToTab){
			setCreativeTab(FTCreativeTabs.main);
		}
		RebornRegistry.registerBlock(this);
		RebornRegistry.registerItem(new ItemBlock(this), getRegistryName());
    }
	
	public BlockBase setIsOpaqueCube(boolean b){
		isOpaqueCube = b;
		return this;
	}
	
	public BlockBase setBeaconBase(boolean b){
		isBeaconBase = b;
		return this;
	}
	
	@Override
	public boolean isBeaconBase(IBlockAccess world, BlockPos pos, BlockPos beacon){
		return isBeaconBase;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state){
		return isOpaqueCube;
	}
	
	public BlockBase setIsFullCube(boolean b){
		isFullCube = b;
		return this;
	}
	
	@Override
	public boolean isFullCube(IBlockState state){
		return isFullCube;
	}
	
	@Override
	public boolean isFullBlock(IBlockState state){
		return isFullCube;
	}
	
	public BlockBase setHarvestProperties(String toolType, int level){
		super.setHarvestLevel(toolType, level);
		return this;
	}
	
	@Override
	public void initModel(){
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName().toString(),"inventory"));
	}
}
