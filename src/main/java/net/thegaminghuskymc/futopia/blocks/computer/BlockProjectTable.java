package net.thegaminghuskymc.futopia.blocks.computer;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.client.gui.GuiHandler;
import net.thegaminghuskymc.futopia.utils.BlockNames;
import net.thegaminghuskymc.futopia.utils.StringHelper;

import javax.annotation.Nonnull;
import java.util.List;

public class BlockProjectTable extends BlockComputerBase {

	public BlockProjectTable() {
		super(BlockNames.PROJECT_TABLENAME);
	}

	@Override
	public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) {
		if (!StringHelper.isShiftKeyDown()) {
			tooltip.add("Hold " + StringHelper.getDeactivationText("Shift")
					+ StringHelper.getFlavorText(" for information."));
		} else {
			tooltip.add(StringHelper.getInfoText("This block is used to craft special blocks"));
		}
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		if (worldIn.isRemote & !playerIn.isSneaking()) {
			playerIn.openGui(Futopia.INSTANCE, GuiHandler.PROJECT_TABLE, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}

		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}
	
	private static ImmutableList<AxisAlignedBB> BOUNDS = ImmutableList.of(
		      new AxisAlignedBB(0, 0.75, 0, 1, 1, 1),
		      new AxisAlignedBB(0, 0, 0, 0.25, 0.75, 0.25),
		      new AxisAlignedBB(0.75, 0, 0, 1, 0.75, 0.25),
		      new AxisAlignedBB(0.75, 0, 0.75, 1, 0.75, 1),
		      new AxisAlignedBB(0, 0, 0.75, 0.25, 0.75, 1)
	);

	@Override
	  public RayTraceResult collisionRayTrace(IBlockState blockState, @Nonnull World worldIn, @Nonnull BlockPos pos, @Nonnull Vec3d start, @Nonnull Vec3d end) {
	    // basically the same BlockStairs does
	    // Raytrace through all AABBs (plate, legs) and return the nearest one
	    return raytraceMultiAABB(BOUNDS, pos, start, end);
	  }

	  public static RayTraceResult raytraceMultiAABB(List<AxisAlignedBB> aabbs, BlockPos pos, Vec3d start, Vec3d end) {
	    List<RayTraceResult> list = Lists.newArrayList();

	    for(AxisAlignedBB axisalignedbb : aabbs) {
	      list.add(rayTrace2(pos, start, end, axisalignedbb));
	    }

	    RayTraceResult raytraceresult1 = null;
	    double d1 = 0.0D;

	    for(RayTraceResult raytraceresult : list) {
	      if(raytraceresult != null) {
	        double d0 = raytraceresult.hitVec.squareDistanceTo(end);

	        if(d0 > d1) {
	          raytraceresult1 = raytraceresult;
	          d1 = d0;
	        }
	      }
	    }

	    return raytraceresult1;
	  }

	  // Block.raytrace
	  private static RayTraceResult rayTrace2(BlockPos pos, Vec3d start, Vec3d end, AxisAlignedBB boundingBox) {
	    Vec3d vec3d = start.subtract((double) pos.getX(), (double) pos.getY(), (double) pos.getZ());
	    Vec3d vec3d1 = end.subtract((double) pos.getX(), (double) pos.getY(), (double) pos.getZ());
	    RayTraceResult raytraceresult = boundingBox.calculateIntercept(vec3d, vec3d1);
	    return raytraceresult == null ? null : new RayTraceResult(raytraceresult.hitVec.addVector((double) pos.getX(), (double) pos.getY(), (double) pos.getZ()), raytraceresult.sideHit, pos);
	  }

}
