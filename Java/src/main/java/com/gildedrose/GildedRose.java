package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemStrategy strategy = createFor(item);
            strategy.updateQuality(item);
        }
    }

    private ItemStrategy createFor(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros"))
            return new SulfurasStrategy();
        if (item.name.equals("Aged Brie"))
            return new AgedBrieStrategy();
        return new ItemStrategy();
    }

}
