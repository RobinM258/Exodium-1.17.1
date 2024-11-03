package com.exodium.exodium.item;

import com.exodium.exodium.Exodium;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.function.Supplier;
//Premiere valeur determine le multiplicateur de la durabilité de l'armure
//Le tableau de int est la valeur de protection de chaque piece d'armure
//Troisième valeur est la capacité d'enchantement (on s'en fou)
//Quatrième valeur c'est l'armor Toughness
//Cinquième valeur de résistance au kb
public enum ModArmorMaterial implements ArmorMaterial {
    EXODIUM("exodium", 1, new int[]{5, 6, 6, 5}, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 4.0F, 0.0F, () -> {
        return Ingredient.of(new ItemLike[]{ModItems.EXODIUM_INGOT.get()});
        //etc...
    });

    private static final int[] HEALTH_PER_SLOT = new int[]{3380, 3900, 4160, 2860}; // {boots, legging, chestplate, helmet} Durabilité de chaque piece d'armure a multiplié par la première valeur au dessus
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    private ModArmorMaterial(String p_40474_, int p_40475_, int[] p_40476_, int p_40477_, SoundEvent p_40478_, float p_40479_, float p_40480_, Supplier p_40481_) {
        this.name = p_40474_;
        this.durabilityMultiplier = p_40475_;
        this.slotProtections = p_40476_;
        this.enchantmentValue = p_40477_;
        this.sound = p_40478_;
        this.toughness = p_40479_;
        this.knockbackResistance = p_40480_;
        this.repairIngredient = new LazyLoadedValue(p_40481_);
    }

    public int getDurabilityForSlot(EquipmentSlot p_40484_) {
        return HEALTH_PER_SLOT[p_40484_.getIndex()] * this.durabilityMultiplier;
    }

    public int getDefenseForSlot(EquipmentSlot p_40487_) {
        return this.slotProtections[p_40487_.getIndex()];
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }

    public String getName() {
        return Exodium.MOD_ID+":"+ this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
