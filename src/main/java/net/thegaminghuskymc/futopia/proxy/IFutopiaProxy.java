package net.thegaminghuskymc.futopia.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thegaminghuskymc.futopia.blocks.IModelRegister;

/**
 * Created by TheGamingHuskyMC on 26.05.2017.
 */
public interface IFutopiaProxy {
	
	void registerRenders();
	
	void registerTileEntities();

    void preInit(FMLPreInitializationEvent event);

    void init(FMLInitializationEvent event);

    void postInit(FMLPostInitializationEvent event);

    void registerItemRenderer(Item item, int meta, String id);

    boolean addIModelRegister(IModelRegister modelRegister);

}
