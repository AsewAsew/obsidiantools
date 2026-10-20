package asewasew.obsidiantools.util;

import asewasew.obsidiantools.item.ModItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier OBSIDIAN_BLOCK_ID = Identifier.ofVanilla("blocks/obsidian");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register(((key, tableBuilder, source, registries) -> {
            if(OBSIDIAN_BLOCK_ID.equals(key.getValue())) {
                ConstantLootNumberProvider con = ConstantLootNumberProvider.create(1);
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(con)
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(ModItems.OBSIDIAN_SHARD))
                        .apply(SetCountLootFunction.builder(con));

                tableBuilder.pool(poolBuilder.build());
            }

            if(LootTables.ANCIENT_CITY_ICE_BOX_CHEST.equals(key)) {
                ConstantLootNumberProvider con = ConstantLootNumberProvider.create(1);
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(con)
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(ModItems.OBSIDIAN_HORSE_ARMOR))
                        .apply(SetCountLootFunction.builder(con));

                tableBuilder.pool(poolBuilder.build());
            }
        }));
    }
}
