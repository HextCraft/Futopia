package net.thegaminghuskymc.futopia.blocks;

import java.util.List;
import java.util.Random;

import cofh.lib.util.helpers.StringHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.tiles.TileEntityMachineBase;
import net.thegaminghuskymc.futopia.utils.Names;

public class BlockMachineBase extends Block {
	
	private static World world;
	private static IBlockState state;
	
	public BlockMachineBase(String name, TileEntity tileEntity) {
		super(Material.ROCK);
		setUnlocalizedName(name);
		setRegistryName(name);
		setHardness(5.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 1);
		setCreativeTab(FTCreativeTabs.machines);
		createTileEntity(tileEntity, world, state);
	}
	
	public BlockMachineBase(String name){
		this(name, new TileEntityMachineBase());
	}

	public TileEntity createTileEntity(TileEntity te, World world, IBlockState state) {
		return te;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune){
		return Item.getItemFromBlock(this);
	}
	
	@Override
    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) {
        if (!StringHelper.isShiftKeyDown()) {
            tooltip.add(Names.HelpToolTips.SHIFT_FOR_INFO);
        } else {
//        	tooltip.add(Names.HelpToolTips.WIP_BLOCK);
        	tooltip.add(Names.CraftingToolTips.MACHINE);
        }
    }

}
