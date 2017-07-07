package net.thegaminghuskymc.futopia.integration;

import net.minecraftforge.fml.common.Loader;
import net.thegaminghuskymc.futopia.integration.tinkers.IntegrationTinkers;
import net.thegaminghuskymc.futopia.integration.top.IntegrationTOP;
import net.thegaminghuskymc.futopia.integration.waila.IntegrationWaila;

public class FutopiaIntegrations {

    private static final String MODID_WAILA = "Waila";
    private static final String MODID_TOP = "theoneprobe";
    private static final String MODID_TINKERS = "tconstruct";

    public static void preInit(){
    	
    	if(Loader.isModLoaded(MODID_TINKERS)){
            IntegrationHandler.INSTANCE.registerModule(new IntegrationTinkers());
        }
    	if(Loader.isModLoaded(MODID_WAILA)){
            IntegrationHandler.INSTANCE.registerModule(new IntegrationWaila());
        }
    	if(Loader.isModLoaded(MODID_TOP)){
            IntegrationHandler.INSTANCE.registerModule(new IntegrationTOP());
        }
    	
    }

}
