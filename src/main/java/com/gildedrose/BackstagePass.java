package com.gildedrose;

public class BackstagePass implements Ageable {
    private int qualityIncrementation;
    private final Item item;

    public BackstagePass(Item item) {
        this.item = item;
        this.qualityIncrementation = 1;
    }

    public void age() {
        item.quality = updateQuality();
        item.sellIn = updateSellIn();
    }

    private int updateQuality() {
        if (item.sellIn <= 10
                && item.sellIn > 5) {
            this.qualityIncrementation = 2;
        } else if (item.sellIn <= 5
                && item.sellIn > 0) {
            this.qualityIncrementation = 3;
        } else if (item.sellIn == 0) {
            this.qualityIncrementation = -(item.quality);
        }
        item.quality += qualityIncrementation;
        return Math.min(item.quality, 50);
    }

    private int updateSellIn() {
        return item.sellIn - 1;
    }

}
