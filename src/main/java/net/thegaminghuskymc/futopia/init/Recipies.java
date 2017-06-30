package net.thegaminghuskymc.futopia.init;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.thegaminghuskymc.huskylib.utils.HLCraftingHelper;

@SuppressWarnings("unused")
public class Recipies {

    public static void init() {
//        addSawRecipes();
//        addHammerRecipes();
//        addDustRecipes();
//        addPlateRecipes();
        addBlockRecipes();
        addItemRecipes();
//        addArmorRecipies();
//        addToolRecipies();
    }

    private static void addSawRecipes() {
        /*addSawRecipe(new ItemStack(FTItems2.saw, 1, EnumMaterialType.RED.ordinal()), "ingotRed");
        addSawRecipe(new ItemStack(FTItems2.saw, 1, EnumMaterialType.BLUE.ordinal()), "ingotBlue");
        addSawRecipe(new ItemStack(FTItems2.saw, 1, EnumMaterialType.PURPLE.ordinal()), "ingotPurple");
        addSawRecipe(new ItemStack(FTItems2.saw, 1, EnumMaterialType.GREEN.ordinal()), "ingotGreen");
        addSawRecipe(new ItemStack(FTItems2.saw, 1, EnumMaterialType.ZINC.ordinal()), "ingotZinc");
        addSawRecipe(new ItemStack(FTItems2.saw, 1, EnumMaterialType.TUNGSTEN.ordinal()), "ingotTungsten");
        addSawRecipe(new ItemStack(FTItems2.saw, 1, EnumMaterialType.BRASS.ordinal()), "ingotBrass");
        addSawRecipe(new ItemStack(FTItems2.saw, 1, EnumMaterialType.TESSELITE.ordinal()), "ingotTesselite");

        addSawRecipe(new ItemStack(FTItems2.saw, 1, EnumMaterialType.RED.ordinal()), "alloyFutopiaRed");
        addSawRecipe(new ItemStack(FTItems2.saw, 1, EnumMaterialType.BLUE.ordinal()), "alloyFutopiaBlue");
        addSawRecipe(new ItemStack(FTItems2.saw, 1, EnumMaterialType.PURPLE.ordinal()), "alloyFutopiaPurple");
        addSawRecipe(new ItemStack(FTItems2.saw, 1, EnumMaterialType.GREEN.ordinal()), "alloyFutopiaGreen");
        addSawRecipe(new ItemStack(FTItems2.saw, 1, EnumMaterialType.ZINC.ordinal()), "alloyFutopiaZinc");
        addSawRecipe(new ItemStack(FTItems2.saw, 1, EnumMaterialType.TUNGSTEN.ordinal()), "alloyFutopiaTungsten");
        addSawRecipe(new ItemStack(FTItems2.saw, 1, EnumMaterialType.BRASS.ordinal()), "alloyFutopiaBrass");
        addSawRecipe(new ItemStack(FTItems2.saw, 1, EnumMaterialType.TESSELITE.ordinal()), "alloyFutopiaTesselite");*/
    }

    /*private static void addHammerRecipes() {
        addHammerRecipe(new ItemStack(FTItems2.hammer, 1, EnumMaterialType.RED.ordinal()), "ingotRed");
        addHammerRecipe(new ItemStack(FTItems2.hammer, 1, EnumMaterialType.BLUE.ordinal()), "ingotBlue");
        addHammerRecipe(new ItemStack(FTItems2.hammer, 1, EnumMaterialType.PURPLE.ordinal()), "ingotPurple");
        addHammerRecipe(new ItemStack(FTItems2.hammer, 1, EnumMaterialType.GREEN.ordinal()), "ingotGreen");
        addHammerRecipe(new ItemStack(FTItems2.hammer, 1, EnumMaterialType.ZINC.ordinal()), "ingotZinc");
        addHammerRecipe(new ItemStack(FTItems2.hammer, 1, EnumMaterialType.TUNGSTEN.ordinal()), "ingotTungsten");
        addHammerRecipe(new ItemStack(FTItems2.hammer, 1, EnumMaterialType.BRASS.ordinal()), "ingotBrass");
        addHammerRecipe(new ItemStack(FTItems2.hammer, 1, EnumMaterialType.TESSELITE.ordinal()), "ingotTesselite");

        addHammerRecipe(new ItemStack(FTItems2.hammer, 1, EnumMaterialType.RED.ordinal()), "alloyFutopiaRed");
        addHammerRecipe(new ItemStack(FTItems2.hammer, 1, EnumMaterialType.BLUE.ordinal()), "alloyFutopiaBlue");
        addHammerRecipe(new ItemStack(FTItems2.hammer, 1, EnumMaterialType.PURPLE.ordinal()), "alloyFutopiaPurple");
        addHammerRecipe(new ItemStack(FTItems2.hammer, 1, EnumMaterialType.GREEN.ordinal()), "alloyFutopiaGreen");
        addHammerRecipe(new ItemStack(FTItems2.hammer, 1, EnumMaterialType.ZINC.ordinal()), "alloyFutopiaZinc");
        addHammerRecipe(new ItemStack(FTItems2.hammer, 1, EnumMaterialType.TUNGSTEN.ordinal()), "alloyFutopiaTungsten");
        addHammerRecipe(new ItemStack(FTItems2.hammer, 1, EnumMaterialType.BRASS.ordinal()), "alloyFutopiaBrass");
        addHammerRecipe(new ItemStack(FTItems2.hammer, 1, EnumMaterialType.TESSELITE.ordinal()), "alloyFutopiaTesselite");
    }

    private static void addPlateRecipes() {
        addPlateRecipe(new ItemStack(FTItems2.plates, 1, EnumMaterialType.RED.ordinal()),  "alloyFutopiaRed");
        addPlateRecipe(new ItemStack(FTItems2.plates, 1, EnumMaterialType.BLUE.ordinal()),  "alloyFutopiaBlue");
        addPlateRecipe(new ItemStack(FTItems2.plates, 1, EnumMaterialType.PURPLE.ordinal()), "alloyFutopiaPurple");
        addPlateRecipe(new ItemStack(FTItems2.plates, 1, EnumMaterialType.GREEN.ordinal()), "alloyFutopiaGreen");
        addPlateRecipe(new ItemStack(FTItems2.plates, 1, EnumMaterialType.ZINC.ordinal()), "alloyFutopiaZinc");
        addPlateRecipe(new ItemStack(FTItems2.plates, 1, EnumMaterialType.TUNGSTEN.ordinal()),  "alloyFutopiaTungsten");
        addPlateRecipe(new ItemStack(FTItems2.plates, 1, EnumMaterialType.BRASS.ordinal()),  "alloyFutopiaBrass");
        addPlateRecipe(new ItemStack(FTItems2.plates, 1, EnumMaterialType.TESSELITE.ordinal()), "alloyFutopiaTesselite");
    }

    private static void addDustRecipes() {
        addDustRecipe(new ItemStack(FTItems2.dusts, 4, EnumMaterialType.RED.ordinal()), "alloyFutopiaRed");
        addDustRecipe(new ItemStack(FTItems2.dusts, 4, EnumMaterialType.BLUE.ordinal()), "alloyFutopiaBlue");
        addDustRecipe(new ItemStack(FTItems2.dusts, 4, EnumMaterialType.PURPLE.ordinal()),"alloyFutopiaPurple");
        addDustRecipe(new ItemStack(FTItems2.dusts, 4, EnumMaterialType.GREEN.ordinal()), "alloyFutopiaGreen");
        addDustRecipe(new ItemStack(FTItems2.dusts, 4, EnumMaterialType.ZINC.ordinal()), "alloyFutopiaZinc");
        addDustRecipe(new ItemStack(FTItems2.dusts, 4, EnumMaterialType.TUNGSTEN.ordinal()),"alloyFutopiaTungsten");
        addDustRecipe(new ItemStack(FTItems2.dusts, 4, EnumMaterialType.BRASS.ordinal()),"alloyFutopiaBrass");
        addDustRecipe(new ItemStack(FTItems2.dusts, 4, EnumMaterialType.TESSELITE.ordinal()),"alloyFutopiaTesselite");
    }

    private static void addNuggetRecipes() {
        addNuggetRecipe(new ItemStack(FTItems2.nuggets, 4, EnumMaterialType.RED.ordinal()), "alloyFutopiaRed");
        addNuggetRecipe(new ItemStack(FTItems2.nuggets, 4, EnumMaterialType.BLUE.ordinal()), "alloyFutopiaBlue");
        addNuggetRecipe(new ItemStack(FTItems2.nuggets, 4, EnumMaterialType.PURPLE.ordinal()),"alloyFutopiaPurple");
        addNuggetRecipe(new ItemStack(FTItems2.nuggets, 4, EnumMaterialType.GREEN.ordinal()), "alloyFutopiaGreen");
        addNuggetRecipe(new ItemStack(FTItems2.nuggets, 4, EnumMaterialType.ZINC.ordinal()), "alloyFutopiaZinc");
        addNuggetRecipe(new ItemStack(FTItems2.nuggets, 4, EnumMaterialType.TUNGSTEN.ordinal()),"alloyFutopiaTungsten");
        addNuggetRecipe(new ItemStack(FTItems2.nuggets, 4, EnumMaterialType.BRASS.ordinal()),"alloyFutopiaBrass");
        addNuggetRecipe(new ItemStack(FTItems2.nuggets, 4, EnumMaterialType.TESSELITE.ordinal()),"alloyFutopiaTesselite");
    }*/

    private static void addItemRecipes() {
        /*addGearRecipe(new ItemStack(FTItems2.gears, 1, EnumMaterialType.RED.ordinal()), "alloyFutopiaRed");
        addGearRecipe(new ItemStack(FTItems2.gears, 1, EnumMaterialType.BLUE.ordinal()), "alloyFutopiaBlue");
        addGearRecipe(new ItemStack(FTItems2.gears, 1, EnumMaterialType.PURPLE.ordinal()), "alloyFutopiaPurple");
        addGearRecipe(new ItemStack(FTItems2.gears, 1, EnumMaterialType.GREEN.ordinal()), "alloyFutopiaGreen");
        addGearRecipe(new ItemStack(FTItems2.gears, 1, EnumMaterialType.ZINC.ordinal()), "alloyFutopiaZinc");
        addGearRecipe(new ItemStack(FTItems2.gears, 1, EnumMaterialType.TUNGSTEN.ordinal()), "alloyFutopiaTungsten");
        addGearRecipe(new ItemStack(FTItems2.gears, 1, EnumMaterialType.BRASS.ordinal()), "alloyFutopiaBrass");
        addGearRecipe(new ItemStack(FTItems2.gears, 1, EnumMaterialType.TESSELITE.ordinal()), "alloyFutopiaTesselite");

        addGearRecipe(new ItemStack(FTItems2.gears, 1, EnumMaterialType.RED.ordinal()), "ingotRed");
        addGearRecipe(new ItemStack(FTItems2.gears, 1, EnumMaterialType.BLUE.ordinal()), "ingotBlue");
        addGearRecipe(new ItemStack(FTItems2.gears, 1, EnumMaterialType.PURPLE.ordinal()), "ingotPurple");
        addGearRecipe(new ItemStack(FTItems2.gears, 1, EnumMaterialType.GREEN.ordinal()), "ingotGreen");
        addGearRecipe(new ItemStack(FTItems2.gears, 1, EnumMaterialType.ZINC.ordinal()), "ingotZinc");
        addGearRecipe(new ItemStack(FTItems2.gears, 1, EnumMaterialType.TUNGSTEN.ordinal()), "ingotTungsten");
        addGearRecipe(new ItemStack(FTItems2.gears, 1, EnumMaterialType.BRASS.ordinal()), "ingotBrass");
        addGearRecipe(new ItemStack(FTItems2.gears, 1, EnumMaterialType.TESSELITE.ordinal()), "ingotTesselite");*/
    	
    	HLCraftingHelper.addShapedRecipe(new ItemStack(Items.BANNER), new Object[]{ "yyy", "yyy", " x ", 'x', Items.IRON_INGOT, 'y', Blocks.WOOL });

//        addSmelting(new ItemStack(FTItems2.dusts, 9, EnumMaterialType.RED.ordinal()), new ItemStack(FTItems2.ingots, 1, EnumMaterialType.RED.ordinal()), 0.0F);
//        addSmelting(new ItemStack(FTItems2.dusts, 9, EnumMaterialType.BLUE.ordinal()), new ItemStack(FTItems2.ingots, 1, EnumMaterialType.BLUE.ordinal()), 0.0F);
//        addSmelting(new ItemStack(FTItems2.dusts, 9, EnumMaterialType.PURPLE.ordinal()), new ItemStack(FTItems2.ingots, 1, EnumMaterialType.PURPLE.ordinal()), 0.0F);
//        addSmelting(new ItemStack(FTItems2.dusts, 9, EnumMaterialType.GREEN.ordinal()), new ItemStack(FTItems2.ingots, 1, EnumMaterialType.GREEN.ordinal()), 0.0F);
//        addSmelting(new ItemStack(FTItems2.dusts, 9, EnumMaterialType.ZINC.ordinal()), new ItemStack(FTItems2.ingots, 1, EnumMaterialType.ZINC.ordinal()), 0.0F);
//        addSmelting(new ItemStack(FTItems2.dusts, 9, EnumMaterialType.TUNGSTEN.ordinal()), new ItemStack(FTItems2.ingots, 1, EnumMaterialType.TUNGSTEN.ordinal()), 0.0F);
//        addSmelting(new ItemStack(FTItems2.dusts, 9, EnumMaterialType.BRASS.ordinal()), new ItemStack(FTItems2.ingots, 1, EnumMaterialType.BRASS.ordinal()), 0.0F);
//        addSmelting(new ItemStack(FTItems2.dusts, 9, EnumMaterialType.TESSELITE.ordinal()), new ItemStack(FTItems2.ingots, 1, EnumMaterialType.TESSELITE.ordinal()), 0.0F);
    }

    private static void addBlockRecipes() {
        /*CraftingManager.getInstance().addRecipe(new ShapedOreRecipe(new ItemStack(FTBlocks.particle_block), "RBG", "GRB", "BGR", 'B', "ingotBlue",
                'R', "ingotRed", 'G', "ingotGreen"));

        CraftingManager.getInstance().addRecipe(new ShapedOreRecipe(new ItemStack(FTBlocks.particle_block), "RBG", "GRB", "BGR", 'B', "alloyFutopiaBlue",
                'R', "alloyFutopiaRed", 'G', "alloyFutopiaGreen"));*/

//        addSmelting(new ItemStack(FTItems2.ingots, 1, EnumMaterialType.RED.ordinal()), new ItemStack(FTBlocks.ores, 1, EnumMaterialType.RED.ordinal()), 0.0F);
//        addSmelting(new ItemStack(FTItems2.ingots, 1, EnumMaterialType.BLUE.ordinal()), new ItemStack(FTBlocks.ores, 1, EnumMaterialType.BLUE.ordinal()), 0.0F);
//        addSmelting(new ItemStack(FTItems2.ingots, 1, EnumMaterialType.PURPLE.ordinal()), new ItemStack(FTBlocks.ores, 1, EnumMaterialType.PURPLE.ordinal()), 0.0F);
//        addSmelting(new ItemStack(FTItems2.ingots, 1, EnumMaterialType.GREEN.ordinal()), new ItemStack(FTBlocks.ores, 1, EnumMaterialType.GREEN.ordinal()), 0.0F);
//        addSmelting(new ItemStack(FTItems2.ingots, 1, EnumMaterialType.ZINC.ordinal()), new ItemStack(FTBlocks.ores, 1, EnumMaterialType.ZINC.ordinal()), 0.0F);
//        addSmelting(new ItemStack(FTItems2.ingots, 1, EnumMaterialType.TUNGSTEN.ordinal()), new ItemStack(FTBlocks.ores, 1, EnumMaterialType.TUNGSTEN.ordinal()), 0.0F);
//        addSmelting(new ItemStack(FTItems2.ingots, 1, EnumMaterialType.BRASS.ordinal()), new ItemStack(FTBlocks.ores, 1, EnumMaterialType.BRASS.ordinal()), 0.0F);
//        addSmelting(new ItemStack(FTItems2.ingots, 1, EnumMaterialType.TESSELITE.ordinal()), new ItemStack(FTBlocks.ores, 1, EnumMaterialType.TESSELITE.ordinal()), 0.0F);
    }

    private static void addToolRecipies() {
        /*addToolsetRecipe(FTItems2.toolsRed, "ingotRed");
        addToolsetRecipe(FTItems2.toolsBlue, "ingotBlue");
        addToolsetRecipe(FTItems2.toolsPurple, "ingotPurple");
        addToolsetRecipe(FTItems2.toolsGreen, "ingotGreen");
        addToolsetRecipe(FTItems2.toolsZinc, "ingotZinc");
        addToolsetRecipe(FTItems2.toolsTungsten, "ingotTungsten");

        addToolsetRecipe(FTItems2.toolsRed, "alloyFutopiaRed");
        addToolsetRecipe(FTItems2.toolsBlue, "alloyFutopiaBlue");
        addToolsetRecipe(FTItems2.toolsPurple, "alloyFutopiaPurple");
        addToolsetRecipe(FTItems2.toolsGreen, "alloyFutopiaGreen");
        addToolsetRecipe(FTItems2.toolsZinc, "alloyFutopiaZinc");
        addToolsetRecipe(FTItems2.toolsTungsten, "alloyFutopiaTungsten");*/
    }

    private static void addArmorRecipies() {
        /*addArmorsetRecipe(FTItems2.armorRed, "ingotRed");
        addArmorsetRecipe(FTItems2.armorBlue, "ingotBlue");
        addArmorsetRecipe(FTItems2.armorPurple, "ingotPurple");
        addArmorsetRecipe(FTItems2.armorGreen, "ingotGreen");
        addArmorsetRecipe(FTItems2.armorZinc, "ingotZinc");
        addArmorsetRecipe(FTItems2.armorTungsten, "ingotTungsten");

        addArmorsetRecipe(FTItems2.armorRed, "alloyFutopiaRed");
        addArmorsetRecipe(FTItems2.armorBlue, "alloyFutopiaBlue");
        addArmorsetRecipe(FTItems2.armorPurple, "alloyFutopiaPurple");
        addArmorsetRecipe(FTItems2.armorGreen, "alloyFutopiaGreen");
        addArmorsetRecipe(FTItems2.armorZinc, "alloyFutopiaZinc");
        addArmorsetRecipe(FTItems2.armorTungsten, "alloyFutopiaTungsten");*/
    }
    
    private static void addBlockRecipe(Block block, String material){
    	HLCraftingHelper.addShapedOreRecipe(new ItemStack(block), new Object[]{ "AAA", "AAA", "AAA", 'A', material}); 
    }
    
    private static void addBlockRecipe(Block block, Item material){
    	HLCraftingHelper.addShapedOreRecipe(new ItemStack(block), new Object[]{ "AAA", "AAA", "AAA", 'A', material}); 
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
    	HLCraftingHelper.addShapedOreRecipe(saws, new Object[]{ "XX ", " XP", "  P",  'X', material, 'P', Blocks.PLANKS});
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
