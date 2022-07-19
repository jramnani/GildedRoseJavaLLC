package com.gildedrose;

public class DefaultItem implements Ageable {

    private final Item item;
    protected int qualityDegradation;

    public DefaultItem(Item item) {
        this.item = item;
        this.qualityDegradation = 1;
    }

    public void age() {
        item.quality = updateQuality();
        item.sellIn = updateSellIn();
    }

    private int updateQuality() {
        if (item.sellIn <= 0) {
            this.qualityDegradation = 2;
        }
        item.quality -= this.qualityDegradation;
        return Math.max(item.quality, 0);
    }

    private int updateSellIn() {
        return item.sellIn - 1;
    }

}
