package com.gildedrose;

public class BackStagePassStrategy extends ItemStrategy {

    @Override
    void handleQuality(Item item) {
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (item.sellIn < 11) {
                    incrementQualityIfBelowLimit(item);
                }

                if (item.sellIn < 6) {
                    incrementQualityIfBelowLimit(item);
                }
            }
        }
    }

    @Override
    void handleExpired(Item item) {
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.quality = item.quality - item.quality;
        }
    }
}
