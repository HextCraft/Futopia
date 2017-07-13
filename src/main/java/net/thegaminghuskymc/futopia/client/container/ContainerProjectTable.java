package net.thegaminghuskymc.futopia.client.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.thegaminghuskymc.futopia.client.container.slot.SlotCraftingCustom;
import net.thegaminghuskymc.huskylib.client.container.ContainerBase;

public class ContainerProjectTable extends ContainerBase{
	
	/** The crafting matrix inventory (3x3). */
    public InventoryCraftingFutopia craftMatrix = new InventoryCraftingFutopia(this, 3, 3);
    public InventoryCraftResultFutopia craftResult = new InventoryCraftResultFutopia();
    private IItemHandler handler;

    public ContainerProjectTable(InventoryPlayer playerInventory){
    	
    	this.addSlotToContainer(new SlotCraftingCustom(playerInventory.player, this.craftMatrix, this.craftResult, 0, 124, 35));

//        this.addSlotToContainer(new SlotRemoveOnly(playerInventory, 0, 124, 35));
        
    	for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 3; ++j)
            {
                this.addSlotToContainer(new Slot(this.craftMatrix, j + i * 3, 30 + j * 18, 17 + i * 18));
            }
        }

        for (int k = 0; k < 3; ++k)
        {
            for (int i1 = 0; i1 < 9; ++i1)
            {
                this.addSlotToContainer(new Slot(playerInventory, i1 + k * 9 + 9, 8 + i1 * 18, 84 + k * 18));
            }
        }

        for (int l = 0; l < 9; ++l)
        {
            this.addSlotToContainer(new Slot(playerInventory, l, 8 + l * 18, 142));
        }
        
//        this.addSlotToContainer(new SlotPlayerAugment(playerInventory.player, 1, 140, 35));
    	
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
	public int getSizeInventory() {
		return this.getSizeInventory();
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return true;
	}

}
