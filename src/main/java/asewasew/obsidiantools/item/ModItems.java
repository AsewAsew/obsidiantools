package asewasew.obsidiantools.item;

import asewasew.obsidiantools.ObsidianTools;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import java.util.function.Function;

public class ModItems {
    public static final Item OBSIDIAN_SHARD = registerItem("obsidian_shard", Item::new);
    public static final Item REFINED_OBSIDIAN = registerItem("refined_obsidian", Item::new);

    public static final Item OBSIDIAN_SWORD = registerItem("obsidian_sword",
            settings -> new Item(settings.sword(ModToolMaterials.OBSIDIAN, 3, -2.4F)));
    public static final Item OBSIDIAN_SHOVEL = registerItem("obsidian_shovel",
            settings -> new Item(settings.shovel(ModToolMaterials.OBSIDIAN, 1.5f, -3.0f)));
    public static final Item OBSIDIAN_PICKAXE = registerItem("obsidian_pickaxe",
            settings -> new Item(settings.pickaxe(ModToolMaterials.OBSIDIAN, 1, -2.8f)));
    public static final Item OBSIDIAN_AXE = registerItem("obsidian_axe",
            settings -> new Item(settings.axe(ModToolMaterials.OBSIDIAN, 5, -3.0f)));
    public static final Item OBSIDIAN_HOE = registerItem("obsidian_hoe",
            settings -> new Item(settings.hoe(ModToolMaterials.OBSIDIAN, -3, 0.0f)));

    public static final Item OBSIDIAN_HELMET = registerItem("obsidian_helmet",
            settings -> new Item(settings.armor(ModArmorMaterials.OBSIDIAN_ARMOR_MATERIAL, EquipmentType.HELMET)));
    public static final Item OBSIDIAN_CHESTPLATE = registerItem("obsidian_chestplate",
            settings -> new Item(settings.armor(ModArmorMaterials.OBSIDIAN_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)));
    public static final Item OBSIDIAN_LEGGINGS = registerItem("obsidian_leggings",
            settings -> new Item(settings.armor(ModArmorMaterials.OBSIDIAN_ARMOR_MATERIAL, EquipmentType.LEGGINGS)));
    public static final Item OBSIDIAN_BOOTS = registerItem("obsidian_boots",
            settings -> new Item(settings.armor(ModArmorMaterials.OBSIDIAN_ARMOR_MATERIAL, EquipmentType.BOOTS)));

    public static final Item OBSIDIAN_HORSE_ARMOR = registerItem("obsidian_horse_armor",
            settings -> new Item(settings.horseArmor(ModArmorMaterials.OBSIDIAN_ARMOR_MATERIAL)));


    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, ObsidianTools.id(name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, ObsidianTools.id(name))).fireproof()));
    }
    
    public static void registerModItems() {
        ObsidianTools.LOGGER.info("Registering Mod Items for " + ObsidianTools.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.addAfter(Items.GOLD_NUGGET, OBSIDIAN_SHARD);
            entries.addAfter(Items.DIAMOND, REFINED_OBSIDIAN);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.addAfter(Items.DIAMOND_HOE, OBSIDIAN_SHOVEL);
            entries.addAfter(OBSIDIAN_SHOVEL, OBSIDIAN_PICKAXE);
            entries.addAfter(OBSIDIAN_PICKAXE, OBSIDIAN_AXE);
            entries.addAfter(OBSIDIAN_AXE, OBSIDIAN_HOE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.addAfter(Items.DIAMOND_SWORD, OBSIDIAN_SWORD);
            entries.addAfter(Items.DIAMOND_AXE, OBSIDIAN_AXE);

            entries.addAfter(Items.DIAMOND_BOOTS, OBSIDIAN_HELMET);
            entries.addAfter(OBSIDIAN_HELMET, OBSIDIAN_CHESTPLATE);
            entries.addAfter(OBSIDIAN_CHESTPLATE, OBSIDIAN_LEGGINGS);
            entries.addAfter(OBSIDIAN_LEGGINGS, OBSIDIAN_BOOTS);

            entries.addAfter(Items.DIAMOND_HORSE_ARMOR, OBSIDIAN_HORSE_ARMOR);
        });
    }
}
