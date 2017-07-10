package net.thegaminghuskymc.futopia.blocks.computer;

import java.util.List;

import cofh.core.util.helpers.StringHelper;
import net.minecraft.block.BlockBed;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.client.gui.GuiHandler;
import net.thegaminghuskymc.futopia.utils.BlockNames;

public class BlockProjectTable extends BlockComputerBase {
	
	private static AxisAlignedBB AABB_NORTH = new AxisAlignedBB(0.87f, 0.88f, 0.44f, 0.12f, 2f/16f, 0.56f);
	private static AxisAlignedBB AABB_SOUTH = new AxisAlignedBB(0.87f, 0.88f, 0.44f, 0.12f, 2f/16f, 0.56f);
	private static AxisAlignedBB AABB_EAST = new AxisAlignedBB(0.45f, 0.88f, 0.13f, 0.56f, 2f/16f, 0.87f);
	private static AxisAlignedBB AABB_WEST = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.01D, 1D, 0.6D);

    public BlockProjectTable() {
        super(BlockNames.PROJECT_TABLENAME);
    }

    @Override
    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) {
        if (!StringHelper.isShiftKeyDown()) {
            tooltip.add("Hold " + StringHelper.getDeactivationText("Shift") + StringHelper.getFlavorText(" for information."));
        } else {
            tooltip.add(StringHelper.getInfoText("This block is used to craft special blocks"));
        }
    }
    
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
    		EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
    	
    	if(worldIn.isRemote & !playerIn.isSneaking()){
    		playerIn.openGui(Futopia.INSTANCE, GuiHandler.PROJECT_TABLE, worldIn, pos.getX(), pos.getY(), pos.getZ());
    	}
    	
    	return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
    	switch(state.getValue(FACING)){
    		case NORTH:
    			return AABB_NORTH;
    		case SOUTH:
    			return AABB_SOUTH;
			case EAST:
				return AABB_EAST;
			case WEST:
				return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.01D, 1D, 0.6D);
			default:
				return new AxisAlignedBB(0, 0, 0, 1, 1, 1);
    	}
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
    	switch(blockState.getValue(FACING)){
    		case NORTH:
    			return new AxisAlignedBB(0.87f, 0.88f, 0.44f, 0.12f, 2f/16f, 0.56f);
    		case SOUTH:
    			return new AxisAlignedBB(0.87f, 0.88f, 0.44f, 0.12f, 2f/16f, 0.56f);
    		case EAST:
    			return new AxisAlignedBB(0.45f, 0.88f, 0.13f, 0.56f, 2f/16f, 0.87f);
    		case WEST:
    			return new AxisAlignedBB(0.45f, 0.88f, 0.13f, 0.56f, 2f/16f, 0.87f);
			default:
				return new AxisAlignedBB(0, 0, 0, 1, 1, 1);
    	}
    }

}
