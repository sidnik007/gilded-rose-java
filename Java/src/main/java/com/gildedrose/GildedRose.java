package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemStrategy strategy = new ItemStrategy();
            updateQuality(item, strategy);
        }
    }

    private void updateQuality(Item item, ItemStrategy strategy) {
        handleQuality(item, strategy);

        handleSellin(item, strategy);

        if (hasExpired(item, strategy)) {
            handleExpired(item, strategy);
        }
    }

    private void handleQuality(Item item, ItemStrategy strategy) {
        if (item.name.equals("Aged Brie")) {
            incrementQualityIfBelowLimit(item, strategy);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (item.sellIn < 11) {
                    incrementQualityIfBelowLimit(item, strategy);
                }

                if (item.sellIn < 6) {
                    incrementQualityIfBelowLimit(item, strategy);
                }
            }
        } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        } else if (item.quality > 0) {
           decrementQuality(item, strategy);
        }
    }

    private void incrementQualityIfBelowLimit(Item item, ItemStrategy strategy) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void handleSellin(Item item, ItemStrategy strategy) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }
        item.sellIn = item.sellIn - 1;
    }

    private void handleExpired(Item item, ItemStrategy strategy) {
        if (item.name.equals("Aged Brie")) {
            incrementQualityIfBelowLimit(item, strategy);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.quality = item.quality - item.quality;
        } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        } else if (item.quality > 0) {
            decrementQuality(item, strategy);
        }
    }

    private void decrementQuality(Item item, ItemStrategy strategy) {
        item.quality = item.quality - 1;
    }

    private boolean hasExpired(Item item, ItemStrategy strategy) {
        return item.sellIn < 0;
    }
}
