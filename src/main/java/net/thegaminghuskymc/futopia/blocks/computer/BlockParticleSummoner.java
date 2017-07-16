package net.thegaminghuskymc.futopia.blocks.computer;

import java.util.List;

import cofh.core.util.helpers.StringHelper;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.client.gui.GuiHandler;
import net.thegaminghuskymc.futopia.utils.BlockNames;

public class BlockParticleSummoner extends BlockComputerBase {

	public BlockParticleSummoner() {
		super(BlockNames.PARTICLE_BLOCKNAME);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		if (worldIn.isRemote & !playerIn.isSneaking()) {
			playerIn.openGui(Futopia.INSTANCE, GuiHandler.PARTICLE_EMITTER, worldIn, pos.getX(), pos.getY(),
					pos.getZ());
		}

		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}

	@Override
	public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) {
		if (!StringHelper.isShiftKeyDown()) {
			tooltip.add("Hold " + StringHelper.getDeactivationText("Shift")
					+ StringHelper.getFlavorText(" for information."));
		} else {
			tooltip.add(StringHelper.getInfoText("This block is used to summon whatever particles you want"));
		}
	}

}
