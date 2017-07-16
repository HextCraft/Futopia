package net.thegaminghuskymc.futopia.tiles;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.text.ITextComponent;

public class TileKinectGenerator extends TileBase implements ISidedInventory {

	private final ItemStack[] allInventories = new ItemStack[1];
	public int windspeed = 10;
	public int windtick = 0;

	// @Override
	// public void updateEntity() {
	//
	// if (windspeed < 0){
	// windtick +=windspeed;
	// }
	// }

	public TileKinectGenerator() {

	}

	/**
	 * This function gets called whenever the world/chunk loads
	 */
	@SuppressWarnings("unused")
	@Override
	public void readFromNBT(NBTTagCompound tCompound) {

		super.readFromNBT(tCompound);

		for (int i = 0; i < 1; i++) {
			NBTTagCompound tc = tCompound.getCompoundTag("inventory" + i);
			// allInventories[i] = ItemStack.loadItemStackFromNBT(tc);
		}
	}

	/**
	 * This function gets called whenever the world/chunk is saved
	 *
	 * @return
	 */
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tCompound) {

		super.writeToNBT(tCompound);

		for (int i = 0; i < 1; i++) {
			if (allInventories[i] != null) {
				NBTTagCompound tc = new NBTTagCompound();
				allInventories[i].writeToNBT(tc);
				tCompound.setTag("inventory" + i, tc);
			}
		}

		return tCompound;
	}

	@Override
	public int getSizeInventory() {

		return allInventories.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {

		return this.allInventories[i];
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {

		// this needs to be side aware as well
		ItemStack itemStack = getStackInSlot(slot);
		if (itemStack != null) {
			if (itemStack.getCount() <= amount) {
				setInventorySlotContents(slot, null);
			} else {
				itemStack = itemStack.splitStack(amount);
				if (itemStack.getCount() == 0) {
					setInventorySlotContents(slot, null);
				}
			}
		}

		return itemStack;
	}

	@Override
	public String getName() {

		return "tile.kinect.name";
	}

	@Override
	public boolean hasCustomName() {

		return true;
	}

	@Override
	public int getInventoryStackLimit() {

		return 64;
	}

	@Override
	public void openInventory(EntityPlayer player) {

	}

	@Override
	public void closeInventory(EntityPlayer player) {

	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemStack) {

		return true;
	}

	@Override
	public List<ItemStack> getDrops() {

		List<ItemStack> drops = super.getDrops();
		for (ItemStack stack : allInventories)
			if (stack != null)
				drops.add(stack);
		return drops;
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {

		return false;
	}

	@Override
	public boolean canExtractItem(int index, ItemStack itemStackIn, EnumFacing direction) {

		return false;
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void markDirty() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getField(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public ITextComponent getDisplayName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {
		// TODO Auto-generated method stub
		return true;
	}
}
