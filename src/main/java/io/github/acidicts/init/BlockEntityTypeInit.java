package io.github.acidicts.init;


import io.github.acidicts.WorkshopMod;
import io.github.acidicts.block.ModBlocks;
import io.github.acidicts.block.entity.ExampleBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BlockEntityTypeInit {
    public static final BlockEntityType<ExampleBlockEntity> EXAMPLE_BLOCK_ENTITY = register("example_block_entity",
            BlockEntityType.Builder.create(ExampleBlockEntity::new, ModBlocks.INCUBATOR).build());

    public static <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType<T> type) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(WorkshopMod.MOD_ID, name), type);
    }

    public static void registerBlockEntities() {
        WorkshopMod.LOGGER.info("Registering Block Entity Types for " + WorkshopMod.MOD_ID);
    }
}
