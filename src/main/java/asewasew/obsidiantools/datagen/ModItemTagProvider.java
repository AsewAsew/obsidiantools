package asewasew.obsidiantools.datagen;

import asewasew.obsidiantools.item.ModItems;
import asewasew.obsidiantools.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.@NonNull WrapperLookup lookup) {
        valueLookupBuilder(ModTags.OBSIDIAN_REPAIR).add(ModItems.REFINED_OBSIDIAN);

        valueLookupBuilder(ItemTags.SWORDS).add(ModItems.OBSIDIAN_SWORD);
        valueLookupBuilder(ItemTags.SPEARS).add(ModItems.OBSIDiAN_SPEAR);

        valueLookupBuilder(ItemTags.SHOVELS).add(ModItems.OBSIDIAN_SHOVEL);
        valueLookupBuilder(ItemTags.PICKAXES).add(ModItems.OBSIDIAN_PICKAXE);
        valueLookupBuilder(ItemTags.AXES).add(ModItems.OBSIDIAN_AXE);
        valueLookupBuilder(ItemTags.HOES).add(ModItems.OBSIDIAN_HOE);

        valueLookupBuilder(ItemTags.FOOT_ARMOR).add(ModItems.OBSIDIAN_BOOTS);
        valueLookupBuilder(ItemTags.LEG_ARMOR).add(ModItems.OBSIDIAN_LEGGINGS);
        valueLookupBuilder(ItemTags.CHEST_ARMOR).add(ModItems.OBSIDIAN_CHESTPLATE);
        valueLookupBuilder(ItemTags.HEAD_ARMOR).add(ModItems.OBSIDIAN_HELMET);
    }
}
