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
        if (item.name.equals(SulfurasStrategy.NAME))
            return new SulfurasStrategy();
        if (item.name.equals(AgedBrieStrategy.NAME))
            return new AgedBrieStrategy();
        if (item.name.equals(BackStagePassStrategy.NAME))
            return new BackStagePassStrategy();
        if (item.name.equals(ConjuredManaStrategy.NAME))
            return new ConjuredManaStrategy();
        return new ItemStrategy();
    }

}
