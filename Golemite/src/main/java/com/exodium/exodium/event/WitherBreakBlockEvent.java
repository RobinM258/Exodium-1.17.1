package com.exodium.exodium.event;

import com.exodium.exodium.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = "exodium")
public class WitherBreakBlockEvent {

    // Pour suivre le dernier temps où le Wither a subi des dégâts
    private static final Map<WitherBoss, Long> lastDamageTime = new HashMap<>();

    @SubscribeEvent
    public static void onWitherHurt(LivingHurtEvent event) {
        if (event.getEntity() instanceof WitherBoss wither) {
            long currentTime = System.currentTimeMillis();
            lastDamageTime.put(wither, currentTime);
        }
    }

    @SubscribeEvent
    public static void onTick(TickEvent.ServerTickEvent event) {
        // Vérifiez si le serveur est en train de tick
        if (event.phase == TickEvent.Phase.END) {
            for (WitherBoss wither : lastDamageTime.keySet()) {
                long lastTime = lastDamageTime.get(wither);
                long currentTime = System.currentTimeMillis();


                if (currentTime - lastTime >= 899) {
                    transformBlocks(wither);
                    lastDamageTime.remove(wither);
                }
            }
        }
    }

    private static void transformBlocks(WitherBoss wither) {
        Level world = wither.level;
        BlockPos pos = wither.blockPosition();

        // Vérifiez les blocs autour du Wither
        for (int x = -1; x <= 1; x++) {
            for (int y = 0; y <= 3; y++) {
                for (int z = -1; z <= 1; z++) {
                    BlockPos blockPos = pos.offset(x, y, z);
                    // Si le bloc est d'obsidienne ou d'obsidienne pleurante
                    if (world.getBlockState(blockPos).getBlock() == ModBlocks.LAVA_OBSIDIAN.get()) {
                        // Remplacez le bloc par de la lave
                        world.setBlockAndUpdate(blockPos, Blocks.LAVA.defaultBlockState());

                    }
                }
            }
        }
    }
}