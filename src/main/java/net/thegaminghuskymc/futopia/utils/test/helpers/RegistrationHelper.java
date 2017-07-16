package net.thegaminghuskymc.futopia.utils.test.helpers;

import java.util.Locale;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.blocks.test.BlockBase;

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
				throw new IllegalArgumentException(
						String.format("Unlocalized names need to be all lowercase! Item: %s", internalName));

			if (internalName.isEmpty())
				throw new IllegalArgumentException(
						String.format("Unlocalized name cannot be blank! Item: %s", blockClass.getCanonicalName()));

			block.setRegistryName(Refs.MODID, internalName);
			block.setUnlocalizedName(internalName);
			itemBlock.setRegistryName(block.getRegistryName());

			ForgeRegistries.BLOCKS.register(block);
			ForgeRegistries.ITEMS.register(itemBlock);

			Futopia.LOGGER.info(String.format("Registered block (%s)", blockClass.getCanonicalName()));
		} catch (Exception ex) {
			Futopia.LOGGER
					.warning(String.format("Fatal Error while registering block (%s)", blockClass.getCanonicalName()));
			ex.printStackTrace();
		}

		return block;
	}

}