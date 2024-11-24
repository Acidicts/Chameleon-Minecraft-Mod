package io.github.acidicts.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Chameleon extends Item {
    public Chameleon(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(world.isClient()) {
            user.sendMessage(Text.literal("Hello my friend!"), true);
            return TypedActionResult.success(user.getStackInHand(hand));
        } else {
            return TypedActionResult.fail(user.getStackInHand(hand));
        }
    }
}