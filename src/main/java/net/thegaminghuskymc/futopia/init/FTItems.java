package net.thegaminghuskymc.futopia.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.thegaminghuskymc.futopia.items.ItemHammer;
import net.thegaminghuskymc.futopia.items.ItemIronStick;
import net.thegaminghuskymc.futopia.items.ItemMeteorSpawner;
import net.thegaminghuskymc.futopia.items.ItemSaw;
import net.thegaminghuskymc.futopia.items.ItemStele;
import net.thegaminghuskymc.futopia.items.ItemWindowsWasher;
import net.thegaminghuskymc.futopia.items.materials.ItemBaseDust;
import net.thegaminghuskymc.futopia.items.materials.ItemBaseGear;
import net.thegaminghuskymc.futopia.items.materials.ItemBaseIngot;
import net.thegaminghuskymc.futopia.items.materials.ItemBaseNugget;
import net.thegaminghuskymc.futopia.items.materials.ItemBasePlate;
import net.thegaminghuskymc.futopia.items.materials.ItemBaseShard;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.huskylib.RebornRegistry;
import net.thegaminghuskymc.huskylib.items.ItemBase;

public class FTItems {
	
	private static CreativeTabs tabs = FTCreativeTabs.materials;
	
	public static ToolMaterial toolMaterialBlue = EnumHelper.addToolMaterial("blue", 2, 700, 6.1F, 2.1F, 15);
	public static ToolMaterial toolMaterialGreen = EnumHelper.addToolMaterial("green", 2, 700, 6.1F, 2.1F, 15);
	public static ToolMaterial toolMaterialRed = EnumHelper.addToolMaterial("red", 2, 700, 6.1F, 2.1F, 15);
	public static ToolMaterial toolMaterialPurple = EnumHelper.addToolMaterial("purple", 2, 700, 6.1F, 2.1F, 15);
	public static ToolMaterial toolMaterialTungsten = EnumHelper.addToolMaterial("tungsten", 2, 700, 6.1F, 2.1F, 15);
	public static ToolMaterial toolMaterialZinc = EnumHelper.addToolMaterial("zinc", 2, 700, 6.1F, 2.1F, 15);
	
	public static ItemSaw saw;
    public static ItemHammer hammer;

    public static ItemWindowsWasher windows_washer;
    public static ItemMeteorSpawner meteor_spawner;
    public static ItemBaseDust dusts;
    public static ItemBaseIngot ingots;
    public static ItemBaseNugget nuggets;
    public static ItemBaseGear gears;
    public static ItemBasePlate plates;
    public static ItemBaseShard shards;

    public static ItemIronStick ironStick;
    
    public static ItemBase test_item;

    public static ItemStele stele;
    
    public static void init(){
    	windows_washer = new ItemWindowsWasher();
        meteor_spawner = new ItemMeteorSpawner();

        ironStick = new ItemIronStick();

        nuggets = new ItemBaseNugget(tabs);
        ingots = new ItemBaseIngot(tabs);
        dusts = new ItemBaseDust(tabs);
        plates = new ItemBasePlate(tabs);
        gears = new ItemBaseGear(tabs);
        shards = new ItemBaseShard(tabs);

        stele = new ItemStele();

        saw = new ItemSaw();
        hammer = new ItemHammer();
    }
    
    public static void register(){
    	registerItem(windows_washer);
    	registerItem(meteor_spawner);
    	registerItem(ironStick);
    	
    	registerItem(nuggets);
    	registerItem(ingots);
    	registerItem(dusts);
    	registerItem(plates);
    	registerItem(gears);
    	registerItem(shards);
    	
    	registerItem(stele);
    	
    	registerItem(saw);
    	registerItem(hammer);
    }
    
    public static void registerRenders(){
    	registerRender(windows_washer, 0);
    	registerRender(meteor_spawner, 0);
    	registerRender(ironStick, 0);
    	
    	registerRenderSpecial(nuggets);
    	registerRenderSpecial(ingots);
    	registerRenderSpecial(dusts);
    	registerRenderSpecial(plates);
    	registerRenderSpecial(gears);
    	registerRenderSpecial(shards);
    	
    	registerRender(stele, 0);
    	
    	registerRender(saw, 0);
    	registerRender(hammer, 0);
    }
    
    public static void registerItem(Item item) {
    	RebornRegistry.registerItem(item);
	}
	
	public static void registerRender(Item item, int meta) {
		RebornRegistry.registerItemModel(item, meta);
	}
	
	public static void registerRenderSpecial(Item item) {
		for(EnumMaterialType types : EnumMaterialType.values()){
			RebornRegistry.registerItemModel(item, types.getMeta(), types.getName());
		}
	}

}