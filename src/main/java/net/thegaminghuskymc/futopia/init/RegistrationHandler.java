package net.thegaminghuskymc.futopia.init;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.thegaminghuskymc.futopia.Reference;

@Mod.EventBusSubscriber(modid = Reference.MODID)
    public class RegistrationHandler {
        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event) {
            final IForgeRegistry<Item> registry = event.getRegistry();

            for (Item item : items) {
                registry.register(item);
            }
        }
    }