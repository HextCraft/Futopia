package net.thegaminghuskymc.futopia.utils;

import codechicken.lib.colour.Colour;
import codechicken.lib.util.ItemNBTUtils;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.thegaminghuskymc.futopia.init.FTBlocks2;

public class StackUtils {

	public static ItemStack getLanternStack(Colour glassColor, ItemStack frameMaterial) {
		ItemStack stack = new ItemStack(FTBlocks2.LANTERN, 1, 0);
		ItemNBTUtils.validateTagExists(stack);
		stack.getTagCompound().setInteger("glass_color", glassColor.rgba());
		stack.getTagCompound().setTag("frame_material", frameMaterial.writeToNBT(new NBTTagCompound()));
		return stack;
	}

}