package asewasew.obsidiantools.util;

import asewasew.obsidiantools.ObsidianTools;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class ModTags {
    public static final TagKey<Block> NEEDS_OBSIDIAN_TOOL = createTag("needs_obsidian_tool");
    public static final TagKey<Block> INCORRECT_FOR_OBSIDIAN_TOOL = createTag("incorrect_for_obsidian_tool");

    public static final TagKey<Block> NETHER_PORTAL_FRAME_BLOCKS = createTag("nether_portal_frame_blocks");

    public static final TagKey<Item> OBSIDIAN_REPAIR = TagKey.of(RegistryKeys.ITEM, ObsidianTools.id("obsidian_repair"));

    private static TagKey<Block> createTag(String name) {
        return TagKey.of(RegistryKeys.BLOCK, ObsidianTools.id(name));
    }
}
