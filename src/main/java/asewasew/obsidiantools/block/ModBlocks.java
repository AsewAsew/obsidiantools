package asewasew.obsidiantools.block;

import asewasew.obsidiantools.ObsidianTools;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static Block REFINED_OBSIDIAN_BLOCK = registerBlock(
            new Block(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, ObsidianTools.id("refined_obsidian_block")))
                    .strength(55f, 1200f)
                    .mapColor(MapColor.BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().pistonBehavior(PistonBehavior.BLOCK)));

    private static Block registerBlock(Block block) {
        Identifier id = ObsidianTools.id("refined_obsidian_block");
        Registry.register(Registries.ITEM, id, new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                .registryKey(RegistryKey.of(RegistryKeys.ITEM, id)).fireproof()));
        return Registry.register(Registries.BLOCK, id, block);
    }
    
    public static void registerModBlocks() {
        ObsidianTools.LOGGER.info("Registering Mod Blocks for " + ObsidianTools.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries ->
                entries.addAfter(Blocks.CRYING_OBSIDIAN, REFINED_OBSIDIAN_BLOCK));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries ->
                entries.addAfter(Blocks.CRYING_OBSIDIAN, REFINED_OBSIDIAN_BLOCK));
    }
}
