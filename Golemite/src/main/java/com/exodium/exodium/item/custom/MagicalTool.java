package com.exodium.exodium.item.custom;

import com.exodium.exodium.block.ModBlocks;

import com.google.common.collect.ImmutableMap;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class MagicalTool extends Item {
    private static final ImmutableMap<Block, Block> MAGICAL_BREAK =
            new ImmutableMap.Builder<Block,Block>()
                    .put(Blocks.OBSIDIAN, Blocks.OBSIDIAN)
                    .put(ModBlocks.LAVA_OBSIDIAN.get(), ModBlocks.LAVA_OBSIDIAN.get())
                    .put(ModBlocks.EXODIUM_BLOCK.get(), ModBlocks.EXODIUM_BLOCK.get())
                    .build();


    public MagicalTool(Properties pProperties) {

        super(pProperties);


    }


    @Override


    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()){
            Level level = pContext.getLevel();
            BlockPos positionClicked = pContext.getClickedPos();
            Block blockClicked = level.getBlockState(positionClicked).getBlock();

            if(canMagicalBreak(blockClicked)) {
                ItemEntity entityItem = new ItemEntity(level,
                        positionClicked.getX(), positionClicked.getY(), positionClicked.getZ(),
                        new ItemStack(MAGICAL_BREAK.get(blockClicked),1));

                level.destroyBlock(positionClicked, false); // si le bloc drop ou non.
                level.addFreshEntity(entityItem);
                //pContext.getItemInHand().hurtAndBreak(1,pContext.getPlayer(), p ->{
                //p.broadcastBreakEvent(pContext.getHand()); // InteractionHand =! EquipmentSlot
                //});


            } else {
                pContext.getPlayer().sendMessage(new TextComponent("Only work on modded obsidians/anvils."),
                        Util.NIL_UUID);
            }

        }
        return InteractionResult.SUCCESS;

    }

    private boolean canMagicalBreak(Block block) {
        return MAGICAL_BREAK.containsKey(block);
    }

}