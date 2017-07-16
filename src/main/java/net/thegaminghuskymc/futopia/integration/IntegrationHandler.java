package net.thegaminghuskymc.futopia.integration;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.futopia.Futopia;

public class IntegrationHandler {

	public static final IntegrationHandler INSTANCE = new IntegrationHandler();
	private static List<IIntegrationModule> MODULES = Lists.newArrayList();

	public void preInit(FMLPreInitializationEvent event) {
		for (IIntegrationModule module : MODULES) {
			if (module.isEnabled()) {
				module.preInit(event);
				Futopia.LOGGER.info(String.format("Loading integration for [%s]", module.getName()));
			}
		}
	}

	public void init(FMLInitializationEvent event) {
		for (IIntegrationModule module : MODULES) {
			if (module.isEnabled()) {
				module.init(event);
			}
		}
	}

	public void postInit(FMLPostInitializationEvent event) {
		for (IIntegrationModule module : MODULES) {
			if (module.isEnabled()) {
				module.postInit(event);
				Futopia.LOGGER.info(String.format("Done loading integration for [%s]", module.getName()));
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void preInitClient(FMLPreInitializationEvent event) {
		for (IIntegrationModule module : MODULES) {
			if (module.isEnabled()) {
				module.preInitClient(event);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void initClient(FMLInitializationEvent event) {
		for (IIntegrationModule module : MODULES) {
			if (module.isEnabled()) {
				module.initClient(event);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void postInitClient(FMLPostInitializationEvent event) {
		for (IIntegrationModule module : MODULES) {
			if (module.isEnabled()) {
				module.postInitClient(event);
			}
		}
	}

	public void registerModule(IIntegrationModule module) {
		MODULES.add(module);
	}

}
