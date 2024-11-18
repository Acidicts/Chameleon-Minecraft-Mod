package io.github.acidicts.block;

import io.github.acidicts.block.entity.ExampleBlockEntity;
import io.github.acidicts.init.BlockEntityTypeInit;
import io.github.acidicts.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class IncubatorBEBlock extends Block implements BlockEntityProvider {
    public IncubatorBEBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof ExampleBlockEntity exampleBlockEntity && player != null) {
                if (player.isSneaking()) {
                    return ActionResult.PASS;
                } else {
                    if (player.getMainHandStack().getItem() == ModItems.CHAMELEON_EGG) {
                        int count = player.getMainHandStack().getCount();
                        player.setStackInHand(Hand.MAIN_HAND, new ItemStack(ModItems.CHAMELEON, count));
                    }
                }
            }
        }
        return ActionResult.success(world.isClient);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return BlockEntityTypeInit.EXAMPLE_BLOCK_ENTITY.instantiate(pos, state);
    }
}
