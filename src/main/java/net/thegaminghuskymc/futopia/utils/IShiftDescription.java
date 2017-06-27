package net.thegaminghuskymc.futopia.utils;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IShiftDescription {

    boolean shouldAddTooltip(ItemStack stack, World player);

    void addDescription(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced);

}
