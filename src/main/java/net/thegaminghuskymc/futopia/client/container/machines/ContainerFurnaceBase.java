package net.thegaminghuskymc.futopia.client.container.machines;

import net.minecraft.entity.player.EntityPlayer;
import net.thegaminghuskymc.huskylib.client.container.ContainerBase;

public class ContainerFurnaceBase extends ContainerBase {

	public ContainerFurnaceBase() {

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
