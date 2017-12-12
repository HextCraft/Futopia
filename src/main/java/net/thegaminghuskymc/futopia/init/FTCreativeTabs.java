package net.thegaminghuskymc.futopia.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class FTCreativeTabs {

	public static CreativeTabs main;
	public static CreativeTabs machines;
	public static CreativeTabs world_gen;
	public static CreativeTabs computer_parts;
	// public static CreativeTabs armor;
	public static CreativeTabs items;
	public static CreativeTabs tools;

	static {
		main = new CreativeTabs("main_ft") {
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(OtherBlocks.basalt);
			}
		};

		machines = new CreativeTabs("machines_ft") {
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(FTBlocks.alloyfurnace);
			}
		};

		computer_parts = new CreativeTabs("computer_parts_ft") {
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(FTBlocks.diskDrive);
			}
		};

		world_gen = new CreativeTabs("worldgen_ft") {
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(OtherBlocks.marble);
			}
		};

		items = new CreativeTabs("items_ft") {
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(FTItems.gears);
			}
		};

		/*
		 * tools = new CreativeTabs("tools_ft") {
		 * 
		 * @Override public ItemStack getTabIconItem() { return new
		 * ItemStack(Items.IRON_AXE); } };
		 */
	}

}
