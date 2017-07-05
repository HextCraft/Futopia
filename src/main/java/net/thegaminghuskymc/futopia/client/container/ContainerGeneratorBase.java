package net.thegaminghuskymc.futopia.client.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.thegaminghuskymc.futopia.tiles.TileEntityGeneratorBase;

public class ContainerGeneratorBase extends Container{
	
	private IItemHandler handler;
	public int euOut;
	public int storedEu;
	public int euChange;
	public int connectedBlocks;
	public double euStorage;
	TileEntityGeneratorBase tile;
	 
    public ContainerGeneratorBase(IInventory player, TileEntityGeneratorBase tile) {
    	this.tile = tile;
    	
    	int xs = 8, ys = 8 + 9;
    	
    	for(int y = 0; y < 3; y++) 
    		for(int x = 0; x < 9; x++)
    	        addSlotToContainer(new Slot(player, x + y * 9 + 9, xs + (x * 18), ys + (y * 18) + 92)); // Player Inventory

    	for(int k = 0; k < 9; k++)
    	    addSlotToContainer(new Slot(player, k, xs + (k * 18), ys + 83 + 67)); // Player Hotbar
    	
//    	addSlotToContainer(new Slot(player, 1, 100, 100));
    	
//    	addSlotToContainer(new SlotDefinition(SlotType.SLOT_SPECIFICITEM, new ItemStack(Items.COAL)));
    }
 
    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
        ItemStack previous = null;
        Slot slot = inventorySlots.get(fromSlot);
 
        if (slot != null && slot.getHasStack()) {
            ItemStack current = slot.getStack();
            previous = current.copy();
 
            if (fromSlot < handler.getSlots()) {
                if (!mergeItemStack(current, handler.getSlots(), handler.getSlots() + 36, true))
                    return null;
            } else {
                if (mergeItemStack(current, 0, handler.getSlots(), false))
                    return null;
            }
 
            if (current.getCount() == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }
 
            if (current.getCount() == previous.getCount())
                return null;
            (slot).onTake(playerIn, current);
        }
 
        return previous;
    }
 
    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }

}
