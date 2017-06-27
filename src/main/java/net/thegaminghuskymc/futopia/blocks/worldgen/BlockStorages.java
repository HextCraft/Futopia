package net.thegaminghuskymc.futopia.blocks.worldgen;

import cofh.core.block.BlockCore;
import net.minecraft.block.material.Material;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.blocks.IInitializer;
import net.thegaminghuskymc.futopia.blocks.IModelRegister;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;

public class BlockStorages extends BlockCore implements IInitializer, IModelRegister {

	public BlockStorages() {
		super(Material.IRON, Refs.MODID);
		setUnlocalizedName("storages");
		setRegistryName("storages");
		setCreativeTab(FTCreativeTabs.main);
	}

	@Override
	public void registerModels() {
		
	}

	@Override
	public boolean preInit() {
		return false;
	}

	@Override
	public boolean initialize() {
		return false;
	}

	@Override
	public boolean postInit() {
		return false;
	}

}
