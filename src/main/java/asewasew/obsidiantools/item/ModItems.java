package asewasew.obsidiantools.item;

import asewasew.obsidiantools.ObsidianTools;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import java.util.function.Function;

public class ModItems {
    public static final Item OBSIDIAN_SHARD = registerItem("obsidian_shard", Item::new);
    public static final Item REFINED_OBSIDIAN = registerItem("refined_obsidian", Item::new);

    public static final Item OBSIDIAN_SWORD = registerItem("obsidian_sword",
            settings -> new SwordItem(ModToolMaterials.OBSIDIAN, settings
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.OBSIDIAN, 3, -2.4F))));
    public static final Item OBSIDIAN_SHOVEL = registerItem("obsidian_shovel",
            settings -> new ShovelItem(ModToolMaterials.OBSIDIAN, settings
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.OBSIDIAN, 1.5f, -3.0f))));
    public static final Item OBSIDIAN_PICKAXE = registerItem("obsidian_pickaxe",
            settings -> new PickaxeItem(ModToolMaterials.OBSIDIAN, settings
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.OBSIDIAN, 1, -2.8f))));
    public static final Item OBSIDIAN_AXE = registerItem("obsidian_axe",
            settings -> new AxeItem(ModToolMaterials.OBSIDIAN, settings
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.OBSIDIAN, 5, -3.0f))));
    public static final Item OBSIDIAN_HOE = registerItem("obsidian_hoe",
            settings -> new HoeItem(ModToolMaterials.OBSIDIAN, settings
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.OBSIDIAN, -3, 0.0f))));

    public static final Item OBSIDIAN_HELMET = registerItem("obsidian_helmet",
            settings -> new ArmorItem(ModArmorMaterials.OBSIDIAN_ARMOR_MATERIAL, ArmorItem.Type.HELMET, settings
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(35))));
    public static final Item OBSIDIAN_CHESTPLATE = registerItem("obsidian_chestplate",
            settings -> new ArmorItem(ModArmorMaterials.OBSIDIAN_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, settings
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(35))));
    public static final Item OBSIDIAN_LEGGINGS = registerItem("obsidian_leggings",
            settings -> new ArmorItem(ModArmorMaterials.OBSIDIAN_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, settings
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(35))));
    public static final Item OBSIDIAN_BOOTS = registerItem("obsidian_boots",
            settings -> new ArmorItem(ModArmorMaterials.OBSIDIAN_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, settings
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(35))));

    public static final Item OBSIDIAN_HORSE_ARMOR = registerItem("obsidian_horse_armor",
            settings -> new AnimalArmorItem(ModArmorMaterials.OBSIDIAN_ARMOR_MATERIAL, AnimalArmorItem.Type.EQUESTRIAN, false, settings.maxCount(1)));


    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, ObsidianTools.id(name),
                function.apply(new Item.Settings().fireproof()));
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
