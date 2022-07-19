package com.gildedrose;

public class Conjured extends DefaultItem {
    private int conjuredQualityDegradation;
    private final Item item;

    public Conjured(Item item) {
        super(item);
        this.item = item;
        this.conjuredQualityDegradation = super.qualityDegradation * 2;
    }

    @Override
    public void age() {
        item.quality = updateQuality();
        item.sellIn = updateSellIn();
    }

    private int updateQuality() {
        if (item.sellIn <= 0) {
            conjuredQualityDegradation = conjuredQualityDegradation * 2;
        }
        item.quality -= conjuredQualityDegradation;
        return Math.max(item.quality, 0);
    }

    private int updateSellIn() {
        return item.sellIn - 1;
    }

}
