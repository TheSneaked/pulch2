package pulch.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import pulch.Pulch;

public class ModItemGroups {
    public static final ItemGroup FLORAL_WEAPONRY_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Pulch.MOD_ID, "floral_weaponry_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.ROSEN_THORN))
                    .displayName(Text.translatable("itemgroup.pulch.floral_weaponry_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.ROSEN_THORN);
                        entries.add(ModItems.BLUE_ROSEN_THORN);
                        entries.add(ModItems.WITHERED_ROSEN_THORN);

                    }).build());
    public static final ItemGroup CORONATED_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Pulch.MOD_ID, "coronated_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.SOVEREIGN_EDGE))
                    .displayName(Text.translatable("itemgroup.pulch.coronated_items"))
                    .entries((displayContext, entries) -> {
                    entries.add(ModItems.SOVEREIGN_EDGE);
                        entries.add(ModItems.ROYAL_PARDON);
                    }).build());






    public static void registerItemGroups() {
        Pulch.LOGGER.info("Registering Item Groups for " + Pulch.MOD_ID);
    }
}