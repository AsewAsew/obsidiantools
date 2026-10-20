package asewasew.obsidiantools.datagen;

import asewasew.obsidiantools.block.ModBlocks;
import asewasew.obsidiantools.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(ModTags.NETHER_PORTAL_FRAME_BLOCKS).add(Blocks.OBSIDIAN)
                .add(Blocks.CRYING_OBSIDIAN).add(ModBlocks.REFINED_OBSIDIAN_BLOCK);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.REFINED_OBSIDIAN_BLOCK);

        getTagBuilder(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.REFINED_OBSIDIAN_BLOCK);

        getOrCreateTagBuilder(ModTags.INCORRECT_FOR_OBSIDIAN_TOOL).addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);
        getOrCreateTagBuilder(ModTags.NEEDS_OBSIDIAN_TOOL).addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        getOrCreateTagBuilder(BlockTags.DRAGON_IMMUNE).add(ModBlocks.REFINED_OBSIDIAN_BLOCK);
        getOrCreateTagBuilder(BlockTags.WITHER_IMMUNE).add(ModBlocks.REFINED_OBSIDIAN_BLOCK);
    }
}
