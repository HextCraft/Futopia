package cofh.core.util.crafting;

import cofh.lib.util.helpers.ItemHelper;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class RecipeUpgrade extends ShapedOreRecipe {

	int targetSlot = 4;

	public RecipeUpgrade(ResourceLocation rl, ItemStack result, Object... recipe) {

		super(rl, result, recipe);
	}

	public RecipeUpgrade(ResourceLocation rl, int slot, ItemStack result, Object... recipe) {

		super(rl, result, recipe);
		targetSlot = slot;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting craftMatrix) {

		if (craftMatrix.getStackInSlot(targetSlot) == null || craftMatrix.getStackInSlot(targetSlot).getTagCompound() == null) {
			return super.getCraftingResult(craftMatrix);
		}
		return ItemHelper.copyTag(getRecipeOutput().copy(), craftMatrix.getStackInSlot(targetSlot));
	}

}
