package net.thegaminghuskymc.futopia.tiles;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidTankProperties;

public class TileTank extends TileEntityBase implements IFluidHandler, ITickable {

    public FluidTank tank = new FluidTank(1000);
    private int prevAmount = tank.getFluidAmount();


    public boolean containsFluid() {
        return tank.getFluid() != null;
    }

    public int getBrightness() {
        if(containsFluid()) {
            return tank.getFluid().getFluid().getLuminosity();
        }
        return 0;
    }

    @SuppressWarnings("unused")
	private void save() {
        markDirty();
        if (Math.abs(prevAmount - tank.getFluidAmount()) >= 1000) {
            prevAmount = tank.getFluidAmount();
            if (!world.isRemote) {
                update();
            }
        }
    }

    @SuppressWarnings("unused")
	@Override
    public void update() {
        if (tank.getFluid() != null && tank.getFluidAmount() > 0) {
            TileEntity te = world.getTileEntity(pos.down());
            if (te != null && te instanceof IFluidHandler) {
                IFluidHandler fluidHandler = (IFluidHandler) te;
                /*if (fluidHandler.fill(FluidStack.loadFluidStackFromNBT(new NBTTagCompound()), tank.canFill())) {
                    drain(EnumFacing.DOWN, fluidHandler.fill(EnumFacing.UP, drain(EnumFacing.DOWN, tank.getCapacity(), false), true), true);
                }*/
            }
        }
    }

	@Override
	public IFluidTankProperties[] getTankProperties() {
		return tank.getTankProperties();
	}

	@Override
	public int fill(FluidStack resource, boolean doFill) {
		return 0;
	}

	@Override
	public FluidStack drain(FluidStack resource, boolean doDrain) {
		return null;
	}

	@Override
	public FluidStack drain(int maxDrain, boolean doDrain) {
		return null;
	}

}
