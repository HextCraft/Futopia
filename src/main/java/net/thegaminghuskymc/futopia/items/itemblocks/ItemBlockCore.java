// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ItemBlockCore.java

package net.thegaminghuskymc.futopia.items.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.futopia.utils.StringHelper;

public class ItemBlockCore extends ItemBlock
{

    public ItemBlockCore(Block block)
    {
        super(block);
        setHasSubtypes(true);
        setMaxDamage(0);
        setNoRepair();
    }

    public String getItemStackDisplayName(ItemStack stack)
    {
        return StringHelper.localize(getUnlocalizedName(stack));
    }

    public int getMetadata(int i)
    {
        return i;
    }

    public boolean isItemTool(ItemStack stack)
    {
        return false;
    }
    
}
