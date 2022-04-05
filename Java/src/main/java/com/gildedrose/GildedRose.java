package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateQuality(item);
        }
    }

    private void updateQuality(Item item) {
        handleQuality(item);

        handleSellin(item);

        if (hasExpired(item)) {
            handleExpired(item);
        }
    }

    private void handleQuality(Item item) {
        if (item.name.equals("Aged Brie")) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            inlineMeSoon(item);
        } else {
            if (item.quality > 0) {
                if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    return;
                }
                item.quality = item.quality - 1;
            }
        }
    }

    private void inlineMeSoon(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.sellIn < 11) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }

                if (item.sellIn < 6) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }

    private void handleSellin(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }
        item.sellIn = item.sellIn - 1;
    }

    private void handleExpired(Item item) {
        if (item.name.equals("Aged Brie")) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        } else {
            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                item.quality = item.quality - item.quality;
            } else {
                if (item.quality > 0) {
                    if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        return;
                    }
                    item.quality = item.quality - 1;
                }
            }
        }
    }

    private boolean hasExpired(Item item) {
        return item.sellIn < 0;
    }
}
