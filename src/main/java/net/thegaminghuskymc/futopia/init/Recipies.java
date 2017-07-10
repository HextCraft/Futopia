package net.thegaminghuskymc.futopia.init;

import cofh.core.util.helpers.RecipeHelper;
import net.minecraft.block.Block;
import net.minecraft.client.util.RecipeItemHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.thegaminghuskymc.futopia.network.EnumMaterialType;
import net.thegaminghuskymc.huskylib.utils.HLCraftingHelper;

@SuppressWarnings("unused")
public class Recipies {

    public static void init() {
        addSawRecipes();
        addHammerRecipes();
        addDustRecipes();
        addPlateRecipes();
        addBlockRecipes();
        addItemRecipes();
    }

    private static void addSawRecipes() {
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.RED.ordinal()), "alloyFutopiaRed");
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.BLUE.ordinal()), "alloyFutopiaBlue");
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.PURPLE.ordinal()), "alloyFutopiaPurple");
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.GREEN.ordinal()), "alloyFutopiaGreen");
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.ZINC.ordinal()), "alloyFutopiaZinc");
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.TUNGSTEN.ordinal()), "alloyFutopiaTungsten");
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.BRASS.ordinal()), "alloyFutopiaBrass");
        addSawRecipe(new ItemStack(FTItems.saw, 1, EnumMaterialType.TESSELITE.ordinal()), "alloyFutopiaTesselite");
    }

    private static void addHammerRecipes() {
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.RED.ordinal()), "alloyFutopiaRed");
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.BLUE.ordinal()), "alloyFutopiaBlue");
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.PURPLE.ordinal()), "alloyFutopiaPurple");
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.GREEN.ordinal()), "alloyFutopiaGreen");
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.ZINC.ordinal()), "alloyFutopiaZinc");
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.TUNGSTEN.ordinal()), "alloyFutopiaTungsten");
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.BRASS.ordinal()), "alloyFutopiaBrass");
        addHammerRecipe(new ItemStack(FTItems.hammer, 1, EnumMaterialType.TESSELITE.ordinal()), "alloyFutopiaTesselite");
    }

    private static void addPlateRecipes() {
        addPlateRecipe(new ItemStack(FTItems.plates, 1, EnumMaterialType.RED.ordinal()),  "alloyFutopiaRed");
        addPlateRecipe(new ItemStack(FTItems.plates, 1, EnumMaterialType.BLUE.ordinal()),  "alloyFutopiaBlue");
        addPlateRecipe(new ItemStack(FTItems.plates, 1, EnumMaterialType.PURPLE.ordinal()), "alloyFutopiaPurple");
        addPlateRecipe(new ItemStack(FTItems.plates, 1, EnumMaterialType.GREEN.ordinal()), "alloyFutopiaGreen");
        addPlateRecipe(new ItemStack(FTItems.plates, 1, EnumMaterialType.ZINC.ordinal()), "alloyFutopiaZinc");
        addPlateRecipe(new ItemStack(FTItems.plates, 1, EnumMaterialType.TUNGSTEN.ordinal()),  "alloyFutopiaTungsten");
        addPlateRecipe(new ItemStack(FTItems.plates, 1, EnumMaterialType.BRASS.ordinal()),  "alloyFutopiaBrass");
        addPlateRecipe(new ItemStack(FTItems.plates, 1, EnumMaterialType.TESSELITE.ordinal()), "alloyFutopiaTesselite");
    }

    private static void addDustRecipes() {
        addDustRecipe(new ItemStack(FTItems.dusts, 4, EnumMaterialType.RED.ordinal()), "alloyFutopiaRed");
        addDustRecipe(new ItemStack(FTItems.dusts, 4, EnumMaterialType.BLUE.ordinal()), "alloyFutopiaBlue");
        addDustRecipe(new ItemStack(FTItems.dusts, 4, EnumMaterialType.PURPLE.ordinal()),"alloyFutopiaPurple");
        addDustRecipe(new ItemStack(FTItems.dusts, 4, EnumMaterialType.GREEN.ordinal()), "alloyFutopiaGreen");
        addDustRecipe(new ItemStack(FTItems.dusts, 4, EnumMaterialType.ZINC.ordinal()), "alloyFutopiaZinc");
        addDustRecipe(new ItemStack(FTItems.dusts, 4, EnumMaterialType.TUNGSTEN.ordinal()), "alloyFutopiaTungsten");
        addDustRecipe(new ItemStack(FTItems.dusts, 4, EnumMaterialType.BRASS.ordinal()), "alloyFutopiaBrass");
        addDustRecipe(new ItemStack(FTItems.dusts, 4, EnumMaterialType.TESSELITE.ordinal()), "alloyFutopiaTesselite");
    }

    private static void addNuggetRecipes() {
        addNuggetRecipe(new ItemStack(FTItems.nuggets, 4, EnumMaterialType.RED.ordinal()), "alloyFutopiaRed");
        addNuggetRecipe(new ItemStack(FTItems.nuggets, 4, EnumMaterialType.BLUE.ordinal()), "alloyFutopiaBlue");
        addNuggetRecipe(new ItemStack(FTItems.nuggets, 4, EnumMaterialType.PURPLE.ordinal()),"alloyFutopiaPurple");
        addNuggetRecipe(new ItemStack(FTItems.nuggets, 4, EnumMaterialType.GREEN.ordinal()), "alloyFutopiaGreen");
        addNuggetRecipe(new ItemStack(FTItems.nuggets, 4, EnumMaterialType.ZINC.ordinal()), "alloyFutopiaZinc");
        addNuggetRecipe(new ItemStack(FTItems.nuggets, 4, EnumMaterialType.TUNGSTEN.ordinal()), "alloyFutopiaTungsten");
        addNuggetRecipe(new ItemStack(FTItems.nuggets, 4, EnumMaterialType.BRASS.ordinal()), "alloyFutopiaBrass");
        addNuggetRecipe(new ItemStack(FTItems.nuggets, 4, EnumMaterialType.TESSELITE.ordinal()), "alloyFutopiaTesselite");
    }

    private static void addItemRecipes() {
        addGearRecipe(new ItemStack(FTItems.gears, 1, EnumMaterialType.RED.ordinal()), "alloyFutopiaRed");
        addGearRecipe(new ItemStack(FTItems.gears, 1, EnumMaterialType.BLUE.ordinal()), "alloyFutopiaBlue");
        addGearRecipe(new ItemStack(FTItems.gears, 1, EnumMaterialType.PURPLE.ordinal()), "alloyFutopiaPurple");
        addGearRecipe(new ItemStack(FTItems.gears, 1, EnumMaterialType.GREEN.ordinal()), "alloyFutopiaGreen");
        addGearRecipe(new ItemStack(FTItems.gears, 1, EnumMaterialType.ZINC.ordinal()), "alloyFutopiaZinc");
        addGearRecipe(new ItemStack(FTItems.gears, 1, EnumMaterialType.TUNGSTEN.ordinal()), "alloyFutopiaTungsten");
        addGearRecipe(new ItemStack(FTItems.gears, 1, EnumMaterialType.BRASS.ordinal()), "alloyFutopiaBrass");
        addGearRecipe(new ItemStack(FTItems.gears, 1, EnumMaterialType.TESSELITE.ordinal()), "alloyFutopiaTesselite");
    	
        addSmelting(new ItemStack(FTItems.dusts, 9, EnumMaterialType.RED.ordinal()), new ItemStack(FTItems.ingots, 1, EnumMaterialType.RED.ordinal()), 0.0F);
        addSmelting(new ItemStack(FTItems.dusts, 9, EnumMaterialType.BLUE.ordinal()), new ItemStack(FTItems.ingots, 1, EnumMaterialType.BLUE.ordinal()), 0.0F);
        addSmelting(new ItemStack(FTItems.dusts, 9, EnumMaterialType.PURPLE.ordinal()), new ItemStack(FTItems.ingots, 1, EnumMaterialType.PURPLE.ordinal()), 0.0F);
        addSmelting(new ItemStack(FTItems.dusts, 9, EnumMaterialType.GREEN.ordinal()), new ItemStack(FTItems.ingots, 1, EnumMaterialType.GREEN.ordinal()), 0.0F);
        addSmelting(new ItemStack(FTItems.dusts, 9, EnumMaterialType.ZINC.ordinal()), new ItemStack(FTItems.ingots, 1, EnumMaterialType.ZINC.ordinal()), 0.0F);
        addSmelting(new ItemStack(FTItems.dusts, 9, EnumMaterialType.TUNGSTEN.ordinal()), new ItemStack(FTItems.ingots, 1, EnumMaterialType.TUNGSTEN.ordinal()), 0.0F);
        addSmelting(new ItemStack(FTItems.dusts, 9, EnumMaterialType.BRASS.ordinal()), new ItemStack(FTItems.ingots, 1, EnumMaterialType.BRASS.ordinal()), 0.0F);
        addSmelting(new ItemStack(FTItems.dusts, 9, EnumMaterialType.TESSELITE.ordinal()), new ItemStack(FTItems.ingots, 1, EnumMaterialType.TESSELITE.ordinal()), 0.0F);
    }

    private static void addBlockRecipes() {
    	addBlockRecipe(new ItemStack(FTBlocks.particleSummoner), new Object[]{ "RBG", "GRB", "BGR", 'B', "alloyFutopiaBlue",
                'R', "alloyFutopiaRed", 'G', "alloyFutopiaGreen"});

    	RecipeHelper.addSmelting(new ItemStack(FTBlocks.ores, 1, EnumMaterialType.RED.ordinal()), new ItemStack(FTItems.ingots, 1, EnumMaterialType.RED.ordinal()), 0.0F);
    	RecipeHelper.addSmelting(new ItemStack(FTBlocks.ores, 1, EnumMaterialType.BLUE.ordinal()), new ItemStack(FTItems.ingots, 1, EnumMaterialType.BLUE.ordinal()), 0.0F);
    	RecipeHelper.addSmelting(new ItemStack(FTBlocks.ores, 1, EnumMaterialType.PURPLE.ordinal()), new ItemStack(FTItems.ingots, 1, EnumMaterialType.PURPLE.ordinal()), 0.0F);
    	RecipeHelper.addSmelting(new ItemStack(FTBlocks.ores, 1, EnumMaterialType.GREEN.ordinal()), new ItemStack(FTItems.ingots, 1, EnumMaterialType.GREEN.ordinal()), 0.0F);
    	RecipeHelper.addSmelting(new ItemStack(FTBlocks.ores, 1, EnumMaterialType.ZINC.ordinal()), new ItemStack(FTItems.ingots, 1, EnumMaterialType.ZINC.ordinal()), 0.0F);
    	RecipeHelper.addSmelting(new ItemStack(FTBlocks.ores, 1, EnumMaterialType.TUNGSTEN.ordinal()), new ItemStack(FTItems.ingots, 1, EnumMaterialType.TUNGSTEN.ordinal()), 0.0F);
    	RecipeHelper.addSmelting(new ItemStack(FTBlocks.ores, 1, EnumMaterialType.BRASS.ordinal()), new ItemStack(FTItems.ingots, 1, EnumMaterialType.BRASS.ordinal()), 0.0F);
    	RecipeHelper.addSmelting(new ItemStack(FTBlocks.ores, 1, EnumMaterialType.TESSELITE.ordinal()), new ItemStack(FTItems.ingots, 1, EnumMaterialType.TESSELITE.ordinal()), 0.0F);

        RecipeHelper.addStorageRecipe(new ItemStack(FTBlocks.storages, 1, EnumMaterialType.RED.ordinal()), new ItemStack(FTItems.ingots, 1, EnumMaterialType.RED.ordinal()));
        RecipeHelper.addStorageRecipe(new ItemStack(FTBlocks.storages, 1, EnumMaterialType.BLUE.ordinal()), new ItemStack(FTItems.ingots, 1, EnumMaterialType.BLUE.ordinal()));
        RecipeHelper.addStorageRecipe(new ItemStack(FTBlocks.storages, 1, EnumMaterialType.PURPLE.ordinal()), new ItemStack(FTItems.ingots, 1, EnumMaterialType.PURPLE.ordinal()));
        RecipeHelper.addStorageRecipe(new ItemStack(FTBlocks.storages, 1, EnumMaterialType.GREEN.ordinal()), new ItemStack(FTItems.ingots, 1, EnumMaterialType.GREEN.ordinal()));
        RecipeHelper.addStorageRecipe(new ItemStack(FTBlocks.storages, 1, EnumMaterialType.ZINC.ordinal()), new ItemStack(FTItems.ingots, 1, EnumMaterialType.ZINC.ordinal()));
        RecipeHelper.addStorageRecipe(new ItemStack(FTBlocks.storages, 1, EnumMaterialType.TUNGSTEN.ordinal()), new ItemStack(FTItems.ingots, 1, EnumMaterialType.TUNGSTEN.ordinal()));
        RecipeHelper.addStorageRecipe(new ItemStack(FTBlocks.storages, 1, EnumMaterialType.BRASS.ordinal()), new ItemStack(FTItems.ingots, 1, EnumMaterialType.BRASS.ordinal()));
        RecipeHelper.addStorageRecipe(new ItemStack(FTBlocks.storages, 1, EnumMaterialType.TESSELITE.ordinal()), new ItemStack(FTItems.ingots, 1, EnumMaterialType.TESSELITE.ordinal()));
        
        RecipeHelper.addReverseStorageRecipe(new ItemStack(FTItems.ingots, 1, EnumMaterialType.RED.ordinal()), new ItemStack(FTBlocks.storages, 1, EnumMaterialType.RED.ordinal()));
        RecipeHelper.addReverseStorageRecipe(new ItemStack(FTItems.ingots, 1, EnumMaterialType.BLUE.ordinal()), new ItemStack(FTBlocks.storages, 1, EnumMaterialType.BLUE.ordinal()));
        RecipeHelper.addReverseStorageRecipe(new ItemStack(FTItems.ingots, 1, EnumMaterialType.PURPLE.ordinal()), new ItemStack(FTBlocks.storages, 1, EnumMaterialType.PURPLE.ordinal()));
        RecipeHelper.addReverseStorageRecipe(new ItemStack(FTItems.ingots, 1, EnumMaterialType.GREEN.ordinal()), new ItemStack(FTBlocks.storages, 1, EnumMaterialType.GREEN.ordinal()));
        RecipeHelper.addReverseStorageRecipe(new ItemStack(FTItems.ingots, 1, EnumMaterialType.ZINC.ordinal()), new ItemStack(FTBlocks.storages, 1, EnumMaterialType.ZINC.ordinal()));
        RecipeHelper.addReverseStorageRecipe(new ItemStack(FTItems.ingots, 1, EnumMaterialType.TUNGSTEN.ordinal()), new ItemStack(FTBlocks.storages, 1, EnumMaterialType.TUNGSTEN.ordinal()));
        RecipeHelper.addReverseStorageRecipe(new ItemStack(FTItems.ingots, 1, EnumMaterialType.BRASS.ordinal()), new ItemStack(FTBlocks.storages, 1, EnumMaterialType.BRASS.ordinal()));
        RecipeHelper.addReverseStorageRecipe(new ItemStack(FTItems.ingots, 1, EnumMaterialType.TESSELITE.ordinal()), new ItemStack(FTBlocks.storages, 1, EnumMaterialType.TESSELITE.ordinal()));
    }
    
    private static void addBlockRecipe(Block block, String material){
    	HLCraftingHelper.addShapedOreRecipe(new ItemStack(block), new Object[]{ "AAA", "AAA", "AAA", 'A', material}); 
    }
    
    private static void addBlockRecipe(ItemStack out, Object[] recipe){
    	HLCraftingHelper.addShapedOreRecipe(out, recipe); 
    }
    
    private static void addBlockRecipe(Block block, Item material){
    	HLCraftingHelper.addShapedOreRecipe(new ItemStack(block), new Object[]{ "AAA", "AAA", "AAA", 'A', material}); 
    }
    
    private static void addBlockRecipe(ItemStack material, ItemStack block){
    	HLCraftingHelper.addShapedOreRecipe(block, new Object[]{ "AAA", "AAA", "AAA", 'A', material}); 
    }

    private static void addToolsetRecipe(Item[] toolset, String material) {
    	HLCraftingHelper.addShapedOreRecipe(new ItemStack(toolset[0]), " X ", " X ", " C ", 'X', material, 'C', Items.STICK);
    	HLCraftingHelper.addShapedOreRecipe(new ItemStack(toolset[1]), "XXX", " C ", " C ", 'X', material, 'C', Items.STICK);
    	HLCraftingHelper.addShapedOreRecipe(new ItemStack(toolset[2]), " X ", " C ", " C ", 'X', material, 'C', Items.STICK);
    	HLCraftingHelper.addShapedOreRecipe(new ItemStack(toolset[3]), "XX ", "XC ", " C ", 'X', material, 'C', Items.STICK);
    	HLCraftingHelper.addShapedOreRecipe(new ItemStack(toolset[4]), "XX ", " C ", " C ", 'X', material, 'C', Items.STICK);
    }

	private static void addGearRecipe(ItemStack gear, String material){
		HLCraftingHelper.addShapedOreRecipe(gear, " X ", "XCX", " X ", 'X', material, 'C', Items.IRON_INGOT);
    }

    private static void addPlateRecipe(ItemStack plates, String material){
    	HLCraftingHelper.addShapedOreRecipe(plates, "XX ", "XX ", 'X', material);
    }
    
    private static void addPlateRecipe(ItemStack plates, Item material){
    	HLCraftingHelper.addShapedOreRecipe(plates, "XX ", "XX ", 'X', material);
    }

    private static void addDustRecipe(ItemStack dusts, String material){
    	HLCraftingHelper.addShapedOreRecipe(dusts, " X ", 'X', material);
    }

    private static void addNuggetRecipe(ItemStack nuggets, String material){
    	HLCraftingHelper.addShapedOreRecipe(nuggets, " X ", 'X', material);
    }

    private static void addHammerRecipe(ItemStack hammers, String material){
    	HLCraftingHelper.addShapedOreRecipe(hammers, "XCX", "XCX", " C ",  'X', material, 'C', Items.STICK);
    }

    private static void addSawRecipe(ItemStack saws, String material){
    	Block P = Blocks.PLANKS;
    	HLCraftingHelper.addShapedOreRecipe(saws, new Object[]{ "XX ", " XP", "  P",  'X', material, 'P', P});
    }

    private static void addArmorsetRecipe(Item[] armorset, String material) {
    	HLCraftingHelper.addShapedOreRecipe(new ItemStack(armorset[0]), "XXX", "X X", "   ", 'X', material);
    	HLCraftingHelper.addShapedOreRecipe(new ItemStack(armorset[1]), "X X", "XXX", "XXX", 'X', material);
    	HLCraftingHelper.addShapedOreRecipe(new ItemStack(armorset[2]), "XXX", "X X", "X X", 'X', material);
    	HLCraftingHelper.addShapedOreRecipe(new ItemStack(armorset[3]), "   ", "X X", "X X", 'X', material);
    }
    
    public static ItemStack cloneStack(Item item, int stackSize)
    {
        if(item == null)
            return null;
        else
            return new ItemStack(item, stackSize);
    }

    public static ItemStack cloneStack(Block item, int stackSize)
    {
        if(item == null)
            return null;
        else
            return new ItemStack(item, stackSize);
    }

    public static ItemStack cloneStack(ItemStack stack, int stackSize)
    {
        if(stack == null)
        {
            return null;
        } else
        {
            ItemStack retStack = stack.copy();
            retStack.getCount();
            return retStack;
        }
    }

    public static ItemStack cloneStack(ItemStack stack)
    {
        return stack != null ? stack.copy() : null;
    }
    
    public static boolean addSmelting(ItemStack out, Item in)
    {
        if((out == null) | (in == null))
        {
            return false;
        } else
        {
            FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), 0.0F);
            return true;
        }
    }

    public static boolean addSmelting(ItemStack out, Block in)
    {
        if((out == null) | (in == null))
        {
            return false;
        } else
        {
            FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), 0.0F);
            return true;
        }
    }

    public static boolean addSmelting(ItemStack out, ItemStack in)
    {
        if((out == null) | (in == null))
        {
            return false;
        } else
        {
            FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), 0.0F);
            return true;
        }
    }

    public static boolean addSmelting(ItemStack out, Item in, float XP)
    {
        if((out == null) | (in == null))
        {
            return false;
        } else
        {
            FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), XP);
            return true;
        }
    }

    public static boolean addSmelting(ItemStack out, Block in, float XP)
    {
        if((out == null) | (in == null))
        {
            return false;
        } else
        {
            FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), XP);
            return true;
        }
    }

    public static boolean addSmelting(ItemStack out, ItemStack in, float XP)
    {
        if((out == null) | (in == null))
        {
            return false;
        } else
        {
            FurnaceRecipes.instance().addSmeltingRecipe(cloneStack(in, 1), cloneStack(out), XP);
            return true;
        }
    }

}
