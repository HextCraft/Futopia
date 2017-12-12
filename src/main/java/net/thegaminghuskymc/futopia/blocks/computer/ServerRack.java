package net.thegaminghuskymc.futopia.blocks.computer;

import net.minecraft.block.material.Material;
import net.thegaminghuskymc.futopia.Reference;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.huskylib.blocks.BlockContainerBase;

public class ServerRack extends BlockContainerBase {

	public ServerRack() {
		super(Reference.MODID, "server_rack", Material.IRON, FTCreativeTabs.computer_parts);
	}

}