package net.thegaminghuskymc.futopia2.init;

import de.keri.cubeloader.loader.loadstage.LoadStage;
import net.thegaminghuskymc.futopia2.blocks.BlockBaseOres;
import net.thegaminghuskymc.futopia2.blocks.BlockBaseOresEnd;
import net.thegaminghuskymc.futopia2.blocks.BlockBaseOresNether;
import net.thegaminghuskymc.futopia2.blocks.BlockBaseStorage;

public class FTBlocks {

    public static BlockBaseOres ores = new BlockBaseOres();
    public static BlockBaseOresNether oresNether = new BlockBaseOresNether();
    public static BlockBaseOresEnd oresEnd = new BlockBaseOresEnd();
    public static BlockBaseStorage storage = new BlockBaseStorage();

    public static void registerBlock(LoadStage loadStage) {
        loadStage.registerLoadable(ores);
        loadStage.registerLoadable(oresNether);
        loadStage.registerLoadable(oresEnd);
        loadStage.registerLoadable(storage);
    }

}
