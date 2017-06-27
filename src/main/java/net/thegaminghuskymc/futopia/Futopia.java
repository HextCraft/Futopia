package net.thegaminghuskymc.futopia;

import static net.thegaminghuskymc.futopia.Refs.CSIDE;
import static net.thegaminghuskymc.futopia.Refs.SSIDE;

import java.util.logging.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thegaminghuskymc.futopia.client.gui.GuiHandler;
import net.thegaminghuskymc.futopia.init.FTBlocks;
import net.thegaminghuskymc.futopia.init.FTItems;
import net.thegaminghuskymc.futopia.init.OtherBlocks;
import net.thegaminghuskymc.futopia.proxy.IFutopiaProxy;

@Mod(modid = Refs.MODID, name = Refs.NAME, version = Refs.VERSION, dependencies = Refs.DEPS, acceptedMinecraftVersions = Refs.ACC_MC)
public class Futopia {

    @Instance(value = Refs.MODID)
    public static Futopia INSTANCE = new Futopia();
    public static final GuiHandler GUI_HANDLER = new GuiHandler();
    public static Logger LOGGER = Logger.getLogger(Refs.NAME);

    @SidedProxy(clientSide = CSIDE, serverSide = SSIDE)
    public static IFutopiaProxy PROXY;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	
    	OtherBlocks.preInit();
    	
    	PROXY.preInit(event);
        
        FTBlocks.init();
        FTItems.init();
        FTBlocks.register();
        FTItems.register();
       
        PROXY.registerRenders();
        PROXY.registerTileEntities();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    	OtherBlocks.initialize();
    	PROXY.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	OtherBlocks.postInit();
        PROXY.postInit(event);
    }
}