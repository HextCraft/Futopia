package net.thegaminghuskymc.futopia.items.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.huskylib.blocks.EnumBlock;

public class ItemBlockBase extends ItemBlock {

	public ItemBlockBase(Block block) {
		super(block);
		this.setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int damage) {
		return damage;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
		if (!isInCreativeTab(tab)) {
			return;
		}
		this.block.getSubBlocks(tab, subItems);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getUnlocalizedName(ItemStack stack) {
		if (this.block instanceof EnumBlock) {
			if (((EnumBlock) this.block).getSubNames() != null) {
				return this.getUnlocalizedName() + "." + ((EnumBlock) this.block).getSubNames()[stack.getMetadata()];
			} else {
				return super.getUnlocalizedName(stack);
			}
		} else {
			return super.getUnlocalizedName(stack);
		}
	}

}
