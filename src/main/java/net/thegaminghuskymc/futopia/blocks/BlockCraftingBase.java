package net.thegaminghuskymc.futopia.blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.Reference;
import net.thegaminghuskymc.futopia.client.gui.GuiHandler;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.tiles.TileCraftingBase;
import net.thegaminghuskymc.huskylib.blocks.BlockMachineBase;

public class BlockCraftingBase extends BlockMachineBase {

	public BlockCraftingBase(String name) {
		super(Reference.MODID, name, new TileCraftingBase(), FTCreativeTabs.machines);
	}

	/**
	 * Called when the block is right clicked by a player.
	 */
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (worldIn.isRemote & !playerIn.isSneaking()) {
			playerIn.openGui(Futopia.INSTANCE, GuiHandler.PROJECT_TABLE, worldIn, pos.getX(), pos.getY(), pos.getZ());
			return true;
		}
		return false;
	}

}
