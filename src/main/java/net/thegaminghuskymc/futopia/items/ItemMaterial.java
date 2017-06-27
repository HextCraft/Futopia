package net.thegaminghuskymc.futopia.items;

import cofh.core.item.ItemMulti;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.blocks.IInitializer;
import net.thegaminghuskymc.futopia.init.FTCreativeTabs;

public class ItemMaterial extends ItemMulti implements IInitializer {

    //Ingots
    public static ItemStack ingotRed;
    public static ItemStack ingotBlue;
    public static ItemStack ingotPurple;
    public static ItemStack ingotGreen;
    public static ItemStack ingotZinc;
    public static ItemStack ingotTungsten;
    public static ItemStack ingotBrass;
    public static ItemStack ingotTesselite;

    //Nuggets
    public static ItemStack nuggetRed;
    public static ItemStack nuggetBlue;
    public static ItemStack nuggetPurple;
    public static ItemStack nuggetGreen;
    public static ItemStack nuggetZinc;
    public static ItemStack nuggetTungsten;
    public static ItemStack nuggetBrass;
    public static ItemStack nuggetTesselite;

    //Gears
    public static ItemStack gearRed;
    public static ItemStack gearBlue;
    public static ItemStack gearPurple;
    public static ItemStack gearGreen;
    public static ItemStack gearZinc;
    public static ItemStack gearTungsten;
    public static ItemStack gearBrass;
    public static ItemStack gearTesselite;

    //Dusts
    public static ItemStack dustRed;
    public static ItemStack dustBlue;
    public static ItemStack dustPurple;
    public static ItemStack dustGreen;
    public static ItemStack dustZinc;
    public static ItemStack dustTungsten;
    public static ItemStack dustBrass;
    public static ItemStack dustTesselite;

    //Plates
    public static ItemStack plateRed;
    public static ItemStack plateBlue;
    public static ItemStack platePurple;
    public static ItemStack plateGreen;
    public static ItemStack plateZinc;
    public static ItemStack plateTungsten;
    public static ItemStack plateBrass;
    public static ItemStack plateTesselite;

    //Shards
    public static ItemStack shardRed;
    public static ItemStack shardBlue;
    public static ItemStack shardPurple;
    public static ItemStack shardGreen;
    public static ItemStack shardZinc;
    public static ItemStack shardTungsten;
    public static ItemStack shardBrass;
    public static ItemStack shardTesselite;

    public ItemMaterial() {

        super(Refs.MODID);

        setUnlocalizedName("material");
        setCreativeTab(FTCreativeTabs.materials);
    }

    /* IInitializer */
    @Override
    public boolean preInit() {

        //Ingots
        ingotRed = addOreDictItem(0, "ingotRed");
        ingotBlue = addOreDictItem(1, "ingotBlue");
        ingotPurple = addOreDictItem(2, "ingotPurple");
        ingotGreen = addOreDictItem(3, "ingotGreen");
        ingotZinc = addOreDictItem(4, "ingotZinc");
        ingotTungsten = addOreDictItem(5, "ingotTungsten");
        ingotBrass = addOreDictItem(6, "ingotBrass");
        ingotTesselite = addOreDictItem(7, "ingotTesselite");

        //Nuggets
        nuggetRed = addOreDictItem(8, "nuggetRed");
        nuggetBlue = addOreDictItem(9, "nuggetBlue");
        nuggetPurple = addOreDictItem(10, "nuggetPurple");
        nuggetGreen = addOreDictItem(11, "nuggetGreen");
        nuggetZinc = addOreDictItem(12, "nuggetZinc");
        nuggetTungsten = addOreDictItem(13, "nuggetTungsten");
        nuggetBrass = addOreDictItem(14, "nuggetBrass");
        nuggetTesselite = addOreDictItem(15, "nuggetTesselite");

        //Gears
        gearRed = addOreDictItem(16, "gearRed");
        gearBlue = addOreDictItem(17, "gearBlue");
        gearPurple = addOreDictItem(18, "gearPurple");
        gearGreen = addOreDictItem(19, "gearGreen");
        gearZinc = addOreDictItem(20, "gearZinc");
        gearTungsten = addOreDictItem(21, "gearTungsten");
        gearBrass = addOreDictItem(22, "gearBrass");
        gearTesselite = addOreDictItem(23, "gearTesselite");

        //Dusts
        dustRed = addOreDictItem(24, "dustRed");
        dustBlue = addOreDictItem(25, "dustBlue");
        dustPurple = addOreDictItem(26, "dustPurple");
        dustGreen = addOreDictItem(27, "dustGreen");
        dustZinc = addOreDictItem(28, "dustZinc");
        dustTungsten = addOreDictItem(29, "dustTungsten");
        dustBrass = addOreDictItem(30, "dustBrass");
        dustTesselite = addOreDictItem(31, "dustTesselite");

        //Plates
        plateRed = addOreDictItem(32, "plateRed");
        plateBlue = addOreDictItem(33, "plateBlue");
        platePurple = addOreDictItem(34, "platePurple");
        plateGreen = addOreDictItem(35, "plateGreen");
        plateZinc = addOreDictItem(36, "plateZinc");
        plateTungsten = addOreDictItem(37, "plateTungsten");
        plateBrass = addOreDictItem(38, "plateBrass");
        plateTesselite = addOreDictItem(39, "plateTesselite");

        //Shards
        shardRed = addOreDictItem(40, "shardRed");
        shardBlue = addOreDictItem(41, "shardBlue");
        shardPurple = addOreDictItem(42, "shardPurple");
        shardGreen = addOreDictItem(43, "shardGreen");
        shardZinc = addOreDictItem(44, "shardZinc");
        shardTungsten = addOreDictItem(45, "shardTungsten");
        shardBrass = addOreDictItem(46, "shardBrass");
        shardTesselite = addOreDictItem(47, "shardTesselite");

        return true;
    }

    @Override
    public boolean initialize() {
        return false;
    }

    @Override
    public boolean postInit() {

		/* Smelting */
        /*addSmelting(ingotRed, dustRed, 0.0F);
        addSmelting(ingotBlue, dustBlue, 0.0F);
        addSmelting(ingotPurple, dustPurple, 0.0F);
        addSmelting(ingotGreen, dustGreen, 0.0F);
        addSmelting(ingotZinc, dustZinc, 0.0F);
        addSmelting(ingotTungsten, dustTungsten, 0.0F);
        addSmelting(ingotBrass, dustBrass, 0.0F);
        addSmelting(ingotTesselite, dustTesselite, 0.0F);

        addTwoWayStorageRecipe(ingotRed, "ingotRed", nuggetRed, "nuggetRed");
        addTwoWayStorageRecipe(ingotBlue, "ingotBlue", nuggetBlue, "nuggetBlue");
        addTwoWayStorageRecipe(ingotPurple, "ingotPurple", nuggetPurple, "nuggetPurple");
        addTwoWayStorageRecipe(ingotGreen, "ingotGreen", nuggetGreen, "nuggetGreen");
        addTwoWayStorageRecipe(ingotZinc, "ingotZinc", nuggetZinc, "nuggetZinc");
        addTwoWayStorageRecipe(ingotTungsten, "ingotTungsten", nuggetTungsten, "nuggetTungsten");
        addTwoWayStorageRecipe(ingotBrass, "ingotBrass", nuggetBrass, "nuggetBrass");
        addTwoWayStorageRecipe(ingotTesselite, "ingotTesselite", nuggetTesselite, "nuggetTesselite");

        addReverseStorageRecipe(ingotRed, "blockInvar");
        addReverseStorageRecipe(ingotBlue, "blockBronze");
        addReverseStorageRecipe(ingotPurple, "blockConstantan");
        addReverseStorageRecipe(ingotGreen, "blockSignalum");
        addReverseStorageRecipe(ingotZinc, "blockLumium");
        addReverseStorageRecipe(ingotTungsten, "blockEnderium");
        addReverseStorageRecipe(ingotBrass, "blockLumium");
        addReverseStorageRecipe(ingotTesselite, "blockEnderium");

        addGearRecipe(dustRed, "ingotRed");
        addGearRecipe(dustBlue, "ingotBlue");
        addGearRecipe(dustPurple, "ingotPurple");
        addGearRecipe(dustGreen, "ingotGreen");
        addGearRecipe(dustZinc, "ingotZinc");
        addGearRecipe(dustTungsten, "ingotTungsten");
        addGearRecipe(dustBrass, "ingotBrass");
        addGearRecipe(dustTesselite, "ingotTesselite");*/

        return true;
    }
}