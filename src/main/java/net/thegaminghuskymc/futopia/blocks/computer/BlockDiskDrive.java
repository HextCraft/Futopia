package net.thegaminghuskymc.futopia.blocks.computer;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.client.gui.GuiHandler;
import net.thegaminghuskymc.futopia.utils.BlockNames;

public class BlockDiskDrive extends BlockComputerBase {

	public BlockDiskDrive() {
		super(BlockNames.BLOCKDISKDRIVE_NAME);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		if (worldIn.isRemote && !playerIn.isSneaking()) {
			playerIn.openGui(Futopia.INSTANCE, GuiHandler.DISK_DRIVE, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}

		return false;
	}

}
