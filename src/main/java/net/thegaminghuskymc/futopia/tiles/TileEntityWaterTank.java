package net.thegaminghuskymc.futopia.tiles;

import codechicken.lib.fluid.ExtendedFluidTank;
import codechicken.lib.fluid.FluidUtils;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidTank;
import net.thegaminghuskymc.huskylib.tiles.TileEntityBase;

import javax.annotation.Nullable;

public class TileEntityWaterTank extends TileEntityBase implements IFluidTank {

    private static FluidStack stack = new FluidStack(FluidUtils.water, Fluid.BUCKET_VOLUME);

    protected static ExtendedFluidTank tank = new ExtendedFluidTank(stack, 10000000);

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        return super.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
    }

    @Override
    public int getCapacity() {
        return tank.getCapacity();
    }

    @Nullable
    @Override
    public FluidStack getFluid() {
        return tank.getFluid();
    }

    @Override
    public FluidTankInfo getInfo() {
        return tank.getInfo();
    }

    @Override
    public int getFluidAmount() {
        return tank.getFluidAmount();
    }

    @Nullable
    @Override
    public FluidStack drain(int maxDrain, boolean doDrain) {
        return tank.drain(100, true);
    }

    @Override
    public int fill(FluidStack resource, boolean doFill) {
        return tank.fill(resource, true);
    }

}
