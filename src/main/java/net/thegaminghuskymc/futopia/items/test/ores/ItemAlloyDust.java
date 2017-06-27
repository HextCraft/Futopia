package net.thegaminghuskymc.futopia.items.test.ores;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;
import net.thegaminghuskymc.futopia.items.test.ItemBase;
import net.thegaminghuskymc.futopia.network.EnumAlloys;
import net.thegaminghuskymc.futopia.network.EnumOreType;

public class ItemAlloyDust extends ItemBase {

    public ItemAlloyDust() {
        super("ores/dust");
        this.setHasSubtypes(true);
        this.setCreativeTab(FTCreativeTabs.materials);
        this.setInternalName("alloy_dust");
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
        for (int i = 0; i < EnumAlloys.values().length; i++) {
            if (EnumAlloys.byMeta(i).isTypeSet(EnumOreType.DUST)) {
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
        String oreName = EnumAlloys.byMeta(stack.getItemDamage()).getUnlocalizedName();
        return name + "." + oreName;
    }

    @Override
    public void registerItemRenderer() {
        for (int i = 0; i < EnumAlloys.values().length; i++) {
            if (EnumAlloys.byMeta(i).isTypeSet(EnumOreType.DUST)) {
                ModelLoader.setCustomModelResourceLocation(this, i, new ModelResourceLocation(Refs.MODID + ":ores/dust-" + EnumAlloys.byMeta(i).getUnlocalizedName(), "inventory"));
            }
        }
    }
}