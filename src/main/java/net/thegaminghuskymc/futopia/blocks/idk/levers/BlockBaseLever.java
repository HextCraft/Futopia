package net.thegaminghuskymc.futopia.blocks.idk.levers;

import net.minecraft.block.BlockLever;
import net.thegaminghuskymc.futopia.Reference;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;

public class BlockBaseLever extends BlockLever {
	
	public BlockBaseLever(String name) {
		super();
		setUnlocalizedName(name + "_lever");
		setRegistryName(Reference.MODID, name + "_lever");
		setCreativeTab(FTCreativeTabs.main);
	}

}
