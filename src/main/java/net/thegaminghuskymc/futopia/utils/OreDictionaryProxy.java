// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   OreDictionaryProxy.java

package net.thegaminghuskymc.futopia.utils;

import com.google.common.base.Strings;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryProxy
{

    public OreDictionaryProxy()
    {
    }

    public ItemStack getOre(String oreName)
    {
        if(!oreNameExists(oreName))
            return null;
        else
            return ItemHelper.cloneStack((ItemStack)OreDictionary.getOres(oreName).get(0), 1);
    }

    public int getOreID(ItemStack stack)
    {
        return getOreID(getOreName(stack));
    }

    public int getOreID(String oreName)
    {
        if(Strings.isNullOrEmpty(oreName))
            return -1;
        else
            return OreDictionary.getOreID(oreName);
    }

    public String getOreName(ItemStack stack)
    {
        int ids[] = OreDictionary.getOreIDs(stack);
        if(ids != null && ids.length >= 1)
            return OreDictionary.getOreName(ids[0]);
        else
            return "";
    }

    public String getOreName(int oreID)
    {
        return OreDictionary.getOreName(oreID);
    }

    public boolean isOreIDEqual(ItemStack stack, int oreID)
    {
        return getOreID(stack) == oreID;
    }

    public boolean isOreNameEqual(ItemStack stack, String oreName)
    {
        return OreDictionary.getOreName(getOreID(stack)).equals(oreName);
    }

    public boolean oreNameExists(String oreName)
    {
        return OreDictionary.doesOreNameExist(oreName);
    }
}
