package asewasew.obsidiantools;

import asewasew.obsidiantools.block.ModBlocks;
import asewasew.obsidiantools.item.ModItems;
import asewasew.obsidiantools.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObsidianTools implements ModInitializer {

	public static final String MOD_ID = "obsidiantools";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModLootTableModifiers.modifyLootTables();
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
