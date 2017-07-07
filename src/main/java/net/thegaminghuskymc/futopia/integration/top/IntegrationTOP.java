package net.thegaminghuskymc.futopia.integration.top;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thegaminghuskymc.futopia.integration.IIntegrationModule;

public class IntegrationTOP implements IIntegrationModule{

	@Override
	public String getName() {
		return "theoneprobe";
	}

	@Override
	public boolean isEnabled() {
		return Loader.isModLoaded(getName());
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		
	}

	@Override
	public void init(FMLInitializationEvent event) {
		
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		
	}

	@Override
	public void preInitClient(FMLPreInitializationEvent event) {
		
	}

	@Override
	public void initClient(FMLInitializationEvent event) {
		
	}

	@Override
	public void postInitClient(FMLPostInitializationEvent event) {
		
	}

}
