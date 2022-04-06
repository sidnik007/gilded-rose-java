package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

public class InventoryFactory {
    private Map<String, ItemStrategy> strategyMap;

    public InventoryFactory() {
        strategyMap = new HashMap<>();
        strategyMap.put(SulfurasStrategy.NAME, new SulfurasStrategy());
        strategyMap.put(AgedBrieStrategy.NAME, new AgedBrieStrategy());
        strategyMap.put(BackStagePassStrategy.NAME, new BackStagePassStrategy());
        strategyMap.put(ConjuredManaStrategy.NAME, new ConjuredManaStrategy());
    }

    public ItemStrategy createFor(Item item) {
        return strategyMap.getOrDefault(item.name, new ItemStrategy());
    }
}
