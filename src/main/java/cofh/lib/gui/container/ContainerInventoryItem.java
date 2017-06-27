package cofh.lib.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public abstract class ContainerInventoryItem extends ContainerBase {

	protected final InventoryContainerItemWrapper containerWrapper;
	protected final EntityPlayer player;
	protected final int containerIndex;
	protected boolean valid = true;

	public ContainerInventoryItem(ItemStack stack, InventoryPlayer inventory) {

		player = inventory.player;
		containerIndex = inventory.currentItem;
		containerWrapper = new InventoryContainerItemWrapper(stack);
	}

	@Override
	protected int getSizeInventory() {

		return containerWrapper.getSizeInventory();
	}

	public ItemStack getContainerStack() {

		return containerWrapper.getContainerStack();
	}

	public String getInventoryName() {

		return containerWrapper.getName();
	}

	/*@Override
	public void detectAndSendChanges() {

		ItemStack item = player.inventory.mainInventory[containerIndex];
		if (item == null || item.getItem() != containerWrapper.getContainerItem()) {
			valid = false;
			return;
		}
		super.detectAndSendChanges();
	}

	public void onSlotChanged() {

		ItemStack item = player.inventory.mainInventory[containerIndex];
		if (valid && item != null && item.getItem() == containerWrapper.getContainerItem()) {
			player.inventory.mainInventory[containerIndex] = containerWrapper.getContainerStack();
		}
	}*/

	@Override
	public boolean canInteractWith(EntityPlayer player) {

//		onSlotChanged();
		if (containerWrapper.getDirty() && !valid) {
			player.inventory.setItemStack(null);
		}
		return valid;
	}

	@Override
	protected boolean performMerge(int slotIndex, ItemStack stack) {

		int invPlayer = 27;
		int invFull = invPlayer + 9;
		int invTile = invFull + getSizeInventory();

		if (slotIndex < invFull) {
			return mergeItemStack(stack, invFull, invTile, false);
		}
		return mergeItemStack(stack, 0, invFull, true);
	}

	@Override
	public ItemStack slotClick(int slotIndex, int mouseButton, ClickType modifier, EntityPlayer player) {

		if (modifier == ClickType.SWAP && mouseButton == containerIndex) {
			return null;
		}
		ItemStack stack = null;
		InventoryPlayer inventoryPlayer = player.inventory;
		int i1 = 0;
		ItemStack itemstack3;

		if (modifier == ClickType.QUICK_CRAFT) {
			int l = this.windowId;
			this.windowId = getDragEvent(mouseButton);

			if ((l != 1 || this.windowId != 2) && l != this.windowId) {
				this.resetDrag();
			} else if (inventoryPlayer.getItemStack() == null) {
				this.resetDrag();
			} else if (this.windowId == 0) {
				this.windowId = extractDragMode(mouseButton);

				if (isValidDragMode(this.windowId, player)) {
					this.windowId = 1;
					this.inventorySlots.clear();
				} else {
					this.resetDrag();
				}
			} else if (this.windowId == 1) {
				Slot slot = this.inventorySlots.get(slotIndex);

				if (slot != null && canAddItemToSlot(slot, inventoryPlayer.getItemStack(), true) && slot.isItemValid(inventoryPlayer.getItemStack()) && inventoryPlayer.getItemStack().getCount() > this.inventorySlots.size() && this.canDragIntoSlot(slot)) {
					this.inventorySlots.add(slot);
				}
			} else if (this.windowId == 2) {
				if (!this.inventorySlots.isEmpty()) {
					itemstack3 = inventoryPlayer.getItemStack().copy();
					i1 = inventoryPlayer.getItemStack().getCount();

					for (Slot slot1 : this.inventorySlots) {
						if (slot1 != null && canAddItemToSlot(slot1, inventoryPlayer.getItemStack(), true) && slot1.isItemValid(inventoryPlayer.getItemStack()) && inventoryPlayer.getItemStack().getCount() >= this.inventorySlots.size() && this.canDragIntoSlot(slot1)) {
							ItemStack itemstack1 = itemstack3.copy();
							int j1 = slot1.getHasStack() ? slot1.getStack().getCount() : 0;
//							computeStackSize(this.inventorySlots.iterator(), this.windowId, itemstack1, j1);

							if (itemstack1.getMaxStackSize() > itemstack1.getMaxStackSize()) {
								itemstack1.setCount(itemstack1.getMaxStackSize());
							}
							if (itemstack1.getMaxStackSize() > slot1.getSlotStackLimit()) {
								itemstack1.setCount(slot1.getSlotStackLimit());
							}
							i1 -= itemstack1.getCount() - j1;
							slot1.putStack(itemstack1);
						}
					}

					itemstack3.setCount(i1);

					if (itemstack3.getCount() <= 0) {
						itemstack3 = null;
					}
					inventoryPlayer.setItemStack(itemstack3);
				}
				this.resetDrag();
			} else {
				this.resetDrag();
			}
		} else if (this.windowId != 0) {
			this.resetDrag();
		} else {
			Slot slot2;
			int l1;
			ItemStack itemstack5;

			if ((modifier == ClickType.PICKUP || modifier == ClickType.QUICK_MOVE) && (mouseButton == 0 || mouseButton == 1)) {
				if (slotIndex == -999) {
					if (inventoryPlayer.getItemStack() != null && slotIndex == -999) {
						if (mouseButton == 0) {
							player.dropItem(inventoryPlayer.getItemStack(), true);
							inventoryPlayer.setItemStack(null);
						}

						if (mouseButton == 1) {
							player.dropItem(inventoryPlayer.getItemStack().splitStack(1), true);

							if (inventoryPlayer.getItemStack().getCount() == 0) {
								inventoryPlayer.setItemStack(null);
							}
						}
					}
				} else if (modifier == ClickType.QUICK_MOVE) {
					if (slotIndex < 0) {
						return null;
					}
					slot2 = this.inventorySlots.get(slotIndex);

					if (slot2 != null && slot2.canTakeStack(player)) {
						itemstack3 = this.transferStackInSlot(player, slotIndex);

						if (itemstack3 != null) {
							Item item = itemstack3.getItem();
							stack = itemstack3.copy();

							if (slot2.getStack() != null && slot2.getStack().getItem() == item) {
								this.slotClick(slotIndex, mouseButton, ClickType.QUICK_MOVE, player);
							}
						}
					}
				} else {
					if (slotIndex < 0) {
						return null;
					}
					slot2 = this.inventorySlots.get(slotIndex);

					if (slot2 != null) {
						itemstack3 = slot2.getStack();
						ItemStack itemstack4 = inventoryPlayer.getItemStack();

						if (itemstack3 != null) {
							stack = itemstack3.copy();
						}
						if (itemstack3 == null) {
							if (itemstack4 != null && slot2.isItemValid(itemstack4)) {
								l1 = mouseButton == 0 ? itemstack4.getCount() : 1;

								if (l1 > slot2.getSlotStackLimit()) {
									l1 = slot2.getSlotStackLimit();
								}
								if (itemstack4.getCount() >= l1) {
									slot2.putStack(itemstack4.splitStack(l1));
								}
								if (itemstack4.getCount() == 0) {
									inventoryPlayer.setItemStack(null);
								}
							}
						} else if (slot2.canTakeStack(player)) {
							if (itemstack4 == null) {
								l1 = mouseButton == 0 ? itemstack3.getCount() : (itemstack3.getCount() + 1) / 2;
								itemstack5 = slot2.decrStackSize(l1);
								inventoryPlayer.setItemStack(itemstack5);

								if (itemstack3.getCount() == 0) {
									slot2.putStack(null);
								}
								slot2.canTakeStack(player);
							} else if (slot2.isItemValid(itemstack4)) {
								if (itemstack3.getItem() == itemstack4.getItem() && itemstack3.getItemDamage() == itemstack4.getItemDamage() && ItemStack.areItemStackTagsEqual(itemstack3, itemstack4)) {
									l1 = mouseButton == 0 ? itemstack4.getCount() : 1;

									if (l1 > slot2.getSlotStackLimit() - itemstack3.getCount()) {
										l1 = slot2.getSlotStackLimit() - itemstack3.getCount();
									}
									if (l1 > itemstack4.getMaxStackSize() - itemstack3.getCount()) {
										l1 = itemstack4.getMaxStackSize() - itemstack3.getCount();
									}
									itemstack4.splitStack(l1);

									if (itemstack4.getCount() == 0) {
										inventoryPlayer.setItemStack(null);
									}
									itemstack3.setCount(i1);
									slot2.putStack(itemstack3);
								} else if (itemstack4.getCount() <= slot2.getSlotStackLimit()) {
									slot2.putStack(itemstack4);
									inventoryPlayer.setItemStack(itemstack3);
								}
							} else if (itemstack3.getItem() == itemstack4.getItem() && itemstack4.getMaxStackSize() > 1 && (!itemstack3.getHasSubtypes() || itemstack3.getItemDamage() == itemstack4.getItemDamage()) && ItemStack.areItemStackTagsEqual(itemstack3, itemstack4)) {
								l1 = itemstack3.getCount();

								if (l1 > 0 && l1 + itemstack4.getCount() <= itemstack4.getMaxStackSize()) {
									itemstack4.setCount(l1);;
									itemstack3 = slot2.decrStackSize(l1);

									if (itemstack3.getCount() == 0) {
										slot2.putStack(null);
									}
									slot2.canTakeStack(player);
								}
							}
						}
						slot2.onSlotChanged();
					}
				}
			} else if (modifier == ClickType.SWAP && mouseButton >= 0 && mouseButton < 9) {
				slot2 = this.inventorySlots.get(slotIndex);

				if (slot2.canTakeStack(player)) {
					itemstack3 = inventoryPlayer.getStackInSlot(mouseButton);
					boolean flag = itemstack3 == null || slot2.inventory == inventoryPlayer && slot2.isItemValid(itemstack3);
					l1 = -1;

					if (!flag) {
						l1 = inventoryPlayer.getFirstEmptyStack();
						flag |= l1 > -1;
					}
					if (slot2.getHasStack() && flag) {
						itemstack5 = slot2.getStack();
						inventoryPlayer.setInventorySlotContents(mouseButton, itemstack5.copy());

						if ((slot2.inventory != inventoryPlayer || !slot2.isItemValid(itemstack3)) && itemstack3 != null) {
							if (l1 > -1) {
								inventoryPlayer.addItemStackToInventory(itemstack3);
								slot2.decrStackSize(itemstack5.getCount());
								slot2.putStack(null);
								slot2.canTakeStack(player);
							}
						} else {
							slot2.decrStackSize(itemstack5.getCount());
							slot2.putStack(itemstack3);
							slot2.canTakeStack(player);
						}
					} else if (!slot2.getHasStack() && itemstack3 != null && slot2.isItemValid(itemstack3)) {
						inventoryPlayer.setInventorySlotContents(mouseButton, null);
						slot2.putStack(itemstack3);
					}
				}
			} else if (modifier == ClickType.CLONE && player.capabilities.isCreativeMode && inventoryPlayer.getItemStack() == null && slotIndex >= 0) {
				slot2 = this.inventorySlots.get(slotIndex);

				if (slot2 != null && slot2.getHasStack()) {
					itemstack3 = slot2.getStack().copy();
					itemstack3.setCount(itemstack3.getMaxStackSize());
					inventoryPlayer.setItemStack(itemstack3);
				}
			} else if (modifier == ClickType.THROW && inventoryPlayer.getItemStack() == null && slotIndex >= 0) {
				slot2 = this.inventorySlots.get(slotIndex);

				if (slot2 != null && slot2.getHasStack() && slot2.canTakeStack(player)) {
					itemstack3 = slot2.decrStackSize(mouseButton == 0 ? 1 : slot2.getStack().getCount());
					slot2.canTakeStack(player);
					player.dropItem(itemstack3, true);
				}
			} else if (modifier == ClickType.PICKUP_ALL && slotIndex >= 0) {
				slot2 = this.inventorySlots.get(slotIndex);
				itemstack3 = inventoryPlayer.getItemStack();

				if (itemstack3 != null && (slot2 == null || !slot2.getHasStack() || !slot2.canTakeStack(player))) {
					i1 = mouseButton == 0 ? 0 : this.inventorySlots.size() - 1;
					l1 = mouseButton == 0 ? 1 : -1;

					for (int i2 = 0; i2 < 2; ++i2) {
						for (int j2 = i1; j2 >= 0 && j2 < this.inventorySlots.size() && itemstack3.getCount() < itemstack3.getMaxStackSize(); j2 += l1) {
							Slot slot3 = this.inventorySlots.get(j2);

							if (slot3.getHasStack() && canAddItemToSlot(slot3, itemstack3, true) && slot3.canTakeStack(player) && this.canMergeSlot(itemstack3, slot3) && (i2 != 0 || slot3.getStack().getMaxStackSize() != slot3.getStack().getMaxStackSize())) {
								int k1 = Math.min(itemstack3.getMaxStackSize() - itemstack3.getCount(), slot3.getStack().getCount());
								ItemStack itemstack2 = slot3.decrStackSize(k1);
								itemstack3.setCount(k1);;

								if (itemstack2.getCount() <= 0) {
									slot3.putStack(null);
								}
								slot3.canTakeStack(player);
							}
						}
					}
				}
				this.detectAndSendChanges();
			}
		}
		return stack;
	}

}
