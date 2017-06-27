package net.thegaminghuskymc.futopia.blocks.test;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.futopia.blocks.test.ores.BlockAlloy;
import net.thegaminghuskymc.futopia.blocks.test.ores.BlockAlloyBlock;
import net.thegaminghuskymc.futopia.blocks.test.ores.BlockOre;
import net.thegaminghuskymc.futopia.blocks.test.ores.BlockOreBlock;
import net.thegaminghuskymc.futopia.items.test.ores.ItemAlloy;
import net.thegaminghuskymc.futopia.items.test.ores.ItemAlloyBlock;
import net.thegaminghuskymc.futopia.items.test.ores.ItemOre;
import net.thegaminghuskymc.futopia.items.test.ores.ItemOreBlock;
import net.thegaminghuskymc.futopia.utils.test.helpers.RegistrationHelper;

public enum Blocks {
    BLOCK_ORE(BlockOre.class, ItemOre.class),
    BLOCK_ALLOY(BlockAlloy.class, ItemAlloy.class),
    BLOCK_ORE_BLOCK(BlockOreBlock.class, ItemOreBlock.class),
    BLOCK_ALLOY_BLOCK(BlockAlloyBlock.class, ItemAlloyBlock.class),
    ;

    private final Class<? extends BlockBase> blockClass;
    private final Class<? extends ItemBlock> itemBlockClass;
    private Block block;

    Blocks(Class<? extends BlockBase> blockClass) {
        this(blockClass, ItemBlock.class);
    }

    Blocks(Class<? extends BlockBase> blockClass, Class<? extends ItemBlock> itemBlockClass) {
        this.blockClass = blockClass;
        this.itemBlockClass = itemBlockClass;
    }

    public static void registerBlocks() {
        for (Blocks block : Blocks.values()) {
            block.registerBlock();
        }
    }

    public ItemStack getStack() {
        return new ItemStack(block);
    }

    public ItemStack getStack(int size) {
        return new ItemStack(block, size);
    }

    public ItemStack getStack(int size, int meta) {
        return new ItemStack(block, size, meta);
    }

    public Block getBlock() {
        return this.block;
    }

    private void registerBlock() {
        block = RegistrationHelper.registerBlock(blockClass, itemBlockClass);
    }
}