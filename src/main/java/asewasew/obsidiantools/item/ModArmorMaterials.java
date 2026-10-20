package asewasew.obsidiantools.item;

import asewasew.obsidiantools.ObsidianTools;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {
    public static final RegistryEntry<ArmorMaterial> OBSIDIAN_ARMOR_MATERIAL = registerArmorMaterial("obsidian",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 14);
            }), 18, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(ModItems.REFINED_OBSIDIAN),
                    List.of(new ArmorMaterial.Layer(ObsidianTools.id("obsidian"))), 2f, 0.1f));

    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material) {
        return Registry.registerReference(Registries.ARMOR_MATERIAL, ObsidianTools.id(name), material.get());
    }
}
