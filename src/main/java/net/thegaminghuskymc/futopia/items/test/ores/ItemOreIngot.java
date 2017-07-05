package net.thegaminghuskymc.futopia.items.test.ores;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.blocks.test.Blocks;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.items.test.ItemBase;
import net.thegaminghuskymc.futopia.items.test.Items;
import net.thegaminghuskymc.futopia.network.EnumOreType;
import net.thegaminghuskymc.futopia.network.EnumOres;
import net.thegaminghuskymc.futopia.utils.test.interfaces.IProvideRecipe;
import net.thegaminghuskymc.futopia.utils.test.interfaces.IProvideSmelting;
import net.thegaminghuskymc.huskylib.utils.HLCraftingHelper;

public class ItemOreIngot extends ItemBase implements IProvideRecipe, IProvideSmelting {
	
    public ItemOreIngot() {
        super("ores/ingot");
        this.setHasSubtypes(true);
        this.setCreativeTab(FTCreativeTabs.items);
        this.setInternalName("ore_ingot");
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
        for (int i = 0; i < EnumOres.values().length; i++) {
            if (EnumOres.byMeta(i).isTypeSet(EnumOreType.INGOT)) {
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
            if (EnumOres.byMeta(i).isTypeSet(EnumOreType.INGOT)) {
                ModelLoader.setCustomModelResourceLocation(this, i, new ModelResourceLocation(Refs.MODID + ":ores/ingot-" + EnumOres.byMeta(i).getUnlocalizedName(), "inventory"));
            }
        }
    }

    @Override
    public void RegisterRecipes() {
        for (EnumOres ore : EnumOres.values()) {
            // Block -> 9x Ingots
            if (ore.isTypeSet(EnumOreType.INGOT) && ore.isTypeSet(EnumOreType.BLOCK)) {
            	HLCraftingHelper.addShapelessOreRecipe(Items.ITEM_ORE_INGOT.getStack(9, ore.getMeta()), "block" + ore.getOreName());
            }

            // 9x Nuggets -> Ingot
            if (ore.isTypeSet(EnumOreType.INGOT) && ore.isTypeSet(EnumOreType.NUGGET)) {
            	HLCraftingHelper.addShapedOreRecipe(Items.ITEM_ORE_INGOT.getStack(1, ore.getMeta()),
                        "xxx",
                        "xxx",
                        "xxx",
                        'x', "nugget" + ore.getOreName()
                );
            }

            // 9x Iron Nuggets -> Iron Ingot
            if (ore == EnumOres.IRON) {
            	HLCraftingHelper.addShapedOreRecipe(new ItemStack(net.minecraft.init.Items.IRON_INGOT),
                        "xxx",
                        "xxx",
                        "xxx",
                        'x', "nugget" + ore.getOreName()
                );
            }

            // 9x Diamond Nuggets -> Diamond
            if (ore == EnumOres.DIAMOND) {
            	HLCraftingHelper.addShapedOreRecipe(new ItemStack(net.minecraft.init.Items.DIAMOND),
                        "xxx",
                        "xxx",
                        "xxx",
                        'x', "nugget" + ore.getOreName()
                );
            }
        }
    }

    @Override
    public void RegisterSmelting() {
        for (int i = 0; i < EnumOres.values().length; i++) {
            // Register Ore -> Ingot
            if (EnumOres.byMeta(i).isTypeSet(EnumOreType.ORE) && EnumOres.byMeta(i).isTypeSet(EnumOreType.INGOT))
            	HLCraftingHelper.addSmelting(Blocks.BLOCK_ORE.getStack(1, i), Items.ITEM_ORE_INGOT.getStack(1, i), 0);

            // Register Dust -> Ingot
            if (EnumOres.byMeta(i).isTypeSet(EnumOreType.DUST) && EnumOres.byMeta(i).isTypeSet(EnumOreType.INGOT))
            	HLCraftingHelper.addSmelting(Items.ITEM_ORE_DUST.getStack(1, i), Items.ITEM_ORE_INGOT.getStack(1, i), 0);
        }
    }
}