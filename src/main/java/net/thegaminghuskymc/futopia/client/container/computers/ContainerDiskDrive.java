package net.thegaminghuskymc.futopia.client.container.computers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.thegaminghuskymc.huskylib.client.container.ContainerBase;

public class ContainerDiskDrive extends ContainerBase {

	public ContainerDiskDrive(InventoryPlayer playerInventory) {

		/*
		 * for (int i = 0; i < 3; ++i) { for (int j = 0; j < 2; ++j) {
		 * addSlotToContainer(new SlotItemHandler(inventory, j + i * 3, 30 + j *
		 * 18, 17 + i * 18) {
		 * 
		 * @Override public void onSlotChanged() { diskDrive.markDirty(); } });
		 * } }
		 */

		for (int k = 0; k < 3; ++k) {
			for (int i1 = 0; i1 < 9; ++i1) {
				this.addSlotToContainer(new Slot(playerInventory, i1 + k * 9 + 9, 8 + i1 * 18, 84 + k * 18));
			}
		}

		for (int l = 0; l < 9; ++l) {
			this.addSlotToContainer(new Slot(playerInventory, l, 8 + l * 18, 142));
		}

	}

	@Override
	public int getSizeInventory() {
		return 0;
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return false;
	}

}