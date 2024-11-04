package com.exodium.exodium.item;

import com.exodium.exodium.Exodium;
import com.exodium.exodium.item.custom.HealStick;
import com.exodium.exodium.item.custom.StickOfGod;
import com.exodium.exodium.item.custom.StrenghtStickItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Exodium.MOD_ID);
    //ITEM
    public static final RegistryObject<Item> EXODIUM_INGOT = ITEMS.register("exodium_ingot",
            ()-> new Item(new Item.Properties().tab(ExodiumCreativeModeTab.EXODIUM_TAB)));

    //STICK
    public static final RegistryObject<Item> STRENGHT_STICK = ITEMS.register("power_stick",
            () -> new StrenghtStickItem(new Item.Properties().tab(ExodiumCreativeModeTab.EXODIUM_TAB).durability(15)));
    public static final RegistryObject<Item> STICK_OF_GOD = ITEMS.register("stick_of_god",
            () -> new StickOfGod(new Item.Properties().tab(ExodiumCreativeModeTab.EXODIUM_TAB).durability(8)));
    public static final RegistryObject<Item> HEAL_STICK = ITEMS.register("heal_stick",
            () -> new HealStick(new Item.Properties().tab(ExodiumCreativeModeTab.EXODIUM_TAB).durability(15)));

    //TOOLS
    public static final RegistryObject<Item> EXODIUM_SWORD = ITEMS.register("exodium_sword", () -> new SwordItem(ExodiumTiers.EXODIUM,
            2, 5f, new Item.Properties().tab(ExodiumCreativeModeTab.EXODIUM_TAB)));

    //ARMOR
    public static final RegistryObject<Item> EXODIUM_BOOTS = ITEMS.register("exodium_boots",
            () -> new ArmorItem(ModArmorMaterial.EXODIUM, EquipmentSlot.FEET,
                    new Item.Properties().tab(ExodiumCreativeModeTab.EXODIUM_TAB)));
    public static final RegistryObject<Item> EXODIUM_LEGGINGS = ITEMS.register("exodium_leggings",
            () -> new ArmorItem(ModArmorMaterial.EXODIUM, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ExodiumCreativeModeTab.EXODIUM_TAB)));
    public static final RegistryObject<Item> EXODIUM_CHESTPLATE = ITEMS.register("exodium_chestplate",
            () -> new ArmorItem(ModArmorMaterial.EXODIUM, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ExodiumCreativeModeTab.EXODIUM_TAB)));
    public static final RegistryObject<Item> EXODIUM_HELMET = ITEMS.register("exodium_helmet",
            () -> new ArmorItem(ModArmorMaterial.EXODIUM, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ExodiumCreativeModeTab.EXODIUM_TAB)));

    //DEV

    public static final RegistryObject<Item> CHEATED_SWORD = ITEMS.register("cheated_sword",
            () -> new SwordItem(ExodiumTiers.EXODIUM, 10000,10f,
                    new Item.Properties().tab(ExodiumCreativeModeTab.EXODIUM_TAB)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
