package net.thegaminghuskymc.futopia.tiles;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidTankProperties;

import javax.annotation.Nullable;

/**
 * Created by TheGamingHuskyMC on 01.05.2017.
 */
public class TilePlatePresser extends TileEntityMachineBase implements IFluidHandler {

	private EnumFacing orientation = EnumFacing.NORTH;
	private FluidTank tankLava = new FluidTank(16000);
	private FluidTank tankLiquidGlass = new FluidTank(16000);
	private int[] color = new int[] { 255, 255, 255 };
	private int smeltingProgress = 0;
	private int progress = 0;
	private boolean isActive = true;
	private int[] dyeCounter = new int[] { 0, 0, 0 };

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		this.tankLava.readFromNBT(tag.getCompoundTag("tank_lava"));
		this.tankLiquidGlass.readFromNBT(tag.getCompoundTag("tank_liquid_glass"));
		this.color = tag.getIntArray("color");
		this.smeltingProgress = tag.getInteger("smelting_progress");
		this.progress = tag.getInteger("progress");
		this.isActive = tag.getBoolean("is_active");
		this.dyeCounter = tag.getIntArray("dye_counter");
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setTag("tank_lava", this.tankLava.writeToNBT(new NBTTagCompound()));
		tag.setTag("tank_liquid_glass", this.tankLiquidGlass.writeToNBT(new NBTTagCompound()));
		tag.setIntArray("color", this.color);
		tag.setInteger("smelting_progress", this.smeltingProgress);
		tag.setInteger("progress", this.progress);
		tag.setBoolean("is_active", this.isActive);
		tag.setIntArray("dye_counter", this.dyeCounter);
		return tag;
	}

	public int[] getColor() {
		return this.color;
	}

	public void setColor(int[] color) {
		this.color = color;
	}

	@Override
	public IFluidTankProperties[] getTankProperties() {
		return this.tankLava.getTankProperties();
	}

	@Override
	public int fill(FluidStack resource, boolean doFill) {
		return this.tankLava.fill(resource, doFill);
	}

	@Nullable
	@Override
	public FluidStack drain(FluidStack resource, boolean doDrain) {
		return this.tankLava.drain(resource, doDrain);
	}

	@Nullable
	@Override
	public FluidStack drain(int maxDrain, boolean doDrain) {
		return this.tankLava.drain(maxDrain, doDrain);
	}

	public FluidTank getTankLava() {
		return this.tankLava;
	}

	public FluidTank getTankLiquidGlass() {
		return this.tankLiquidGlass;
	}

	public EnumFacing getOrientation() {
		return this.orientation;
	}

	public void setOrientation(EnumFacing orientation) {
		this.orientation = orientation;
	}

	public int getSmeltingProgress() {
		return this.smeltingProgress;
	}

	public int getProgress() {
		return this.progress;
	}

	public boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

}
