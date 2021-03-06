package net.thegaminghuskymc.futopia.blocks.normal;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.thegaminghuskymc.futopia.Reference;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;

public class BlockWallBase extends BlockWall implements IModeledBlock {

	public boolean isOpaqueCube = true;
	public boolean isFullCube = true;

	public BlockRenderLayer layer = BlockRenderLayer.SOLID;

	public BlockWallBase(Block block, String name, boolean addToTab) {
		super(block);
		setUnlocalizedName(name);
		setRegistryName(Reference.MODID, name);
		setCreativeTab(FTCreativeTabs.main);
	}

	@Override
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
		list.add(new ItemStack(this, 1));
	}

	public BlockWallBase setIsOpaqueCube(boolean b) {
		isOpaqueCube = b;
		return this;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return isOpaqueCube;
	}

	public BlockWallBase setIsFullCube(boolean b) {
		isFullCube = b;
		return this;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return isFullCube;
	}

	public BlockWallBase setHarvestProperties(String toolType, int level) {
		super.setHarvestLevel(toolType, level);
		return this;
	}

	@Override
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0,
				new ModelResourceLocation(getRegistryName().toString()));
	}
}
