package net.thegaminghuskymc.futopia.events;


import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.thegaminghuskymc.futopia.Refs;

public class FTRecipeHandler {

	@SuppressWarnings("rawtypes")
	private static List<IForgeRegistryEntry> hiddenEntrys = new ArrayList<>();

	public static void hideEntry(IForgeRegistryEntry<?> entry){
		hiddenEntrys.add(entry);
	}

	/*@SubscribeEvent
	public void pickupEvent(EntityItemPickupEvent entityItemPickupEvent){
		if(entityItemPickupEvent.getEntityPlayer() instanceof EntityPlayerMP){
			if(ItemUtils.isInputEqual("logWood", entityItemPickupEvent.getItem().getItem(), false, false, true)){
				for(IRecipe recipe : CraftingManager.REGISTRY){
					if(recipe.getRecipeOutput().getItem() == FTItems.){
						entityItemPickupEvent.getEntityPlayer().unlockRecipes(Collections.singletonList(recipe));
					}
				}
			}
		}
	}*/

	public static void unlockTRRecipes(EntityPlayerMP playerMP){
		List<IRecipe> recipeList = new ArrayList<>();
		for(IRecipe recipe : CraftingManager.REGISTRY){
			if(isRecipeValid(recipe)){
				recipeList.add(recipe);
			}
		}
		playerMP.unlockRecipes(recipeList);
	}

	private static boolean isRecipeValid(IRecipe recipe){
		if(recipe.getRegistryName() == null){
			return false;
		}
		if(!recipe.getRegistryName().getResourceDomain().equals(Refs.MODID)){
			return false;
		}
		if(!recipe.getRecipeOutput().getItem().getRegistryName().getResourceDomain().equals(Refs.MODID)){
			return false;
		}
		if(hiddenEntrys.contains(recipe.getRecipeOutput().getItem())){
			return false;
		}
		return true;
	}

}
