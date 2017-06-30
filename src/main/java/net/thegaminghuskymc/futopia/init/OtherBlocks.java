package net.thegaminghuskymc.futopia.init;

import java.util.ArrayList;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thegaminghuskymc.futopia.Futopia;
import net.thegaminghuskymc.futopia.Refs;
import net.thegaminghuskymc.futopia.blocks.IInitializer;
import net.thegaminghuskymc.futopia.blocks.decorativeBlocks.concrete.BlockConcrete;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockAsphalt2;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockBasalt;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockLimestone;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockMarble;
import net.thegaminghuskymc.futopia.blocks.worldgen.BlockMeteor;

@GameRegistry.ObjectHolder(value = Refs.MODID)
public class OtherBlocks {

    /* REFERENCES */
    public static BlockMarble marble;
    public static BlockBasalt basalt;
    public static BlockMeteor meteor;
    public static BlockConcrete concrete;
    public static BlockLimestone limestone;
    public static BlockAsphalt2 asphalt;
    private static ArrayList<IInitializer> initList = new ArrayList<>();

    public static void preInit() {

        limestone = new BlockLimestone();
        basalt = new BlockBasalt();
        meteor = new BlockMeteor();
        marble = new BlockMarble();
//        concrete = new BlockConcrete();
//        asphalt = new BlockAsphalt2();

        initList.add(limestone);
        initList.add(basalt);
        initList.add(meteor);
        initList.add(marble);
//        initList.add(concrete);
//        initList.add(asphalt);

        Futopia.PROXY.addIModelRegister(limestone);
        Futopia.PROXY.addIModelRegister(marble);
        Futopia.PROXY.addIModelRegister(basalt);
        Futopia.PROXY.addIModelRegister(meteor);
//        Futopia.PROXY.addIModelRegister(concrete);
//        Futopia.PROXY.addIModelRegister(asphalt);

        for (IInitializer init : initList) {
            init.preInit();
        }
    }

    public static void initialize() {

        for (IInitializer init : initList) {
            init.initialize();
        }
    }

    public static void postInit() {

        for (IInitializer init : initList) {
            init.postInit();
        }
        initList.clear();
    }
}
