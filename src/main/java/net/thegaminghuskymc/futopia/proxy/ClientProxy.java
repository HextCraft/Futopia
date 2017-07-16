package net.thegaminghuskymc.futopia.proxy;

import java.util.ArrayList;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.blocks.IModelRegister;
import net.thegaminghuskymc.futopia.init.FTBlocks;
import net.thegaminghuskymc.futopia.init.FTItems;

public class ClientProxy extends CommonProxy implements IFutopiaProxy {

	private static ArrayList<IModelRegister> modelList = new ArrayList<>();

	@Override
	public void registerRenders() {
		FTBlocks.registerRenders();
		FTItems.registerRenders();
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		for (IModelRegister register : modelList) {
			register.registerModels();
		}

		FTBlocks.init();
		FTItems.init();
	}

	@Override
	public void init(FMLInitializationEvent event) {
		
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		
	}

	@Override
	public void registerItemRenderer(Item item, int meta, String id) {

	}

	@Override
	public boolean addIModelRegister(IModelRegister modelRegister) {
		return modelList.add(modelRegister);
	}

}
