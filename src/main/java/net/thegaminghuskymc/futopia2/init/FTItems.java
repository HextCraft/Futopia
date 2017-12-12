package net.thegaminghuskymc.futopia2.init;

import de.keri.cubeloader.loader.loadstage.LoadStage;
import net.thegaminghuskymc.futopia2.items.*;

public class FTItems {

	public static final ItemSaw saw = new ItemSaw();
	public static final ItemHammer hammer = new ItemHammer();

	public static final ItemBaseDust dusts = new ItemBaseDust();
	public static final ItemBaseIngot ingots = new ItemBaseIngot();
	public static final ItemBaseNugget nuggets = new ItemBaseNugget();
	public static final ItemBaseGear gears = new ItemBaseGear();
	public static final ItemBasePlate plates = new ItemBasePlate();
	public static final ItemBaseShard shards = new ItemBaseShard();

	public static void registerItem(LoadStage loadStage) {
		loadStage.registerLoadable(saw);
		loadStage.registerLoadable(hammer);

		loadStage.registerLoadable(dusts);
		loadStage.registerLoadable(ingots);
		loadStage.registerLoadable(gears);
		loadStage.registerLoadable(plates);
		loadStage.registerLoadable(shards);
	}

}