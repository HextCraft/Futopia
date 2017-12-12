package net.thegaminghuskymc.futopia;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thegaminghuskymc.futopia.client.gui.GuiHandler;
import net.thegaminghuskymc.futopia.init.FTBlocks;
import net.thegaminghuskymc.futopia.init.FTBlocksAlt;
import net.thegaminghuskymc.futopia.init.FTItems;
import net.thegaminghuskymc.futopia.init.OtherBlocks;
import net.thegaminghuskymc.futopia.proxy.IFutopiaProxy;
import net.thegaminghuskymc.futopia.world.gen.OreGen;
import net.thegaminghuskymc.futopia.world.gen.WorldGenerationHandler;

import java.util.logging.Logger;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Futopia {

    @Mod.Instance(value = Reference.MODID)
    public static Futopia INSTANCE;
    public static GuiHandler GUI_HANDLER;
    public static Logger LOGGER = Logger.getLogger(Reference.NAME);

    @SidedProxy(clientSide = Reference.CSIDE, serverSide = Reference.SSIDE)
    public static IFutopiaProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        OtherBlocks.preInit();

        proxy.preInit(event);

        FTBlocks.init();
        FTItems.init();
        FTBlocks.register();
        FTItems.register();
        FTBlocks.registerTE();
//        FTBlocksAlt.registerTE();

        proxy.registerRenders();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);

//        FutopiaOreDictionary.init();
//        Recipies.init();
        GameRegistry.registerWorldGenerator(new OreGen(), 0);
        GameRegistry.registerWorldGenerator(new WorldGenerationHandler(), 1);
        NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, GUI_HANDLER);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }



}