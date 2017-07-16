package net.thegaminghuskymc.futopia.tiles;

import cofh.api.tileentity.IRedstoneControl;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileCPU extends TileEntity implements IRedstoneControl {

	private static ControlMode controlMode = ControlMode.DISABLED;

	public TileCPU() {
		super();
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		return super.writeToNBT(compound);
	}

	@Override
	public void setPowered(boolean isPowered) {

	}

	@Override
	public boolean isPowered() {
		return false;
	}

	@Override
	public boolean setControl(ControlMode control) {
		return this.controlMode != null;
	}

	@Override
	public ControlMode getControl() {
		return null;
	}

}
