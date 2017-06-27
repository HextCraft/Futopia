package cofh.lib.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class InventoryContainerItemWrapper implements IInventory {

	protected final IInventory inventoryItem;
	protected final ItemStack stack;
	protected NBTTagCompound tag;
	protected ItemStack[] inventory;
	protected boolean dirty = false;

	@Deprecated
	public InventoryContainerItemWrapper(ContainerInventoryItem gui, ItemStack stack) {

		this(stack);
	}

	public InventoryContainerItemWrapper(ItemStack itemstack) {

		stack = itemstack;
		inventoryItem = (IInventory) stack.getItem();
		inventory = new ItemStack[getSizeInventory()];

		loadInventory();
		markDirty();
	}

	protected void loadInventory() {

		boolean loaded = false;
		if (!stack.hasTagCompound() || !stack.getTagCompound().hasKey("Inventory")) {
			loaded = stack.hasTagCompound();
			if (loaded) {
				if (stack.getTagCompound().hasKey("inventory")) {
					tag = stack.getTagCompound().getCompoundTag("inventory");
					stack.getTagCompound().removeTag("inventory");
				} else {
					tag = stack.getTagCompound();
				}
				loadStacks();
				tag = new NBTTagCompound();
				saveStacks();
			} else {
				stack.setTagInfo("Inventory", new NBTTagCompound());
			}
		}
		tag = stack.getTagCompound().getCompoundTag("Inventory");
		loadStacks();
	}

	protected void loadStacks() {

		/*for (int i = inventory.length; i-- > 0; ) {
			if (tag.hasKey("Slot" + i)) {
				inventory[i] = ItemStack.loadItemStackFromNBT(tag.getCompoundTag("Slot" + i));
			} else if (tag.hasKey("slot" + i)) {
				inventory[i] = ItemStack.loadItemStackFromNBT(tag.getCompoundTag("slot" + i));
			} else {
				inventory[i] = null;
			}
		}*/
	}

	protected void saveStacks() {

		for (int i = inventory.length; i-- > 0; ) {
			if (inventory[i] == null) {
				tag.removeTag("Slot" + i);
			} else {
				tag.setTag("Slot" + i, inventory[i].writeToNBT(new NBTTagCompound()));
			}
		}
		stack.setTagInfo("Inventory", tag);
	}

	@Override
	public void markDirty() {

		saveStacks();
		dirty = true;
	}

	public boolean getDirty() {

		boolean r = dirty;
		dirty = false;
		return r;
	}

	public Item getContainerItem() {

		return stack.getItem();
	}

	public ItemStack getContainerStack() {

		saveStacks();
		return stack;
	}

	/*@Override
	public int getSizeInventory() {

		return inventoryItem.getStackInSlot(stack);
	}*/

	@Override
	public ItemStack getStackInSlot(int i) {

		return inventory[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {

		ItemStack s = inventory[i];
		if (s == null) {
			return null;
		}
		ItemStack r = s.splitStack(j);
		if (s.getMaxStackSize() <= 0) {
			inventory[i] = null;
			r.setCount(s.getMaxStackSize());
		}
		return r;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {

		inventory[i] = itemstack;
	}

	@Override
	public ItemStack removeStackFromSlot(int slot) {

		return null;
	}

	/*@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) {

		if (stack != null && stack.getItem() instanceof IInventory) {
			return ((IInventory) stack.getItem()).getInventoryItems(stack).equals(0);
		}
		return true;
	}*/

	@Override
	public int getField(int id) {

		return 0;
	}

	@Override
	public void setField(int id, int value) {

	}

	@Override
	public int getFieldCount() {

		return 0;
	}

	@Override
	public void clear() {

	}

	@Override
	public String getName() {

		return stack.getDisplayName();
	}

	@Override
	public boolean hasCustomName() {

		return true;
	}

	@Override
	public ITextComponent getDisplayName() {

		return new TextComponentString(stack.getDisplayName());
	}

	@Override
	public int getInventoryStackLimit() {

		return 64;
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {

		return true;
	}

	@Override
	public void openInventory(EntityPlayer player) {

	}

	@Override
	public void closeInventory(EntityPlayer player) {

		markDirty();
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public int getSizeInventory() {
		return 0;
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return false;
	}

}
