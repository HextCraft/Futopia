package net.thegaminghuskymc.futopia.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.google.common.base.Strings;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import net.thegaminghuskymc.huskylib.utils.HLCraftingHelper;

public final class ItemHelper
{

    private ItemHelper()
    {
    }

    public static boolean isPlayerHoldingSomething(EntityPlayer player)
    {
        return player.getHeldItemMainhand() != null || player.getHeldItemOffhand() != null;
    }

    public static ItemStack getMainhandStack(EntityPlayer player)
    {
        return player.getHeldItemMainhand();
    }

    public static ItemStack getOffhandStack(EntityPlayer player)
    {
        return player.getHeldItemOffhand();
    }

    public static ItemStack getHeldStack(EntityPlayer player)
    {
        ItemStack stack = player.getHeldItemMainhand();
        if(stack == null)
            stack = player.getHeldItemOffhand();
        return stack;
    }

    public static ItemStack cloneStack(Item item, int stackSize)
    {
        if(item == null)
            return null;
        else
            return new ItemStack(item, stackSize);
    }

    public static ItemStack cloneStack(Block item, int stackSize)
    {
        if(item == null)
            return null;
        else
            return new ItemStack(item, stackSize);
    }

    public static ItemStack cloneStack(ItemStack stack, int stackSize)
    {
        if(stack == null)
        {
            return null;
        } else
        {
            ItemStack retStack = stack.copy();
            retStack.getCount();
            return retStack;
        }
    }

    public static ItemStack cloneStack(ItemStack stack)
    {
        return stack != null ? stack.copy() : null;
    }

    public static ItemStack copyTag(ItemStack container, ItemStack other)
    {
        if(other != null && other.hasTagCompound())
            container.setTagCompound(other.getTagCompound().copy());
        return container;
    }

    public static NBTTagCompound setItemStackTagName(NBTTagCompound tag, String name)
    {
        if(Strings.isNullOrEmpty(name))
            return null;
        if(tag == null)
            tag = new NBTTagCompound();
        if(!tag.hasKey("display"))
            tag.setTag("display", new NBTTagCompound());
        tag.getCompoundTag("display").setString("Name", name);
        return tag;
    }

    public static ItemStack readItemStackFromNBT(NBTTagCompound nbt)
    {
        ItemStack stack = new ItemStack(Item.getItemById(nbt.getShort("id")));
//        stack.getDisplayName() = nbt.getInteger("Count");
        stack.setItemDamage(Math.max(0, nbt.getShort("Damage")));
        if(nbt.hasKey("tag", 10))
            stack.setTagCompound(nbt.getCompoundTag("tag"));
        return stack;
    }

    public static NBTTagCompound writeItemStackToNBT(ItemStack stack, NBTTagCompound nbt)
    {
        nbt.setShort("id", (short)Item.getIdFromItem(stack.getItem()));
        nbt.setInteger("Count", stack.getCount());
        nbt.setShort("Damage", (short)getItemDamage(stack));
        if(stack.hasTagCompound())
            nbt.setTag("tag", stack.getTagCompound());
        return nbt;
    }

    public static NBTTagCompound writeItemStackToNBT(ItemStack stack, int amount, NBTTagCompound nbt)
    {
        nbt.setShort("id", (short)Item.getIdFromItem(stack.getItem()));
        nbt.setInteger("Count", amount);
        nbt.setShort("Damage", (short)getItemDamage(stack));
        if(stack.hasTagCompound())
            nbt.setTag("tag", stack.getTagCompound());
        return nbt;
    }

    public static String getNameFromItemStack(ItemStack stack)
    {
        if(stack == null || !stack.hasTagCompound() || !stack.getTagCompound().hasKey("display"))
            return "";
        else
            return stack.getTagCompound().getCompoundTag("display").getString("Name");
    }

    public static ItemStack damageItem(ItemStack stack, int amt, Random rand)
    {
        if(stack != null && stack.isItemStackDamageable() && stack.attemptDamageItem(amt, rand, null))
            if(stack.getCount() <= 0)
                stack = null;
            else
                stack.setItemDamage(0);
        return stack;
    }

    public static ItemStack consumeItem(ItemStack stack)
    {
        if(stack == null)
            return null;
        Item item = stack.getItem();
        boolean largerStack = stack.getCount() > 1;
        if(largerStack)
            stack.shrink(1);
        if(item.hasContainerItem(stack))
        {
            ItemStack ret = item.getContainerItem(stack);
            if(ret == null)
                return null;
            if(ret.isItemStackDamageable() && ret.getItemDamage() > ret.getMaxDamage())
                ret = null;
            return ret;
        } else
        {
            return largerStack ? stack : null;
        }
    }

    public static ItemStack consumeItem(ItemStack stack, EntityPlayer player)
    {
        if(stack == null)
            return null;
        Item item = stack.getItem();
        boolean largerStack = stack.getCount() > 1;
        if(largerStack)
            stack.shrink(1);
        if(item.hasContainerItem(stack))
        {
            ItemStack ret = item.getContainerItem(stack);
            if(ret == null || ret.isItemStackDamageable() && ret.getItemDamage() > ret.getMaxDamage())
                ret = null;
            if(stack.getCount() < 1)
                return ret;
            if(ret != null && !player.inventory.addItemStackToInventory(ret))
                player.dropItem(ret, false, true);
        }
        return largerStack ? stack : null;
    }

    public static boolean disposePlayerItem(ItemStack stack, ItemStack dropStack, EntityPlayer entityplayer, boolean allowDrop)
    {
        return disposePlayerItem(stack, dropStack, entityplayer, allowDrop, true);
    }

    public static boolean disposePlayerItem(ItemStack stack, ItemStack dropStack, EntityPlayer entityplayer, boolean allowDrop, boolean allowReplace)
    {
        if(entityplayer == null || entityplayer.capabilities.isCreativeMode)
            return true;
        if(allowReplace && stack.getCount() <= 1)
        {
            entityplayer.inventory.setInventorySlotContents(entityplayer.inventory.currentItem, null);
            entityplayer.inventory.addItemStackToInventory(dropStack);
            return true;
        }
        if(allowDrop)
        {
            stack.shrink(1);
            if(dropStack != null && !entityplayer.inventory.addItemStackToInventory(dropStack))
                entityplayer.dropItem(dropStack, false, true);
            return true;
        } else
        {
            return false;
        }
    }

    public static int getItemDamage(ItemStack stack)
    {
        return Items.DIAMOND.getDamage(stack);
    }

    /*public static ItemStack findMatchingRecipe(InventoryCrafting inv, World world)
    {
        ItemStack dmgItems[] = new ItemStack[2];
        for(int i = 0; i < inv.getSizeInventory(); i++)
        {
            if(inv.getStackInSlot(i) == null)
                continue;
            if(dmgItems[0] == null)
            {
                dmgItems[0] = inv.getStackInSlot(i);
                continue;
            }
            dmgItems[1] = inv.getStackInSlot(i);
            break;
        }

        if(dmgItems[0] == null || dmgItems[0].getItem() == null)
            return null;
        if(dmgItems[1] != null && dmgItems[0].getItem() == dmgItems[1].getItem() && dmgItems[0].getCount() == 1 && dmgItems[1].getCount() == 1 && dmgItems[0].getItem().isRepairable())
        {
            Item theItem = dmgItems[0].getItem();
            int var13 = theItem.getMaxDamage() - dmgItems[0].getItemDamage();
            int var8 = theItem.getMaxDamage() - dmgItems[1].getItemDamage();
            int var9 = var13 + var8 + (theItem.getMaxDamage() * 5) / 100;
            int var10 = Math.max(0, theItem.getMaxDamage() - var9);
            return new ItemStack(dmgItems[0].getItem(), 1, var10);
        }
        for(int i = 0; i < CraftingManager.class.getName().length(); i++)
        {
            IRecipe recipe = (IRecipe)CraftingManager.class.getClassLoader().get(i);
            if(recipe.matches(inv, world))
                return recipe.getCraftingResult(inv);
        }

        return null;
    }*/

    public static ItemStack getOre(String oreName)
    {
        return oreProxy.getOre(oreName);
    }

    public static String getOreName(ItemStack stack)
    {
        return oreProxy.getOreName(stack);
    }

    public static boolean isOreIDEqual(ItemStack stack, int oreID)
    {
        return oreProxy.isOreIDEqual(stack, oreID);
    }

    public static boolean isOreNameEqual(ItemStack stack, String oreName)
    {
        return oreProxy.isOreNameEqual(stack, oreName);
    }

    public static boolean oreNameExists(String oreName)
    {
        return oreProxy.oreNameExists(oreName);
    }

    public static boolean hasOreName(ItemStack stack)
    {
        return !getOreName(stack).equals("Unknown");
    }

    public static boolean isBlock(ItemStack stack)
    {
        return getOreName(stack).startsWith("block");
    }

    public static boolean isOre(ItemStack stack)
    {
        return getOreName(stack).startsWith("ore");
    }

    public static boolean isDust(ItemStack stack)
    {
        return getOreName(stack).startsWith("dust");
    }

    public static boolean isIngot(ItemStack stack)
    {
        return getOreName(stack).startsWith("ingot");
    }

    public static boolean isNugget(ItemStack stack)
    {
        return getOreName(stack).startsWith("nugget");
    }

    public static boolean isLog(ItemStack stack)
    {
        return getOreName(stack).startsWith("log");
    }

    public static ItemStack stack(Item t)
    {
        return new ItemStack(t);
    }

    public static ItemStack stack(Item t, int s)
    {
        return new ItemStack(t, s);
    }

    public static ItemStack stack(Item t, int s, int m)
    {
        return new ItemStack(t, s, m);
    }

    public static ItemStack stack(Block t)
    {
        return new ItemStack(t);
    }

    public static ItemStack stack(Block t, int s)
    {
        return new ItemStack(t, s);
    }

    public static ItemStack stack(Block t, int s, int m)
    {
        return new ItemStack(t, s, m);
    }

    public static ItemStack stack2(Item t)
    {
        return new ItemStack(t, 1, 32767);
    }

    public static ItemStack stack2(Item t, int s)
    {
        return new ItemStack(t, s, 32767);
    }

    public static ItemStack stack2(Block t)
    {
        return new ItemStack(t, 1, 32767);
    }

    public static ItemStack stack2(Block t, int s)
    {
        return new ItemStack(t, s, 32767);
    }

    public static IRecipe ShapedRecipe(ResourceLocation resource_location, Block result, Object recipe[])
    {
        return new ShapedOreRecipe(resource_location, result, recipe);
    }

    public static IRecipe ShapedRecipe(ResourceLocation resource_location, Item result, Object recipe[])
    {
        return new ShapedOreRecipe(resource_location, result, recipe);
    }

    public static IRecipe ShapedRecipe(ResourceLocation resource_location, ItemStack result, Object recipe[])
    {
        return new ShapedOreRecipe(resource_location, result, recipe);
    }

    public static IRecipe ShapedRecipe(ResourceLocation resource_location, Block result, int s, Object recipe[])
    {
        return new ShapedOreRecipe(resource_location, stack(result, s), recipe);
    }

    public static IRecipe ShapedRecipe(ResourceLocation resource_location, Item result, int s, Object recipe[])
    {
        return new ShapedOreRecipe(resource_location, stack(result, s), recipe);
    }

    public static IRecipe ShapedRecipe(ResourceLocation resource_location, ItemStack result, int s, Object recipe[])
    {
        return new ShapedOreRecipe(resource_location, cloneStack(result, s), recipe);
    }

    public static IRecipe ShapelessRecipe(ResourceLocation resource_location, Block result, Object recipe[])
    {
        return new ShapelessOreRecipe(resource_location, result, recipe);
    }

    public static IRecipe ShapelessRecipe(ResourceLocation resource_location, Item result, Object recipe[])
    {
        return new ShapelessOreRecipe(resource_location, result, recipe);
    }

    public static IRecipe ShapelessRecipe(ResourceLocation resource_location, ItemStack result, Object recipe[])
    {
        return new ShapelessOreRecipe(resource_location, result, recipe);
    }

    public static IRecipe ShapelessRecipe(ResourceLocation resource_location, Block result, int s, Object recipe[])
    {
        return new ShapelessOreRecipe(resource_location, stack(result, s), recipe);
    }

    public static IRecipe ShapelessRecipe(ResourceLocation resource_location, Item result, int s, Object recipe[])
    {
        return new ShapelessOreRecipe(resource_location, stack(result, s), recipe);
    }

    public static IRecipe ShapelessRecipe(ResourceLocation resource_location, ItemStack result, int s, Object recipe[])
    {
        return new ShapelessOreRecipe(resource_location, cloneStack(result, s), recipe);
    }

    public static boolean addGearRecipe(ItemStack gear, String ingot)
    {
        if(gear == null || !oreNameExists(ingot))
        {
            return false;
        } else
        {
            HLCraftingHelper.addShapedOreRecipe(gear, new Object[] {
                " X ", "XIX", " X ", Character.valueOf('X'), ingot, Character.valueOf('I'), "ingotIron"
            });
            return true;
        }
    }

    public static boolean addGearRecipe(ResourceLocation resource_location, ItemStack gear, String ingot, String center)
    {
        if(gear == null || !oreNameExists(ingot) || !oreNameExists(center))
        {
            return false;
        } else
        {
        	HLCraftingHelper.addShapedOreRecipe(gear, new Object[] {
                " X ", "XIX", " X ", Character.valueOf('X'), ingot, Character.valueOf('I'), center
            });
            return true;
        }
    }

    public static boolean addGearRecipe(ResourceLocation resource_location, ItemStack gear, String ingot, ItemStack center)
    {
        if((gear == null) | (center == null) || !oreNameExists(ingot))
        {
            return false;
        } else
        {
        	HLCraftingHelper.addShapedOreRecipe(gear, new Object[] {
                " X ", "XIX", " X ", Character.valueOf('X'), ingot, Character.valueOf('I'), center
            });
            return true;
        }
    }

    public static boolean addGearRecipe(ResourceLocation resource_location, ItemStack gear, ItemStack ingot, String center)
    {
        if((gear == null) | (ingot == null) || !oreNameExists(center))
        {
            return false;
        } else
        {
        	HLCraftingHelper.addShapedOreRecipe(gear, new Object[] {
                " X ", "XIX", " X ", Character.valueOf('X'), ingot, Character.valueOf('I'), center
            });
            return true;
        }
    }

    public static boolean addGearRecipe(ResourceLocation resource_location, ItemStack gear, ItemStack ingot, ItemStack center)
    {
        if((gear == null) | (ingot == null) | (center == null))
        {
            return false;
        } else
        {
        	HLCraftingHelper.addShapedOreRecipe(cloneStack(gear), " X ", "XIX", " X ", Character.valueOf('X'), cloneStack(ingot, 1), Character.valueOf('I'), cloneStack(center, 1));
            return true;
        }
    }

    public static boolean addRotatedGearRecipe(ResourceLocation resource_location, ItemStack gear, String ingot, String center)
    {
        if(gear == null || !oreNameExists(ingot) || !oreNameExists(center))
        {
            return false;
        } else
        {
        	HLCraftingHelper.addShapedOreRecipe(gear, new Object[] {
                "X X", " I ", "X X", Character.valueOf('X'), ingot, Character.valueOf('I'), center
            });
            return true;
        }
    }

    public static boolean addRotatedGearRecipe(ResourceLocation resource_location, ItemStack gear, String ingot, ItemStack center)
    {
        if((gear == null) | (center == null) || !oreNameExists(ingot))
        {
            return false;
        } else
        {
        	HLCraftingHelper.addShapedOreRecipe(gear, new Object[] {
                "X X", " I ", "X X", Character.valueOf('X'), ingot, Character.valueOf('I'), center
            });
            return true;
        }
    }

    public static boolean addRotatedGearRecipe(ResourceLocation resource_location, ItemStack gear, ItemStack ingot, String center)
    {
        if((gear == null) | (ingot == null) || !oreNameExists(center))
        {
            return false;
        } else
        {
        	HLCraftingHelper.addShapedOreRecipe(gear, new Object[] {
                "X X", " I ", "X X", Character.valueOf('X'), ingot, Character.valueOf('I'), center
            });
            return true;
        }
    }

    public static boolean addRotatedGearRecipe(ResourceLocation resource_location, ItemStack gear, ItemStack ingot, ItemStack center)
    {
        if((gear == null) | (ingot == null) | (center == null))
        {
            return false;
        } else
        {
        	HLCraftingHelper.addShapedOreRecipe(cloneStack(gear), "X X", " I ", "X X", Character.valueOf('X'), cloneStack(ingot, 1), Character.valueOf('I'), cloneStack(center, 1));
            return true;
        }
    }

    public static boolean addSurroundRecipe(ResourceLocation resource_location, ItemStack out, ItemStack one, ItemStack eight)
    {
        if((out == null) | (one == null) | (eight == null))
        {
            return false;
        } else
        {
            HLCraftingHelper.addShapedOreRecipe(cloneStack(out), "XXX", "XIX", "XXX", Character.valueOf('X'), cloneStack(eight, 1), Character.valueOf('I'), cloneStack(one, 1));
            return true;
        }
    }

    public static boolean addSurroundRecipe(ResourceLocation resource_location, ItemStack out, String one, ItemStack eight)
    {
        if((out == null) | (eight == null) || !oreNameExists(one))
        {
            return false;
        } else
        {
            HLCraftingHelper.addShapedOreRecipe(out, new Object[] {
                "XXX", "XIX", "XXX", Character.valueOf('X'), eight, Character.valueOf('I'), one
            });
            return true;
        }
    }

    public static boolean addSurroundRecipe(ResourceLocation resource_location, ItemStack out, ItemStack one, String eight)
    {
        if((out == null) | (one == null) || !oreNameExists(eight))
        {
            return false;
        } else
        {
            HLCraftingHelper.addShapedOreRecipe(out, new Object[] {
                "XXX", "XIX", "XXX", Character.valueOf('X'), eight, Character.valueOf('I'), one
            });
            return true;
        }
    }

    public static boolean addSurroundRecipe(ResourceLocation resource_location, ItemStack out, String one, String eight)
    {
        if(out == null || !oreNameExists(one) || !oreNameExists(eight))
        {
            return false;
        } else
        {
            HLCraftingHelper.addShapedOreRecipe(out, new Object[] {
                "XXX", "XIX", "XXX", Character.valueOf('X'), eight, Character.valueOf('I'), one
            });
            return true;
        }
    }

    public static boolean addFenceRecipe(ResourceLocation resource_location, ItemStack out, ItemStack in)
    {
        if((out == null) | (in == null))
        {
            return false;
        } else
        {
            HLCraftingHelper.addShapedOreRecipe(cloneStack(out), "XXX", "XXX", Character.valueOf('X'), cloneStack(in, 1));
            return true;
        }
    }

    public static boolean addFenceRecipe(ResourceLocation resource_location, ItemStack out, String in)
    {
        if(out == null || !oreNameExists(in))
        {
            return false;
        } else
        {
            HLCraftingHelper.addShapedOreRecipe( out, new Object[] {
                "XXX", "XXX", Character.valueOf('X'), in
            });
            return true;
        }
    }

    public static boolean addReverseStorageRecipe(ResourceLocation resource_location, ItemStack nine, String one)
    {
        if(nine == null || !oreNameExists(one))
        {
            return false;
        } else
        {
        	HLCraftingHelper.addShapelessOreRecipe(cloneStack(nine, 9), new Object[] {
                one
            });
            return true;
        }
    }

    public static boolean addReverseStorageRecipe(ResourceLocation resource_location, ItemStack nine, ItemStack one, Ingredient ingredient)
    {
        if((nine == null) | (one == null))
        {
            return false;
        } else
        {
            HLCraftingHelper.addShapelessOreRecipe(cloneStack(nine, 9), ingredient.apply(cloneStack(one, 1)));
            return true;
        }
    }

    public static boolean addSmallReverseStorageRecipe(ResourceLocation resource_location, ItemStack four, String one)
    {
        if(four == null || !oreNameExists(one))
        {
            return false;
        } else
        {
        	HLCraftingHelper.addShapelessOreRecipe(cloneStack(four, 4), new Object[] {
                one
            });
            return true;
        }
    }

    public static boolean addSmallReverseStorageRecipe(ResourceLocation resource_location, ItemStack four, ItemStack one)
    {
        if((four == null) | (one == null))
        {
            return false;
        } else
        {
        	HLCraftingHelper.addShapedOreRecipe(cloneStack(four, 4), cloneStack(one, 1));
            return true;
        }
    }

    public static boolean addStorageRecipe(ResourceLocation resource_location, ItemStack one, String nine)
    {
        if(one == null || !oreNameExists(nine))
        {
            return false;
        } else
        {
        	HLCraftingHelper.addShapelessOreRecipe(one, new Object[] {
                nine, nine, nine, nine, nine, nine, nine, nine, nine
            });
            return true;
        }
    }

    public static boolean addStorageRecipe(ResourceLocation resource_location, ItemStack one, ItemStack nine)
    {
        if((one == null) | (nine == null))
        {
            return false;
        } else
        {
            nine = cloneStack(nine, 1);
            HLCraftingHelper.addShapelessOreRecipe(one, nine, nine, nine, nine, nine, nine, nine, nine, nine);
            return true;
        }
    }

    public static boolean addSmallStorageRecipe(ResourceLocation resource_location, ItemStack one, String four)
    {
        if(one == null || !oreNameExists(four))
        {
            return false;
        } else
        {
            HLCraftingHelper.addShapedOreRecipe( one, new Object[] {
                "XX", "XX", Character.valueOf('X'), four
            });
            return true;
        }
    }

    public static boolean addSmallStorageRecipe(ResourceLocation resource_location, ItemStack one, ItemStack four)
    {
        if((one == null) | (four == null))
        {
            return false;
        } else
        {
            HLCraftingHelper.addShapedOreRecipe(cloneStack(one), "XX", "XX", Character.valueOf('X'), cloneStack(four, 1));
            return true;
        }
    }

    public static boolean addTwoWayStorageRecipe(ResourceLocation resource_location, ItemStack one, ItemStack nine)
    {
        return addStorageRecipe(resource_location, one, nine) && addReverseStorageRecipe(resource_location, nine, one, null);
    }

    public static boolean addTwoWayStorageRecipe(ResourceLocation resource_location, ItemStack one, String one_ore, ItemStack nine, String nine_ore)
    {
        return addStorageRecipe(resource_location, one, nine_ore) && addReverseStorageRecipe(resource_location, nine, one_ore);
    }

    public static boolean addSmallTwoWayStorageRecipe(ResourceLocation resource_location, ItemStack one, ItemStack four)
    {
        return addSmallStorageRecipe(resource_location, one, four) && addSmallReverseStorageRecipe(resource_location, four, one);
    }

    public static boolean addSmallTwoWayStorageRecipe(ResourceLocation resource_location, ItemStack one, String one_ore, ItemStack four, String four_ore)
    {
        return addSmallStorageRecipe(resource_location, one, four_ore) && addSmallReverseStorageRecipe(resource_location, four, one_ore);
    }

    public static boolean addSmelting(ItemStack out, Item in)
    {
        if((out == null) | (in == null))
        {
            return false;
        } else
        {
            FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), 0.0F);
            return true;
        }
    }

    public static boolean addSmelting(ItemStack out, Block in)
    {
        if((out == null) | (in == null))
        {
            return false;
        } else
        {
            FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), 0.0F);
            return true;
        }
    }

    public static boolean addSmelting(ItemStack out, ItemStack in)
    {
        if((out == null) | (in == null))
        {
            return false;
        } else
        {
            FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), 0.0F);
            return true;
        }
    }

    public static boolean addSmelting(ItemStack out, Item in, float XP)
    {
        if((out == null) | (in == null))
        {
            return false;
        } else
        {
            FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), XP);
            return true;
        }
    }

    public static boolean addSmelting(ItemStack out, Block in, float XP)
    {
        if((out == null) | (in == null))
        {
            return false;
        } else
        {
            FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), XP);
            return true;
        }
    }

    public static boolean addSmelting(ItemStack out, ItemStack in, float XP)
    {
        if((out == null) | (in == null))
        {
            return false;
        } else
        {
            FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), XP);
            return true;
        }
    }

    public static boolean addWeakSmelting(ItemStack out, Item in)
    {
        if((out == null) | (in == null))
        {
            return false;
        } else
        {
            FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), 0.1F);
            return true;
        }
    }

    public static boolean addWeakSmelting(ItemStack out, Block in)
    {
        if((out == null) | (in == null))
        {
            return false;
        } else
        {
            FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), 0.1F);
            return true;
        }
    }

    public static boolean addWeakSmelting(ItemStack out, ItemStack in)
    {
        if((out == null) | (in == null))
        {
            return false;
        } else
        {
            FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), 0.1F);
            return true;
        }
    }

    public static boolean addTwoWayConversionRecipe(ResourceLocation resource_location, ItemStack a, ItemStack b)
    {
        if((a == null) | (b == null))
        {
            return false;
        } else
        {
            HLCraftingHelper.addShapedOreRecipe(cloneStack(a, 1), cloneStack(b, 1));
            HLCraftingHelper.addShapedOreRecipe(cloneStack(b, 1), cloneStack(a, 1));
            return true;
        }
    }

    public static void registerWithHandlers(String oreName, ItemStack stack)
    {
        OreDictionary.registerOre(oreName, stack);
    }

    /*public static boolean isPlayerHoldingMultiModeItem(EntityPlayer player)
    {
        if(!isPlayerHoldingSomething(player))
        {
            return false;
        } else
        {
            ItemStack heldItem = getHeldStack(player);
            Item equipped = heldItem.getItem();
            return equipped instanceof IMultiModeItem;
        }
    }

    public static boolean incrHeldMultiModeItemState(EntityPlayer player)
    {
        if(!isPlayerHoldingSomething(player))
        {
            return false;
        } else
        {
            ItemStack heldItem = getHeldStack(player);
            Item equipped = heldItem.getItem();
            IMultiModeItem multiModeItem = (IMultiModeItem)equipped;
            return multiModeItem.incrMode(heldItem);
        }
    }

    public static boolean decrHeldMultiModeItemState(EntityPlayer player)
    {
        if(!isPlayerHoldingSomething(player))
        {
            return false;
        } else
        {
            ItemStack equipped = getHeldStack(player);
            IMultiModeItem multiModeItem = (IMultiModeItem)equipped.getItem();
            return multiModeItem.incrMode(equipped);
        }
    }

    public static boolean setHeldMultiModeItemState(EntityPlayer player, int mode)
    {
        if(!isPlayerHoldingSomething(player))
        {
            return false;
        } else
        {
            ItemStack equipped = getHeldStack(player);
            IMultiModeItem multiModeItem = (IMultiModeItem)equipped.getItem();
            return multiModeItem.setMode(equipped, mode);
        }
    }

    public static boolean isPlayerHoldingFluidHandler(EntityPlayer player)
    {
        return FluidHelper.isPlayerHoldingFluidHandler(player);
    }

    public static boolean isPlayerHoldingEnergyContainerItem(EntityPlayer player)
    {
        return EnergyHelper.isPlayerHoldingEnergyContainerItem(player);
    }*/

    public static boolean isPlayerHoldingNothing(EntityPlayer player)
    {
        return getHeldStack(player) == null;
    }

    public static Item getItemFromStack(ItemStack theStack)
    {
        return theStack != null ? theStack.getItem() : null;
    }

    public static boolean areItemsEqual(Item itemA, Item itemB)
    {
        if((itemA == null) | (itemB == null))
            return false;
        else
            return itemA == itemB || itemA.equals(itemB);
    }

    public static boolean isPlayerHoldingItem(Class<?> item, EntityPlayer player)
    {
        return item.isInstance(getItemFromStack(getHeldStack(player)));
    }

    public static boolean isPlayerHoldingItem(Item item, EntityPlayer player)
    {
        return areItemsEqual(item, getItemFromStack(getHeldStack(player)));
    }

    public static boolean isPlayerHoldingMainhand(Item item, EntityPlayer player)
    {
        return areItemsEqual(item, getItemFromStack(getMainhandStack(player)));
    }

    public static boolean isPlayerHoldingOffhand(Item item, EntityPlayer player)
    {
        return areItemsEqual(item, getItemFromStack(getOffhandStack(player)));
    }

    public static boolean isPlayerHoldingItemStack(ItemStack stack, EntityPlayer player)
    {
        return itemsEqualWithMetadata(stack, getHeldStack(player));
    }

    public static boolean itemsDamageEqual(ItemStack stackA, ItemStack stackB)
    {
        return !stackA.getHasSubtypes() && stackA.getMaxDamage() == 0 || getItemDamage(stackA) == getItemDamage(stackB);
    }

    public static boolean itemsEqualWithoutMetadata(ItemStack stackA, ItemStack stackB)
    {
        if(stackA == null || stackB == null)
            return false;
        else
            return areItemsEqual(stackA.getItem(), stackB.getItem());
    }

    public static boolean itemsEqualWithoutMetadata(ItemStack stackA, ItemStack stackB, boolean checkNBT)
    {
        return itemsEqualWithoutMetadata(stackA, stackB) && (!checkNBT || doNBTsMatch(stackA.getTagCompound(), stackB.getTagCompound()));
    }

    public static boolean itemsEqualWithMetadata(ItemStack stackA, ItemStack stackB)
    {
        return itemsEqualWithoutMetadata(stackA, stackB) && itemsDamageEqual(stackA, stackB);
    }

    public static boolean itemsEqualWithMetadata(ItemStack stackA, ItemStack stackB, boolean checkNBT)
    {
        return itemsEqualWithMetadata(stackA, stackB) && (!checkNBT || doNBTsMatch(stackA.getTagCompound(), stackB.getTagCompound()));
    }

    public static boolean itemsIdentical(ItemStack stackA, ItemStack stackB)
    {
        return itemsEqualWithoutMetadata(stackA, stackB) && getItemDamage(stackA) == getItemDamage(stackB) && doNBTsMatch(stackA.getTagCompound(), stackB.getTagCompound());
    }

    public static boolean doNBTsMatch(NBTTagCompound nbtA, NBTTagCompound nbtB)
    {
        if((nbtA == null) & (nbtB == null))
            return true;
        if((nbtA != null) & (nbtB != null))
            return nbtA.equals(nbtB);
        else
            return false;
    }

    public static boolean itemsEqualForCrafting(ItemStack stackA, ItemStack stackB)
    {
        return itemsEqualWithoutMetadata(stackA, stackB) && (!stackA.getHasSubtypes() || getItemDamage(stackA) == 32767 || getItemDamage(stackB) == 32767 || getItemDamage(stackB) == getItemDamage(stackA));
    }

    public static boolean craftingEquivalent(ItemStack checked, ItemStack source, String oreDict, ItemStack output)
    {
        if(itemsEqualForCrafting(checked, source))
            return true;
        if(output != null && isBlacklist(output))
            return false;
        if(oreDict == null || oreDict.equals("Unknown"))
            return false;
        else
            return getOreName(checked).equalsIgnoreCase(oreDict);
    }

    /*public static boolean doOreIDsMatch(ItemStack stackA, ItemStack stackB)
    {
        int id = oreProxy.getOreID(stackA);
        return id >= 0 && id == oreProxy.getOreID(stackB);
    }*/

    public static boolean isBlacklist(ItemStack output)
    {
        Item item = output.getItem();
        return Item.getItemFromBlock(Blocks.BIRCH_STAIRS) == item || Item.getItemFromBlock(Blocks.JUNGLE_STAIRS) == item || Item.getItemFromBlock(Blocks.OAK_STAIRS) == item || Item.getItemFromBlock(Blocks.SPRUCE_STAIRS) == item || Item.getItemFromBlock(Blocks.PLANKS) == item || Item.getItemFromBlock(Blocks.WOODEN_SLAB) == item;
    }

    public static String getItemNBTString(ItemStack theItem, String nbtKey, String invalidReturn)
    {
        return theItem.getTagCompound() == null || !theItem.getTagCompound().hasKey(nbtKey) ? invalidReturn : theItem.getTagCompound().getString(nbtKey);
    }

    public static void addInventoryInformation(ItemStack stack, List<String> list)
    {
        addInventoryInformation(stack, list, 0, 0x7fffffff);
    }

    @SuppressWarnings("unused")
	public static void addInventoryInformation(ItemStack stack, List<String> list, int minSlot, int maxSlot)
    {
        if(stack.getTagCompound() == null)
        {
            list.add(StringHelper.localize("info.cofh.empty"));
            return;
        }
        /*if((stack.getItem() instanceof IInventoryContainerItem) && stack.getTagCompound().hasKey("Accessible"))
        {
            addAccessibleInventoryInformation(stack, list, minSlot, maxSlot);
            return;
        }*/
        if(!stack.getTagCompound().hasKey("Inventory", 9) || stack.getTagCompound().getTagList("Inventory", stack.getTagCompound().getId()).tagCount() <= 0)
        {
            list.add(StringHelper.localize("info.cofh.empty"));
            return;
        }
        NBTTagList nbtList = stack.getTagCompound().getTagList("Inventory", stack.getTagCompound().getId());
        ArrayList<?> containedItems = new ArrayList<Object>();
        if(containedItems.size() > 0)
            list.add((new StringBuilder()).append(StringHelper.localize("info.cofh.contents")).append(":").toString());
        for(Iterator<?> iterator = containedItems.iterator(); iterator.hasNext();)
        {
            ItemStack item = (ItemStack)iterator.next();
            int maxStackSize = item.getMaxStackSize();
            if(!StringHelper.displayStackCount || item.getCount() < maxStackSize || maxStackSize == 1)
                list.add((new StringBuilder()).append("    \2476").append(item.getCount()).append(" ").append(StringHelper.getItemName(item)).toString());
            else
            if(item.getCount() % maxStackSize != 0)
                list.add((new StringBuilder()).append("    \2476").append(maxStackSize).append("x").append(item.getCount() / maxStackSize).append("+").append(item.getCount() % maxStackSize).append(" ").append(StringHelper.getItemName(item)).toString());
            else
                list.add((new StringBuilder()).append("    \2476").append(maxStackSize).append("x").append(item.getCount() / maxStackSize).append(" ").append(StringHelper.getItemName(item)).toString());
        }

    }

    /*public static void addAccessibleInventoryInformation(ItemStack stack, List list, int minSlot, int maxSlot)
    {
        int invSize = ((IInventoryContainerItem)stack.getItem()).getSizeInventory(stack);
        ArrayList containedItems = new ArrayList();
        boolean visited[] = new boolean[invSize];
        NBTTagCompound tag = stack.getTagCompound();
        if(tag.hasKey("Inventory"))
            tag = tag.getCompoundTag("Inventory");
        for(int i = minSlot; i < Math.min(invSize, maxSlot); i++)
        {
            if(visited[i] || !tag.hasKey((new StringBuilder()).append("Slot").append(i).toString()))
                continue;
            ItemStack curStack = ItemStack.loadItemStackFromNBT(tag.getCompoundTag((new StringBuilder()).append("Slot").append(i).toString()));
            visited[i] = true;
            if(curStack == null)
                continue;
            containedItems.add(curStack);
            for(int j = minSlot; j < Math.min(invSize, maxSlot); j++)
            {
                if(visited[j] || !tag.hasKey((new StringBuilder()).append("Slot").append(j).toString()))
                    continue;
                ItemStack curStack2 = ItemStack.(tag.getCompoundTag((new StringBuilder()).append("Slot").append(j).toString()));
                if(curStack2 != null && itemsIdentical(curStack, curStack2))
                {
                    curStack.stackSize += curStack2.getCount();
                    visited[j] = true;
                }
            }

        }

        if(containedItems.size() > 0)
            list.add((new StringBuilder()).append(StringHelper.localize("info.cofh.contents")).append(":").toString());
        else
            list.add(StringHelper.localize("info.cofh.empty"));
        for(Iterator iterator = containedItems.iterator(); iterator.hasNext();)
        {
            ItemStack item = (ItemStack)iterator.next();
            int maxStackSize = item.getMaxStackSize();
            if(!StringHelper.displayStackCount || item.getCount() < maxStackSize || maxStackSize == 1)
                list.add((new StringBuilder()).append("    \2476").append(item.getCount()).append(" ").append(StringHelper.getItemName(item)).toString());
            else
            if(item.getCount() % maxStackSize != 0)
                list.add((new StringBuilder()).append("    \2476").append(maxStackSize).append("x").append(item.getCount() / maxStackSize).append("+").append(item.getCount() % maxStackSize).append(" ").append(StringHelper.getItemName(item)).toString());
            else
                list.add((new StringBuilder()).append("    \2476").append(maxStackSize).append("x").append(item.getCount() / maxStackSize).append(" ").append(StringHelper.getItemName(item)).toString());
        }

    }*/

    public static boolean areItemStacksEqualIgnoreTags(ItemStack stackA, ItemStack stackB, String nbtTagsToIgnore[])
    {
        if(stackA == null && stackB == null)
            return true;
        if(stackA == null && stackB != null)
            return false;
        if(stackA != null && stackB == null)
            return false;
        if(stackA.getItem() != stackB.getItem())
            return false;
        if(stackA.getItemDamage() != stackB.getItemDamage())
            return false;
        if(stackA.getCount() != stackB.getCount())
            return false;
        if(stackA.getTagCompound() == null && stackB.getTagCompound() == null)
            return true;
        if(stackA.getTagCompound() == null && stackB.getTagCompound() != null)
            return false;
        if(stackA.getTagCompound() != null && stackB.getTagCompound() == null)
            return false;
        int numberOfKeys = stackA.getTagCompound().getKeySet().size();
        if(numberOfKeys != stackB.getTagCompound().getKeySet().size())
            return false;
        NBTTagCompound tagA = stackA.getTagCompound();
        NBTTagCompound tagB = stackB.getTagCompound();
        String keys[] = new String[numberOfKeys];
        keys = (String[])tagA.getKeySet().toArray(keys);
label0:
        for(int i = 0; i < numberOfKeys; i++)
        {
            for(int j = 0; j < nbtTagsToIgnore.length; j++)
                if(nbtTagsToIgnore[j].equals(keys[i]))
                    continue label0;

            if(!tagA.getTag(keys[i]).equals(tagB.getTag(keys[i])))
                return false;
        }

        return true;
    }

    public static final String BLOCK = "block";
    public static final String ORE = "ore";
    public static final String DUST = "dust";
    public static final String INGOT = "ingot";
    public static final String NUGGET = "nugget";
    public static final String LOG = "log";
    public static OreDictionaryProxy oreProxy = new OreDictionaryProxy();

}
