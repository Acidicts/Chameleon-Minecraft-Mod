package io.github.acidicts.item;

import io.github.acidicts.WorkshopMod;
import io.github.acidicts.block.entity.ModEntities;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item CHAMELEON_EGG = registerItem("chameleon_egg", new Item(new Item.Settings()));
    public static final Item CHAMELEON_SPAWN_EGG = registerItem("chameleon_spawn_egg", new SpawnEggItem(ModEntities.CHAMELEON, 0x00FF00, 0x0000FF, new Item.Settings()));
    public static final Item CHAMELEON = registerItem("chameleon", new Chameleon(new Item.Settings()));
    public static final Item STEEL_INGOT = registerItem("steel_ingot", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(WorkshopMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        WorkshopMod.LOGGER.info("Registering Mod Items for " + WorkshopMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> {
            entries.add(CHAMELEON_EGG);
        });
    }
}
