package net.thegaminghuskymc.futopia.blocks.machine;

import java.util.List;

import cofh.lib.util.helpers.StringHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.thegaminghuskymc.futopia.blocks.BlockMachineBase;
import net.thegaminghuskymc.futopia.utils.BlockNames;

public class BlockParticleSummoner extends BlockMachineBase {

    public BlockParticleSummoner() {
        super(BlockNames.PARTICLE_BLOCKNAME);
    }

    @Override
    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) {
        if (!StringHelper.isShiftKeyDown()) {
            tooltip.add("Hold " + StringHelper.getDeactivationText("Shift") + StringHelper.getFlavorText(" for information."));
        } else {
            tooltip.add(StringHelper.getInfoText("This block is used to summon whatever particles you want"));
        }
    }

}
