package net.thegaminghuskymc.futopia.blocks;

import java.util.List;

import cofh.core.util.helpers.StringHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.tiles.TileEntityMachineBase;
import net.thegaminghuskymc.futopia.utils.Names;
import net.thegaminghuskymc.huskylib.blocks.BlockMachineBase;

public class BlockGeneratorBase extends BlockMachineBase{

	public BlockGeneratorBase(String name) {
		super(Refs.MODID, name + "_generator", new TileEntityMachineBase(), FTCreativeTabs.machines);
	}
	
	public BlockGeneratorBase(String name, TileEntity te) {
		super(Refs.MODID, name + "_generator", te, FTCreativeTabs.machines);
	}
	
	@Override
    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) {
        if (!StringHelper.isShiftKeyDown()) {
            tooltip.add(Names.HelpToolTips.SHIFT_FOR_INFO);
        } else {
        	tooltip.add(Names.CraftingToolTips.GENERATOR);
        }
    }

}
