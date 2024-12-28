package io.github.acidicts.item;

import io.github.acidicts.WorkshopMod;
import io.github.acidicts.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static io.github.acidicts.item.ModItems.CHAMELEON_SPAWN_EGG;

public class ModItemGroups {
    public static final ItemGroup CHAMELEONS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(WorkshopMod.MOD_ID, "chameleons"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.CHAMELEON))
                    .displayName(Text.translatable("itemGroup.workshop-mod.chameleons"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.INCUBATOR);
                        entries.add(ModItems.CHAMELEON_EGG);
                        entries.add(ModItems.STEEL_INGOT);
                        entries.add(ModItems.CHAMELEON);
                        entries.add(CHAMELEON_SPAWN_EGG);
                    }).build());

    public static void registerItemGroups() {
        WorkshopMod.LOGGER.info("Registering Item Groups for " + WorkshopMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> {
            entries.add(CHAMELEON_SPAWN_EGG); // Ensure this line is present
        });
    }
}
