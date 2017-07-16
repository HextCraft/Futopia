package net.thegaminghuskymc.futopia.client.container.computers;

import net.minecraft.entity.player.EntityPlayer;
import net.thegaminghuskymc.huskylib.client.container.ContainerBase;

public class ContainerController extends ContainerBase {

	public ContainerController() {

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
