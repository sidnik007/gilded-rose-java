package com.gildedrose;

public class AgedBrieStrategy extends ItemStrategy {
    public static final String NAME = "Aged Brie";

    @Override
    void handleQuality(Item item) {
        incrementQualityIfBelowLimit(item);
    }

    @Override
    void handleExpired(Item item) {
        incrementQualityIfBelowLimit(item);
    }
}
