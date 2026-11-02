package pulch.item;

import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import pulch.Pulch;
import pulch.item.custom.RosenThorn;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import pulch.item.custom.SovereignEdge;
import pulch.item.custom.WitheredRosenThorn;

import java.util.function.Function;

public class ModItems {
    public static ToolMaterial ROSEN_THORN_TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            1542, 11.5F, 3.5F, 15, ItemTags.NETHERITE_TOOL_MATERIALS);
    public static final Item ROSEN_THORN = registerItem(
            "rosen_thorn", settings ->
                    new RosenThorn(settings.sword(ROSEN_THORN_TOOL_MATERIAL, 3.5f, -2.6f).rarity(Rarity.EPIC)

    ));
    public static ToolMaterial BLUE_ROSEN_THORN_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            1542, 11.5F, 3.5F, 15, ItemTags.NETHERITE_TOOL_MATERIALS);
    public static final Item BLUE_ROSEN_THORN = registerItem(
            "blue_rosen_thorn", settings ->
                    new RosenThorn(settings.sword(BLUE_ROSEN_THORN_MATERIAL, 3.5f, -2.6f).rarity(Rarity.RARE)

                    ));
    public static ToolMaterial WITHERED_ROSEN_THORN_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            1542, 11.5F, 3.5F, 15, ItemTags.NETHERITE_TOOL_MATERIALS);
    public static final Item WITHERED_ROSEN_THORN = registerItem(
            "withered_rosen_thorn", settings ->
                    new WitheredRosenThorn(settings.sword(WITHERED_ROSEN_THORN_MATERIAL, 3.3f, -2.8f)
                    ));
    public static ToolMaterial SOVEREIGN_EDGE_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            1542, 11.5F, 3.5F, 15, ItemTags.NETHERITE_TOOL_MATERIALS);
    public static final Item SOVEREIGN_EDGE = registerItem(
            "sovereign_edge", settings ->
                    new SovereignEdge(settings.sword(SOVEREIGN_EDGE_MATERIAL, 3.5f, -3f)));
    public static final Item ROYAL_PARDON = registerItem(
            "royal_pardon", Item::new);
    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(Pulch.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Pulch.MOD_ID, name)))));
    }

    private static Item registerItem(String name, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Pulch.MOD_ID, name));
        Item item = new Item(settings.registryKey(itemKey));
        return Registry.register(Registries.ITEM, itemKey, item);
    }
    public static void registerModItems() {}
}
