package com.gildedrose;

public class Conjured extends DefaultItem {
    private int conjuredQualityDegradation;

    public Conjured() {
        this.conjuredQualityDegradation = super.qualityDegradation * 2;
    }

    public void age(Item item) {
        item.quality = updateQuality(item.quality, item.sellIn);
        item.sellIn = updateSellIn(item.sellIn);
    }

    private int updateQuality(int quality, int sellIn) {
        if (sellIn <= 0) {
            conjuredQualityDegradation = super.qualityDegradation * 2;
        }
        quality -= conjuredQualityDegradation;
        return Math.max(quality, 0);
    }

    private int updateSellIn(int sellIn) {
        return sellIn - 1;
    }

}
