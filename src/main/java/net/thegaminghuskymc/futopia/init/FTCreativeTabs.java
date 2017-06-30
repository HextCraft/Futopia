package net.thegaminghuskymc.futopia.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thegaminghuskymc.futopia.Refs;

@GameRegistry.ObjectHolder(value = Refs.MODID)
public class FTCreativeTabs {

    public static CreativeTabs main;
    public static CreativeTabs machines;
    public static CreativeTabs world_gen;
//    public static CreativeTabs armor;
    public static CreativeTabs materials;
//    public static CreativeTabs tools;

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
                return new ItemStack(FTBlocks.projectTable);
            }
        };

        world_gen = new CreativeTabs("worldgen_ft") {
        	@Override
        	public ItemStack getTabIconItem() {
        		return new ItemStack(Blocks.DIAMOND_ORE);
        	}
        };

        /*armor = new CreativeTabs("armor_ft") {
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Items.DIAMOND_HELMET);
            }
        };*/

        materials = new CreativeTabs("materials_ft") {
        	@Override
        	public ItemStack getTabIconItem() {
        		return new ItemStack(Blocks.BLACK_GLAZED_TERRACOTTA);
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
