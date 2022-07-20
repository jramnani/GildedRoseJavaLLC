package com.gildedrose;

public class Conjured extends DefaultItem {
    private final int conjuredQualityCoefficientPastSellIn;
    private final int conjuredQualityCoefficient;
    private final Item item;
    private final int minQuality;

    public Conjured(Item item) {
        super(item);
        this.item = item;
        this.conjuredQualityCoefficient = super.qualityCoefficient * 2;
        this.conjuredQualityCoefficientPastSellIn = this.conjuredQualityCoefficient * 2;
        this.minQuality = 0;
    }

    @Override
    public void age() {
        item.quality = updateQuality();
        item.sellIn = super.updateSellIn();
    }

    private int updateQuality() {
        if (item.sellIn <= 0) {
            item.quality -= conjuredQualityCoefficientPastSellIn;
        }
        else {
            item.quality -= conjuredQualityCoefficient;
        }

        return Math.max(item.quality, minQuality);
    }

}
