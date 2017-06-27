package net.thegaminghuskymc.futopia.blocks;

import java.util.List;

import cofh.lib.util.helpers.StringHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.thegaminghuskymc.futopia.tiles.TileEntityMachineBase;
import net.thegaminghuskymc.futopia.utils.Names;

public class BlockGeneratorBase extends BlockMachineBase{

	public BlockGeneratorBase(String name) {
		super(name + "_generator", new TileEntityMachineBase());
	}
	
	public BlockGeneratorBase(String name, TileEntity te) {
		super(name + "_generator", te);
	}
	
	@Override
    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) {
        if (!StringHelper.isShiftKeyDown()) {
            tooltip.add(Names.HelpToolTips.SHIFT_FOR_INFO);
        } else {
        	tooltip.add(Names.HelpToolTips.WIP_BLOCK);
        	tooltip.add(Names.CraftingToolTips.GENERATOR);
        }
    }
	
	/*@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		if(!playerIn.isSneaking()){
			playerIn.openGui(Futopia.INSTANCE, MTGuiHandler.COAL_GENERATOR, worldIn, pos.getX(), pos.getY(), pos.getZ());
			return true;
		}
		else
			return false;
	}*/

}
