package net.thegaminghuskymc.futopia.integration;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IIntegrationModule {

    String getName();

    boolean isEnabled();

    void preInit(FMLPreInitializationEvent event);

    void init(FMLInitializationEvent event);

    void postInit(FMLPostInitializationEvent event);

    @SideOnly(Side.CLIENT)
    void preInitClient(FMLPreInitializationEvent event);

    @SideOnly(Side.CLIENT)
    void initClient(FMLInitializationEvent event);

    @SideOnly(Side.CLIENT)
    void postInitClient(FMLPostInitializationEvent event);

}
