package io.github.acidicts;

import io.github.acidicts.block.ModBlocks;
import io.github.acidicts.init.BlockEntityTypeInit;
import io.github.acidicts.item.ModItemGroups;
import io.github.acidicts.item.ModItems;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorkshopMod implements ModInitializer {
	public static final String MOD_ID = "workshop-mod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		BlockEntityTypeInit.registerBlockEntities();
	}
}
