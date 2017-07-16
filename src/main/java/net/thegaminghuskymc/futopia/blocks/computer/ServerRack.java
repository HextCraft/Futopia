package net.thegaminghuskymc.futopia.blocks.computer;

import net.minecraft.block.material.Material;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.huskylib.blocks.BlockContainerBase;

public class ServerRack extends BlockContainerBase {

	public ServerRack() {
		super(Refs.MODID, "server_rack", Material.IRON, FTCreativeTabs.computer_parts);
	}

}