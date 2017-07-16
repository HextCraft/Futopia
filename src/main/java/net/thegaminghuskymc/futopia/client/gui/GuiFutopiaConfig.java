package net.thegaminghuskymc.futopia.client.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.Refs;

public class GuiFutopiaConfig extends GuiConfig{
	
	public GuiFutopiaConfig(GuiScreen parentScreen) {
	    super(parentScreen, Refs.MODID, true, false, "Futopia Configs", Futopia.config.getClass());
	}

}
