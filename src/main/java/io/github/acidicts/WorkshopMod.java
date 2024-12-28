package io.github.acidicts;

import io.github.acidicts.block.ModBlocks;
import io.github.acidicts.block.entity.ModEntities;
import io.github.acidicts.block.entity.client.ChameleonModel;
import io.github.acidicts.block.entity.client.ChameleonRenderer;
import io.github.acidicts.block.entity.custom.ChameleonEntity;
import io.github.acidicts.init.BlockEntityTypeInit;
import io.github.acidicts.item.ModItemGroups;
import io.github.acidicts.item.ModItems;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorkshopMod implements ModInitializer {
	public static final String MOD_ID = "workshop-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		BlockEntityTypeInit.registerBlockEntities();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}