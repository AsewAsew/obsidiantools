package asewasew.obsidiantools.datagen;

import asewasew.obsidiantools.block.ModBlocks;
import asewasew.obsidiantools.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

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

        itemModelGenerator.registerArmor((ArmorItem) ModItems.OBSIDIAN_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.OBSIDIAN_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.OBSIDIAN_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.OBSIDIAN_BOOTS);

        itemModelGenerator.register(ModItems.OBSIDIAN_HORSE_ARMOR, Models.GENERATED);
    }
}
