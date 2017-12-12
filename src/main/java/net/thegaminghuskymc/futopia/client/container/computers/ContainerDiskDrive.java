package net.thegaminghuskymc.futopia.client.container.computers;

import codechicken.lib.inventory.container.ContainerExtended;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;

public class ContainerDiskDrive extends ContainerExtended {

	public ContainerDiskDrive(InventoryPlayer playerInventory) {
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
	public boolean canInteractWith(EntityPlayer playerIn) {
		return false;
	}

}