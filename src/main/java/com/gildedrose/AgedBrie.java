package com.gildedrose;

public class AgedBrie implements Ageable {
    private int qualityIncrementation;

    public AgedBrie() {
        this.qualityIncrementation = 1;
    }

    public void age(Item item) {
        item.quality = updateQuality(item.quality, item.sellIn);
        item.sellIn = updateSellIn(item.sellIn);
    }

    private int updateQuality(int quality, int sellIn) {
        if (sellIn <= 0) {
            this.qualityIncrementation = 2;
        }
        quality += this.qualityIncrementation;
        return Math.min(quality, 50);
    }

    private int updateSellIn(int sellIn) {
        return sellIn - 1;
    }

}
