package com.exodium.exodium.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ExodiumCreativeModeTab {
    public static final CreativeModeTab EXODIUM_TAB = new CreativeModeTab("exodiumModTab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.EXODIUM_INGOT.get());
        }
    };
}
