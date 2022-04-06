package com.gildedrose;

public class AgedBrieStrategy extends ItemStrategy {

    @Override
    void handleQuality(Item item) {
        incrementQualityIfBelowLimit(item);
    }

    @Override
    void handleExpired(Item item) {
        incrementQualityIfBelowLimit(item);
    }
}
