package io.github.acidicts.block.entity;

import io.github.acidicts.WorkshopMod;
import io.github.acidicts.block.entity.client.ChameleonModel;
import io.github.acidicts.block.entity.client.ChameleonRenderer;
import io.github.acidicts.block.entity.custom.ChameleonEntity;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<ChameleonEntity> CHAMELEON = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(WorkshopMod.MOD_ID, "chameleon"),
            EntityType.Builder.create(ChameleonEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.75F, 0.75F) // Ensure these dimensions are correct
                    .build()
    );

    public static void registerModEntities() {
        WorkshopMod.LOGGER.info("Registering Entities for " + WorkshopMod.MOD_ID);

        EntityModelLayerRegistry.registerModelLayer(ChameleonModel.CHAMELEON, ChameleonModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.CHAMELEON, ChameleonRenderer::new);

        FabricDefaultAttributeRegistry.register(ModEntities.CHAMELEON, ChameleonEntity.createChameleonAttributes());
    }
}