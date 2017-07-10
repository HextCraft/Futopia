package net.thegaminghuskymc.futopia;

import static net.thegaminghuskymc.futopia.Refs.CSIDE;
import static net.thegaminghuskymc.futopia.Refs.SSIDE;

import java.util.logging.Logger;

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
import net.thegaminghuskymc.futopia.init.FTItems;
import net.thegaminghuskymc.futopia.init.FutopiaOreDictionary;
import net.thegaminghuskymc.futopia.init.OtherBlocks;
import net.thegaminghuskymc.futopia.init.Recipies;
import net.thegaminghuskymc.futopia.integration.FutopiaIntegrations;
import net.thegaminghuskymc.futopia.proxy.IFutopiaProxy;
import net.thegaminghuskymc.futopia.world.gen.OreGen;

@Mod(modid = Refs.MODID, name = Refs.NAME, version = Refs.VERSION, dependencies = Refs.DEPS, acceptedMinecraftVersions = Refs.ACC_MC)
public class Futopia {

	@Mod.Instance
	public static Futopia INSTANCE;
	public static final GuiHandler GUI_HANDLER = new GuiHandler();
	public static Logger LOGGER = Logger.getLogger(Refs.NAME);

	@SidedProxy(clientSide = CSIDE, serverSide = SSIDE)
	public static IFutopiaProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		OtherBlocks.preInit();
		
		proxy.preInit(event);

		FTBlocks.init();
		FTItems.init();
		FTBlocks.register();
		FTItems.register();
		
		FutopiaIntegrations.preInit();

		proxy.registerRenders();
		proxy.registerTileEntities();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		OtherBlocks.initialize();
		FutopiaOreDictionary.init();
		Recipies.init();
		GameRegistry.registerWorldGenerator(new OreGen(), 0);
        NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, GUI_HANDLER);
		proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		OtherBlocks.postInit();
		proxy.postInit(event);
	}
}