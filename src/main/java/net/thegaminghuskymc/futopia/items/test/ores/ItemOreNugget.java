package net.thegaminghuskymc.futopia.items.test.ores;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.items.test.ItemBase;
import net.thegaminghuskymc.futopia.items.test.Items;
import net.thegaminghuskymc.futopia.network.EnumOreType;
import net.thegaminghuskymc.futopia.network.EnumOres;
import net.thegaminghuskymc.futopia.utils.test.interfaces.IProvideRecipe;
import net.thegaminghuskymc.huskylib.utils.HLCraftingHelper;

public class ItemOreNugget extends ItemBase implements IProvideRecipe {
    public ItemOreNugget() {
        super("ores/nugget");
        this.setHasSubtypes(true);
        this.setCreativeTab(FTCreativeTabs.items);
        this.setInternalName("ore_nugget");
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
        for (int i = 0; i < EnumOres.values().length; i++) {
            if (EnumOres.byMeta(i).isTypeSet(EnumOreType.NUGGET)) {
                subItems.add(new ItemStack(this, 1, i));
            }
        }
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        String name = super.getUnlocalizedName();
        String oreName = EnumOres.byMeta(stack.getItemDamage()).getUnlocalizedName();
        return name + "." + oreName;
    }

    @Override
    public void registerItemRenderer() {
        for (int i = 0; i < EnumOres.values().length; i++) {
            if (EnumOres.byMeta(i).isTypeSet(EnumOreType.NUGGET)) {
                ModelLoader.setCustomModelResourceLocation(this, i, new ModelResourceLocation(Refs.MODID + ":ores/nugget-" + EnumOres.byMeta(i).getUnlocalizedName(), "inventory"));
            }
        }
    }

    @Override
    public void RegisterRecipes() {
        for (EnumOres ore : EnumOres.values()) {
            // Ingot -> 9x Nugget
            if (ore.isTypeSet(EnumOreType.INGOT) && ore.isTypeSet(EnumOreType.NUGGET)) {
            	HLCraftingHelper.addShapelessOreRecipe(Items.ITEM_ORE_NUGGET.getStack(9, ore.getMeta()), "ingot" + ore.getOreName());
            }

            // Iron Ingot -> 9x Iron Nuggets
            if (ore == EnumOres.IRON) {
            	HLCraftingHelper.addShapelessOreRecipe(Items.ITEM_ORE_NUGGET.getStack(9, ore.getMeta()), "ingotIron");
            }

            // Diamond -> 9x Diamond Nuggets
            if (ore == EnumOres.DIAMOND) {
            	HLCraftingHelper.addShapelessOreRecipe(Items.ITEM_ORE_NUGGET.getStack(9, ore.getMeta()), "gemDiamond");
            }
        }
    }
}