package com.gildedrose;

public class AgedBrie implements Ageable {
    private int qualityIncrementation;
    private final Item item;
    private final int maxQuality;


    public AgedBrie(Item item) {
        this.item = item;
        this.qualityIncrementation = 1;
        this.maxQuality = 50;
    }

    public void age() {
        item.quality = updateQuality();
        item.sellIn = updateSellIn();
    }

    private int updateQuality() {
        if (item.sellIn <= 0) {
            this.qualityIncrementation = 2;
        }
        item.quality += this.qualityIncrementation;
        return Math.min(item.quality, maxQuality);
    }

    private int updateSellIn() {
        return item.sellIn - 1;
    }

}
