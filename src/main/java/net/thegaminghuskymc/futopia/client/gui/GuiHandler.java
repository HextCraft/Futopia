package net.thegaminghuskymc.futopia.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	
	public static final int GUIID_BASE = 0;
    public static final int GUIID_ENGINEERING_TABLE = GUIID_BASE + 0;
    public static final int GUIID_TANK = GUIID_BASE + 1;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
	}
	
	

}
