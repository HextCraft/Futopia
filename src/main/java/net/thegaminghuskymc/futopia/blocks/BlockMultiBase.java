package net.thegaminghuskymc.futopia.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.registries.GameData;
import net.thegaminghuskymc.futopia.Refs;

public class BlockMultiBase extends Block{

    public BlockMultiBase(String unlocolizedName, Material material, CreativeTabs creativeTab, String... subBlocks){
        super(material);
        setUnlocalizedName(unlocolizedName);
        setRegistryName(unlocolizedName);
        setCreativeTab(creativeTab);
        GameData.register_impl(new ItemBlock(this).setRegistryName(this.getRegistryName()));
        GameData.register_impl(this);
        registerRender(this);
    }

    public static void registerRender(Block block) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(Refs.MODID, block.getUnlocalizedName().substring(5)), "inventory"));
    }

}
