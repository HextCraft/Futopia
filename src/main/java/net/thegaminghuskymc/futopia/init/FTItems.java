package net.thegaminghuskymc.futopia.init;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.thegaminghuskymc.futopia.items.*;
import net.thegaminghuskymc.futopia.items.materials.*;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.huskylib.RebornRegistry;

public class FTItems {

	private static CreativeTabs tabs = FTCreativeTabs.items;

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

		upgrades = new ItemUpgrades();
	}

	public static void register() {
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

		registerItem(upgrades);
	}

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

	public static void registerItem(Item item) {
		RebornRegistry.registerItem(item);
	}

	public static void registerRender(Item item, int meta) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

	public static void registerRenderSpecial(Item item) {
		for (EnumMaterialType types : EnumMaterialType.values()) {
			RebornRegistry.registerItemModel(item, types.getMeta(), types.getName());
		}
	}

}