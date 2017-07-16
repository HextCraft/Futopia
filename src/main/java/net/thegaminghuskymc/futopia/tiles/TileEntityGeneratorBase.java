package net.thegaminghuskymc.futopia.tiles;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityGeneratorBase extends TileEntityMachineBase implements ITickable, ICapabilityProvider {

	private ItemStackHandler handler;
	private int totalBurnTime;
	private int burnTime;
	private boolean isBurning;

	byte facing = 1;

	public TileEntityGeneratorBase() {
		handler = new ItemStackHandler(1);
	}

	@Override
	public void update() {
		if (world != null) {
			if (!TileEntityFurnace.isItemFuel(handler.getStackInSlot(0))) {
				return;
			}

			if (isBurning) {

				if (handler.getStackInSlot(0).getItem() != null) {
					isBurning = false;
				}

				if (burnTime < 0) {
					handler.setStackInSlot(0, new ItemStack(handler.getStackInSlot(0).getItem(),
							handler.getStackInSlot(0).getCount() - 1));
					isBurning = false;
					return;
				}

				burnTime--;
				return;

			}

			else if (!isBurning) {
				totalBurnTime = burnTime = TileEntityFurnace.getItemBurnTime(handler.getStackInSlot(0));
				isBurning = true;
			}
		}
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			return true;
		return super.hasCapability(capability, facing);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setTag("ItemStackHandler", handler.serializeNBT());
		compound.setInteger("BurnTime", burnTime);
		return super.writeToNBT(compound);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		handler.deserializeNBT(compound.getCompoundTag("ItemStackHandler"));
		burnTime = compound.getInteger("BurnTime");
		super.readFromNBT(compound);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			return (T) handler;
		return super.getCapability(capability, facing);
	}

	public boolean isBurning() {
		return isBurning;
	}

	public int getTotalBurnTime() {
		return totalBurnTime;
	}

	public int getBurnTime() {
		return burnTime;
	}

}
