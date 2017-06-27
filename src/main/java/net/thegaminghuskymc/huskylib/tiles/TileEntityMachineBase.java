package net.thegaminghuskymc.huskylib.tiles;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMachineBase extends TileEntity {
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		return compound;
	}
	
	@Override
	public boolean canRenderBreaking() {
		return true;
	}

}
