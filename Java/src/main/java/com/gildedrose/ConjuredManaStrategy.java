package com.gildedrose;

public class ConjuredManaStrategy extends ItemStrategy{
    public static final String NAME = "Conjured Mana Cake";

    @Override
    void handleQuality(Item item) {
        decrementQuality(item);
        decrementQuality(item);
    }
}
