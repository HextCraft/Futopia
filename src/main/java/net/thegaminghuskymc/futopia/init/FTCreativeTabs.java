package net.thegaminghuskymc.futopia.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class FTCreativeTabs {

    public static CreativeTabs main;
    public static CreativeTabs machines;
    public static CreativeTabs world_gen;
    public static CreativeTabs armor;
    public static CreativeTabs materials;
    public static CreativeTabs tools;

    static {
        main = new CreativeTabs("main") {
        	@Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Blocks.BONE_BLOCK);
            }
        };
        
        machines = new CreativeTabs("main") {
        	@Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Blocks.LIT_FURNACE);
            }
        };

        world_gen = new CreativeTabs("materials") {
        	@Override
        	public ItemStack getTabIconItem() {
        		return new ItemStack(Blocks.DIAMOND_ORE);
        	}
        };

        armor = new CreativeTabs("tools") {
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Items.DIAMOND_HELMET);
            }
        };

        materials = new CreativeTabs("materials") {
        	@Override
        	public ItemStack getTabIconItem() {
        		return new ItemStack(Blocks.BLACK_GLAZED_TERRACOTTA);
        	}
        };

        tools = new CreativeTabs("tools") {
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Items.IRON_AXE);
            }
        };
    }

}
