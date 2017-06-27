package net.thegaminghuskymc.futopia.utils.test.helpers;

import java.util.Locale;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.registries.GameData;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.blocks.test.BlockBase;
import net.thegaminghuskymc.futopia.items.test.ItemBase;
import net.thegaminghuskymc.futopia.utils.test.Platform;
import net.thegaminghuskymc.futopia.utils.test.interfaces.IBlockRenderer;
import net.thegaminghuskymc.futopia.utils.test.interfaces.IItemRenderer;

public class RegistrationHelper {

    public static Block registerBlock(Class<? extends Block> blockClass) {
        return registerBlock(blockClass, ItemBlock.class);
    }

    public static Block registerBlock(Class<? extends Block> blockClass, Class<? extends ItemBlock> itemBlockClass) {
        Block block = null;
        ItemBlock itemBlock;
        String internalName;

        try {
            block = blockClass.getConstructor().newInstance();
            itemBlock = itemBlockClass.getConstructor(Block.class).newInstance(block);

            internalName = ((BlockBase) block).getInternalName();

            if (!internalName.equals(internalName.toLowerCase(Locale.US)))
                throw new IllegalArgumentException(String.format("Unlocalized names need to be all lowercase! Item: %s", internalName));

            if (internalName.isEmpty())
                throw new IllegalArgumentException(String.format("Unlocalized name cannot be blank! Item: %s", blockClass.getCanonicalName()));

            block.setRegistryName(Refs.MODID, internalName);
            block.setUnlocalizedName(internalName);
            itemBlock.setRegistryName(block.getRegistryName());

            GameData.register_impl(block);
            GameData.register_impl(itemBlock);

            if (block instanceof IBlockRenderer && Platform.isClient()) {
                ((IBlockRenderer) block).registerBlockRenderer();
                ((IBlockRenderer) block).registerBlockItemRenderer();
            }

            Futopia.LOGGER.info(String.format("Registered block (%s)", blockClass.getCanonicalName()));
        } catch (Exception ex) {
        	Futopia.LOGGER.warning(String.format("Fatal Error while registering block (%s)", blockClass.getCanonicalName()));
            ex.printStackTrace();
        }

        return block;
    }

    public static Item registerItem(Class<? extends Item> itemClass) {
        Item item = null;
        String internalName;

        try {
            item = itemClass.getConstructor().newInstance();

            internalName = ((ItemBase) item).getInternalName();

            if (!internalName.equals(internalName.toLowerCase(Locale.US)))
                throw new IllegalArgumentException(String.format("Unlocalized names need to be all lowercase! Item: %s", internalName));

            if (internalName.isEmpty())
                throw new IllegalArgumentException(String.format("Unlocalized name cannot be blank! Item: %s", itemClass.getCanonicalName()));

            item.setRegistryName(Refs.MODID, internalName);
            item.setUnlocalizedName(internalName);

            GameData.register_impl(item);

            if (item instanceof IItemRenderer && Platform.isClient()) {
                ((IItemRenderer) item).registerItemRenderer();
            }

            Futopia.LOGGER.info(String.format("Registered item (%s)", itemClass.getCanonicalName()));
        } catch (Exception ex) {
        	Futopia.LOGGER.warning(String.format("Fatal Error while registering item (%s)", itemClass.getCanonicalName()));
            ex.printStackTrace();
        }

        return item;
    }
}