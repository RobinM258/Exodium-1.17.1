package com.exodium.exodium.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;

public class ExodiumTiers {
    public static final ForgeTier EXODIUM = new ForgeTier(4, 4999, 100f, 10f, 10, Tags.Blocks.NEEDS_NETHERITE_TOOL,
            () -> Ingredient.of(ModItems.EXODIUM_INGOT.get()));
}
