package com.exodium.exodium.item;

import com.exodium.exodium.Exodium;
import com.exodium.exodium.item.custom.StrenghtStickItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Exodium.MOD_ID);

    public static final RegistryObject<Item> EXODIUM_INGOT = ITEMS.register("exodium_ingot",
            ()-> new Item(new Item.Properties().tab(ExodiumCreativeModeTab.EXODIUM_TAB)));

    public static final RegistryObject<Item> STRENGHT_STICK = ITEMS.register("power_stick",
            () -> new StrenghtStickItem(new Item.Properties().tab(ExodiumCreativeModeTab.EXODIUM_TAB).durability(15)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
