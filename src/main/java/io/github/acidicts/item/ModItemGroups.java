package io.github.acidicts.item;

import io.github.acidicts.WorkshopMod;
import io.github.acidicts.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

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
                    }).build());

    public static void registerItemGroups() {
        WorkshopMod.LOGGER.info("Registering Item Groups for " + WorkshopMod.MOD_ID);

    }
}
