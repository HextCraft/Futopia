package net.thegaminghuskymc.futopia.init;

import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thegaminghuskymc.futopia.blocks.IInitializer;
import net.thegaminghuskymc.futopia.blocks.decorativeBlocks.concrete.BlockConcrete;
import net.thegaminghuskymc.futopia.blocks.worldgen.*;

import java.util.ArrayList;

public class OtherBlocks {

    public static final OtherBlocks INSTANCE = new OtherBlocks();

    private OtherBlocks() {

    }

    public static void preInit() {

        limestone = new BlockLimestone();
        basalt = new BlockBasalt();
        meteor = new BlockMeteor();
        marble = new BlockMarble();
        concrete = new BlockConcrete();
        // asphalt = new BlockAsphalt();

        initList.add(limestone);
        initList.add(basalt);
        initList.add(meteor);
        initList.add(marble);
        initList.add(concrete);
        // initList.add(asphalt);

        for (IInitializer init : initList) {
            init.initialize();
        }
        MinecraftForge.EVENT_BUS.register(INSTANCE);
    }

    /* EVENT HANDLING */
    @SubscribeEvent
    public void registerRecipes(RegistryEvent.Register<IRecipe> event) {

        for (IInitializer init : initList) {
            init.register();
        }
    }

    private static ArrayList<IInitializer> initList = new ArrayList<>();

    /* REFERENCES */
    public static BlockMarble marble;
    public static BlockBasalt basalt;
    public static BlockMeteor meteor;
    public static BlockConcrete concrete;
    public static BlockLimestone limestone;
    public static BlockAsphalt asphalt;

}