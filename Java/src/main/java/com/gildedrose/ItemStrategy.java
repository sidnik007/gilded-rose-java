package com.gildedrose;

public class ItemStrategy {

    void updateQuality(Item item) {
        handleQuality(item);

        handleSellin(item);

        if (hasExpired(item)) {
            handleExpired(item);
        }
    }

    void handleQuality(Item item) {
        if (item.quality > 0) {
            decrementQuality(item);
        }
    }

    void handleSellin(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    boolean hasExpired(Item item) {
        return item.sellIn < 0;
    }

    void handleExpired(Item item) {
        if (item.quality > 0) {
            decrementQuality(item);
        }
    }

    void incrementQualityIfBelowLimit(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    void decrementQuality(Item item) {
        item.quality = item.quality - 1;
    }
}
