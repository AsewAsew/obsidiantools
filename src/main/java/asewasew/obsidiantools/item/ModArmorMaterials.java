package asewasew.obsidiantools.item;

import asewasew.obsidiantools.ObsidianTools;
import asewasew.obsidiantools.util.ModTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Util;

import java.util.EnumMap;

public class ModArmorMaterials {
    public static final ArmorMaterial OBSIDIAN_ARMOR_MATERIAL = new ArmorMaterial(35,
                Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 3); map.put(EquipmentType.LEGGINGS, 6); map.put(EquipmentType.CHESTPLATE, 8);
                map.put(EquipmentType.HELMET, 3); map.put(EquipmentType.BODY, 14);
            }), 18, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2f, 0.1f, ModTags.OBSIDIAN_REPAIR,
                    ObsidianTools.id("obsidian"));
}
