package com.gildedrose;

public class BackStagePassStrategy extends ItemStrategy {
    public static final String NAME = "Backstage passes to a TAFKAL80ETC concert";

    @Override
    void handleQuality(Item item) {
        incrementQualityIfBelowLimit(item);
        if (item.sellIn < 11) {
            incrementQualityIfBelowLimit(item);
        }
        if (item.sellIn < 6) {
            incrementQualityIfBelowLimit(item);
        }
    }

    @Override
    void handleExpired(Item item) {
        item.quality = 0;
    }
}
