package net.thegaminghuskymc.futopia2;

import de.keri.cubeloader.loader.IMod;
import de.keri.cubeloader.loader.IProxy;
import de.keri.cubeloader.loader.Mod;
import de.keri.cubeloader.loader.loadstage.LoadStage;
import net.thegaminghuskymc.futopia2.init.FTBlocks;
import net.thegaminghuskymc.futopia2.init.FTItems;
import net.thegaminghuskymc.futopia2.init.FutopiaOreDictionary;
import net.thegaminghuskymc.futopia2.proxy.ClientProxy;
import net.thegaminghuskymc.futopia2.proxy.CommonProxy;

@Mod
public class Futopia2 implements IMod {

    @Override
    public String getModid() {
        return "futopia2";
    }

    @Override
    public IProxy getClientProxy() {
        return new ClientProxy();
    }

    @Override
    public IProxy getServerProxy() {
        return new CommonProxy();
    }

    @Override
    public void load(LoadStage loadStage) {
        switch(loadStage.getStageType()) {
            case PRE_INIT:
                FTBlocks.registerBlock(loadStage);
                FTItems.registerItem(loadStage);
//                FutopiaOreDictionary.init();
//                Recipies.init();
            default:
        }
    }

}
