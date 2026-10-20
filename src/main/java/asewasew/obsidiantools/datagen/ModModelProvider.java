package asewasew.obsidiantools.datagen;

import asewasew.obsidiantools.ObsidianTools;
import asewasew.obsidiantools.block.ModBlocks;
import asewasew.obsidiantools.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.equipment.EquipmentModel;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.REFINED_OBSIDIAN_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.OBSIDIAN_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.REFINED_OBSIDIAN, Models.GENERATED);

        itemModelGenerator.register(ModItems.OBSIDIAN_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OBSIDIAN_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OBSIDIAN_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OBSIDIAN_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OBSIDIAN_HOE, Models.HANDHELD);

        Identifier obsidianId = ObsidianTools.id("obsidian");
        itemModelGenerator.registerArmor(ModItems.OBSIDIAN_HELMET, obsidianId,
                EquipmentModel.builder().addHumanoidLayers(obsidianId).build(), EquipmentSlot.HEAD);
        itemModelGenerator.registerArmor(ModItems.OBSIDIAN_CHESTPLATE, obsidianId,
                EquipmentModel.builder().addHumanoidLayers(obsidianId).build(), EquipmentSlot.CHEST);
        itemModelGenerator.registerArmor(ModItems.OBSIDIAN_LEGGINGS, obsidianId,
                EquipmentModel.builder().addHumanoidLayers(obsidianId).build(), EquipmentSlot.LEGS);
        itemModelGenerator.registerArmor(ModItems.OBSIDIAN_BOOTS, obsidianId,
                EquipmentModel.builder().addHumanoidLayers(obsidianId).build(), EquipmentSlot.FEET);

        itemModelGenerator.register(ModItems.OBSIDIAN_HORSE_ARMOR, Models.GENERATED);
    }
}
