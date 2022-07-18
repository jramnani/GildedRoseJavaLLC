package com.gildedrose;

public class DefaultItem {

    protected int qualityDegradation;

    public DefaultItem() {
        this.qualityDegradation = 1;
    }

    public void age(Item item) {
        item.quality = updateQuality(item.quality, item.sellIn);
        item.sellIn = updateSellIn(item.sellIn);
    }

    private int updateQuality(int quality, int sellIn) {
        if (sellIn <= 0) {
            this.qualityDegradation = 2;
        }
        quality -= this.qualityDegradation;
        return Math.max(quality, 0);
    }

    private int updateSellIn(int sellIn) {
        return sellIn - 1;
    }

}
