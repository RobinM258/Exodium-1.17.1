package com.exodium.exodium.item.custom;

import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class StrenghtStickItem extends Item{

        public StrenghtStickItem(Properties pProperties) {
            super(pProperties);
        }

        @Override
        public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
            ItemStack itemstack = player.getItemInHand(hand);

            if (!world.isClientSide) {
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 2));
                player.getCooldowns().addCooldown(this, 280);
                itemstack.hurtAndBreak(1, player, p -> {
                    p.broadcastBreakEvent(player.getUsedItemHand());
                });
            }
            return InteractionResultHolder.sidedSuccess(itemstack, world.isClientSide());
        }
    }
