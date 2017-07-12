package net.thegaminghuskymc.futopia.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thegaminghuskymc.futopia.Refs;

@GameRegistry.ObjectHolder(value = Refs.MODID)
public class FTCreativeTabs {

    public static CreativeTabs main;
    public static CreativeTabs machines;
    public static CreativeTabs world_gen;
    public static CreativeTabs computer_parts;
//    public static CreativeTabs armor;
    public static CreativeTabs items;
    public static CreativeTabs tools;

    static {
        main = new CreativeTabs("main_ft") {
        	@Override
            public ItemStack getTabIconItem() {
                return new ItemStack(OtherBlocks.limestone);
            }
        };
        
        machines = new CreativeTabs("machines_ft") {
        	@Override
            public ItemStack getTabIconItem() {
                return new ItemStack(FTBlocks.particleSummoner);
            }
        };
        
        computer_parts = new CreativeTabs("computer_parts_ft") {
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(FTBlocks.monitor);
			}
		};

        world_gen = new CreativeTabs("worldgen_ft") {
        	@Override
        	public ItemStack getTabIconItem() {
        		return new ItemStack(FTBlocks.ores);
        	}
        };

        items = new CreativeTabs("items_ft") {
        	@Override
        	public ItemStack getTabIconItem() {
        		return new ItemStack(FTItems.gears);
        	}
        };

        /*tools = new CreativeTabs("tools_ft") {
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Items.IRON_AXE);
            }
        };*/
    }

}
