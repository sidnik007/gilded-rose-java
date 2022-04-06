package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        InventoryFactory factory = new InventoryFactory();
        for (Item item : items) {
            ItemStrategy strategy = factory.createFor(item);
            strategy.updateQuality(item);
        }
    }
}
