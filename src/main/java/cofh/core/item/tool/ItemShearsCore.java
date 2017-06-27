package cofh.core.item.tool;

import cofh.lib.util.helpers.ItemHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.List;

public class ItemShearsCore extends ItemShears {

	protected String repairIngot = "";
	protected ToolMaterial toolMaterial;

	protected boolean showInCreative = true;

	public ItemShearsCore(ToolMaterial toolMaterial) {

		super();
		this.toolMaterial = toolMaterial;
		this.setMaxDamage(toolMaterial.getMaxUses() - 12);
	}

	public ItemShearsCore setRepairIngot(String repairIngot) {

		this.repairIngot = repairIngot;
		return this;
	}

	public ItemShearsCore setShowInCreative(boolean showInCreative) {

		this.showInCreative = showInCreative;
		return this;
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
		if(!isInCreativeTab(tab)){
    		return;
    	}
		if (showInCreative) {
			list.add(new ItemStack(this, 1, 0));
		}
	}

	@Override
	public boolean getIsRepairable(ItemStack itemToRepair, ItemStack stack) {

		return ItemHelper.isOreNameEqual(stack, repairIngot);
	}

}
