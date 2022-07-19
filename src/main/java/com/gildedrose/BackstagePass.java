package com.gildedrose;

public class BackstagePass implements Ageable {
    private int qualityIncrementation;

    public BackstagePass() {
        this.qualityIncrementation = 1;
    }

    public void age(Item item) {
        item.quality = updateQuality(item.quality, item.sellIn);
        item.sellIn = updateSellIn(item.sellIn);
    }

    private int updateQuality(int quality, int sellIn) {
        if (sellIn <= 10
                && sellIn > 5) {
            this.qualityIncrementation = 2;
        } else if (sellIn <= 5
                && sellIn > 0) {
            this.qualityIncrementation = 3;
        } else if (sellIn == 0) {
            this.qualityIncrementation = -(quality);
        }
        quality += qualityIncrementation;
        return Math.min(quality, 50);
    }

    private int updateSellIn(int sellIn) {
        return sellIn - 1;
    }

}
