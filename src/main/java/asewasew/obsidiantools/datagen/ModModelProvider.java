package asewasew.obsidiantools.datagen;

import asewasew.obsidiantools.block.ModBlocks;
import asewasew.obsidiantools.item.ModArmorMaterials;
import asewasew.obsidiantools.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

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
        itemModelGenerator.registerSpear(ModItems.OBSIDiAN_SPEAR);

        itemModelGenerator.register(ModItems.OBSIDIAN_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OBSIDIAN_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OBSIDIAN_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OBSIDIAN_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor(ModItems.OBSIDIAN_HELMET, ModArmorMaterials.OBSIDIAN_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.OBSIDIAN_CHESTPLATE, ModArmorMaterials.OBSIDIAN_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.OBSIDIAN_LEGGINGS, ModArmorMaterials.OBSIDIAN_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.OBSIDIAN_BOOTS, ModArmorMaterials.OBSIDIAN_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);

        itemModelGenerator.register(ModItems.OBSIDIAN_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.OBSIDIAN_NAUTILUS_ARMOR, Models.GENERATED);
    }
}
