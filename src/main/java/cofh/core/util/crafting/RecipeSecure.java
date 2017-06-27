package cofh.core.util.crafting;

import cofh.core.util.helpers.SecurityHelper;
import cofh.lib.util.helpers.ItemHelper;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class RecipeSecure extends ShapedOreRecipe {

	int targetSlot = 4;

	public RecipeSecure(ResourceLocation rl, ItemStack result, Object... recipe) {

		super(rl, result, recipe);
	}

	public RecipeSecure(ResourceLocation rl, int slot, ItemStack result, Object... recipe) {

		super(rl, result, recipe);
		targetSlot = slot;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting craftMatrix) {

		if (SecurityHelper.isSecure(craftMatrix.getStackInSlot(targetSlot))) {
			return null;
		}
		if (craftMatrix.getStackInSlot(targetSlot) == null) {
			return super.getCraftingResult(craftMatrix);
		}
		ItemStack secureStack = ItemHelper.copyTag(getRecipeOutput().copy(), craftMatrix.getStackInSlot(targetSlot));
		return SecurityHelper.setSecure(secureStack);
	}

}
