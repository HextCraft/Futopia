package net.thegaminghuskymc.futopia.blocks.normal;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.client.model.ModelLoader;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;

public class BlockStairsBase extends BlockStairs implements IModeledBlock {
	public boolean isOpaqueCube = true, isFullCube = true;
	public BlockRenderLayer layer = BlockRenderLayer.SOLID;
	public BlockStairsBase(IBlockState state, String name, boolean addToTab){
		super(state);
		this.useNeighborBrightness = true;
		setUnlocalizedName(name);
		setRegistryName(Refs.MODID+":"+name);
		if (addToTab){
			setCreativeTab(FTCreativeTabs.main);
		}
    }
	
	public BlockStairsBase setIsOpaqueCube(boolean b){
		isOpaqueCube = b;
		return this;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state){
		return isOpaqueCube;
	}
	
	public BlockStairsBase setIsFullCube(boolean b){
		isFullCube = b;
		return this;
	}
	
	@Override
	public boolean isFullCube(IBlockState state){
		return isFullCube;
	}
	
	public BlockStairsBase setHarvestProperties(String toolType, int level){
		super.setHarvestLevel(toolType, level);
		return this;
	}
	
	@Override
	public void initModel(){
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName().toString()));
	}
}
