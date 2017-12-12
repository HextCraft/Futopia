package net.thegaminghuskymc.futopia.init;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.items.*;
import net.thegaminghuskymc.futopia.items.materials.*;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.huskylib.RebornRegistry;

import java.util.HashSet;

public class FTItemsAlt {

    public static HashSet<Item> items = new HashSet<>();

    private static CreativeTabs tabs = FTCreativeTabs.items;

    public static ToolMaterial toolMaterialFT = EnumHelper.addToolMaterial("ft", 2, 700, 6.1f, 2.1f, 15);

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

    public static ItemStele stele;

    public static ItemUpgrades upgrades;

    public static void init() {
        items.add(saw = new ItemSaw());
        items.add(hammer = new ItemHammer());
        items.add(windows_washer = new ItemWindowsWasher());
        items.add(meteor_spawner = new ItemMeteorSpawner());
        items.add(dusts = new ItemBaseDust(tabs));
        items.add(ingots = new ItemBaseIngot(tabs));
        items.add(nuggets = new ItemBaseNugget(tabs));
        items.add(gears = new ItemBaseGear(tabs));
        items.add(plates = new ItemBasePlate(tabs));
        items.add(shards = new ItemBaseShard(tabs));

        items.add(ironStick = new ItemIronStick());
        items.add(stele = new ItemStele());
        items.add(upgrades = new ItemUpgrades());
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders() {
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

        registerRenderSpecial(saw);
        registerRenderSpecial(hammer);

        registerRender(upgrades, upgrades.getDamage(new ItemStack(upgrades)));
    }

    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event) {
        for (Item i : items){
            event.getRegistry().register(i);
        }
    }

    @SubscribeEvent
    public static void registerRender(Item i, int meta) {
        ModelLoader.setCustomModelResourceLocation(i, meta, new ModelResourceLocation(i.getRegistryName(), "inventory"));
    }

    public static void registerRenderSpecial(Item item) {
        for (EnumMaterialType types : EnumMaterialType.values()) {
            RebornRegistry.registerItemModel(item, types.getMeta(), types.getName());
        }
    }

}