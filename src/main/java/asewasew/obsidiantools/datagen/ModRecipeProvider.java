package asewasew.obsidiantools.datagen;

import asewasew.obsidiantools.block.ModBlocks;
import asewasew.obsidiantools.item.ModItems;
import com.mojang.datafixers.util.Pair;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registries, RecipeExporter exporter) {
        return new RecipeGenerator(registries, exporter) {
            @Override
            public void generate() {
                offerSmelting(List.of(Items.OBSIDIAN), RecipeCategory.MISC, ModItems.OBSIDIAN_SHARD, 0.1f, 800, "obsidian");
                offerBlasting(List.of(Items.OBSIDIAN), RecipeCategory.MISC, ModItems.OBSIDIAN_SHARD, 0.1f, 400, "obsidian");

                List<ItemConvertible> items = List.of(ModItems.OBSIDIAN_SHOVEL, ModItems.OBSIDIAN_PICKAXE, ModItems.OBSIDIAN_AXE, ModItems.OBSIDIAN_HOE,
                        ModItems.OBSIDIAN_SWORD, ModItems.OBSIDIAN_BOOTS, ModItems.OBSIDIAN_LEGGINGS, ModItems.OBSIDIAN_CHESTPLATE, ModItems.OBSIDIAN_HELMET);

                offerSmelting(items, RecipeCategory.MISC, ModItems.OBSIDIAN_SHARD, 0.1f, 200, "obsidian");
                offerBlasting(items, RecipeCategory.MISC, ModItems.OBSIDIAN_SHARD, 0.1f, 100, "obsidian");

                createShaped(RecipeCategory.MISC, ModItems.REFINED_OBSIDIAN)
                        .pattern("###").pattern("###").pattern("###").input('#', ModItems.OBSIDIAN_SHARD)
                        .criterion(hasItem(ModItems.OBSIDIAN_SHARD), conditionsFromItem(ModItems.OBSIDIAN_SHARD))
                        .offerTo(exporter, "refined_obsidian_from_shards");
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.REFINED_OBSIDIAN_BLOCK)
                        .pattern("###").pattern("###").pattern("###").input('#', ModItems.REFINED_OBSIDIAN)
                        .criterion(hasItem(ModItems.REFINED_OBSIDIAN), conditionsFromItem(ModItems.REFINED_OBSIDIAN))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.MISC, ModItems.REFINED_OBSIDIAN, 9).input(ModBlocks.REFINED_OBSIDIAN_BLOCK)
                        .criterion(hasItem(ModBlocks.REFINED_OBSIDIAN_BLOCK.asItem()), conditionsFromItem(ModBlocks.REFINED_OBSIDIAN_BLOCK.asItem()))
                        .offerTo(exporter, "refined_obsidian_from_refined_obsidian_block");
                createShapeless(RecipeCategory.MISC, ModItems.OBSIDIAN_SHARD, 9).input(ModItems.REFINED_OBSIDIAN)
                        .criterion(hasItem(ModItems.REFINED_OBSIDIAN), conditionsFromItem(ModItems.REFINED_OBSIDIAN))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.OBSIDIAN_SHOVEL)
                        .pattern("#").pattern("S").pattern("S").input('#', ModItems.REFINED_OBSIDIAN).input('S', Items.STICK)
                        .criterion(hasItem(ModItems.REFINED_OBSIDIAN), conditionsFromItem(ModItems.REFINED_OBSIDIAN)).offerTo(exporter);
                createShaped(RecipeCategory.TOOLS, ModItems.OBSIDIAN_PICKAXE)
                        .pattern("###").pattern(" S ").pattern(" S ").input('#', ModItems.REFINED_OBSIDIAN).input('S', Items.STICK)
                        .criterion(hasItem(ModItems.REFINED_OBSIDIAN), conditionsFromItem(ModItems.REFINED_OBSIDIAN)).offerTo(exporter);
                createShaped(RecipeCategory.TOOLS, ModItems.OBSIDIAN_AXE)
                        .pattern("##").pattern("#S").pattern(" S").input('#', ModItems.REFINED_OBSIDIAN).input('S', Items.STICK)
                        .criterion(hasItem(ModItems.REFINED_OBSIDIAN), conditionsFromItem(ModItems.REFINED_OBSIDIAN)).offerTo(exporter);
                createShaped(RecipeCategory.TOOLS, ModItems.OBSIDIAN_HOE)
                        .pattern("##").pattern(" S").pattern(" S").input('#', ModItems.REFINED_OBSIDIAN).input('S', Items.STICK)
                        .criterion(hasItem(ModItems.REFINED_OBSIDIAN), conditionsFromItem(ModItems.REFINED_OBSIDIAN)).offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.OBSIDIAN_SWORD)
                        .pattern("#").pattern("#").pattern("S").input('#', ModItems.REFINED_OBSIDIAN).input('S', Items.STICK)
                        .criterion(hasItem(ModItems.REFINED_OBSIDIAN), conditionsFromItem(ModItems.REFINED_OBSIDIAN)).offerTo(exporter);
                createShaped(RecipeCategory.COMBAT, ModItems.OBSIDIAN_BOOTS)
                        .pattern("# #").pattern("# #").input('#', ModItems.REFINED_OBSIDIAN)
                        .criterion(hasItem(ModItems.REFINED_OBSIDIAN), conditionsFromItem(ModItems.REFINED_OBSIDIAN)).offerTo(exporter);
                createShaped(RecipeCategory.COMBAT, ModItems.OBSIDIAN_LEGGINGS)
                        .pattern("###").pattern("# #").pattern("# #").input('#', ModItems.REFINED_OBSIDIAN)
                        .criterion(hasItem(ModItems.REFINED_OBSIDIAN), conditionsFromItem(ModItems.REFINED_OBSIDIAN)).offerTo(exporter);
                createShaped(RecipeCategory.COMBAT, ModItems.OBSIDIAN_CHESTPLATE)
                        .pattern("# #").pattern("###").pattern("###").input('#', ModItems.REFINED_OBSIDIAN)
                        .criterion(hasItem(ModItems.REFINED_OBSIDIAN), conditionsFromItem(ModItems.REFINED_OBSIDIAN)).offerTo(exporter);
                createShaped(RecipeCategory.COMBAT, ModItems.OBSIDIAN_HELMET)
                        .pattern("###").pattern("# #").input('#', ModItems.REFINED_OBSIDIAN)
                        .criterion(hasItem(ModItems.REFINED_OBSIDIAN), conditionsFromItem(ModItems.REFINED_OBSIDIAN)).offerTo(exporter);

                for(Pair<Item, Item> pair : List.of(Pair.of(ModItems.OBSIDIAN_SHOVEL, Items.NETHERITE_SHOVEL), Pair.of(ModItems.OBSIDIAN_PICKAXE, Items.NETHERITE_PICKAXE), Pair.of(ModItems.OBSIDIAN_AXE, Items.NETHERITE_AXE), Pair.of(ModItems.OBSIDIAN_HOE, Items.NETHERITE_HOE),
                        Pair.of(ModItems.OBSIDIAN_SWORD, Items.NETHERITE_SWORD), Pair.of(ModItems.OBSIDIAN_BOOTS, Items.NETHERITE_BOOTS), Pair.of(ModItems.OBSIDIAN_LEGGINGS, Items.NETHERITE_LEGGINGS), Pair.of(ModItems.OBSIDIAN_CHESTPLATE, Items.NETHERITE_CHESTPLATE), Pair.of(ModItems.OBSIDIAN_HELMET, Items.NETHERITE_HELMET))) {
                    SmithingTransformRecipeJsonBuilder.create(
                                    Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                                    Ingredient.ofItems(pair.getFirst()), Ingredient.ofItems(Items.NETHERITE_INGOT),
                                    RecipeCategory.TOOLS, pair.getSecond())
                            .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                            .offerTo(exporter, Registries.ITEM.getId(pair.getSecond()).getPath() + "_from_"
                                    + Registries.ITEM.getId(pair.getFirst()).getPath() + "_smithing");
                }
            }
        };
    }

    @Override
    public String getName() {
        return "";
    }
}
