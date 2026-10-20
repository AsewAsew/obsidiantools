package asewasew.obsidiantools.datagen;

import asewasew.obsidiantools.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(ItemTags.SWORDS).add(ModItems.OBSIDIAN_SWORD);

        getOrCreateTagBuilder(ItemTags.SHOVELS).add(ModItems.OBSIDIAN_SHOVEL);
        getOrCreateTagBuilder(ItemTags.PICKAXES).add(ModItems.OBSIDIAN_PICKAXE);
        getOrCreateTagBuilder(ItemTags.AXES).add(ModItems.OBSIDIAN_AXE);
        getOrCreateTagBuilder(ItemTags.HOES).add(ModItems.OBSIDIAN_HOE);

        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR).add(ModItems.OBSIDIAN_BOOTS);
        getOrCreateTagBuilder(ItemTags.LEG_ARMOR).add(ModItems.OBSIDIAN_LEGGINGS);
        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR).add(ModItems.OBSIDIAN_CHESTPLATE);
        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR).add(ModItems.OBSIDIAN_HELMET);
    }
}
