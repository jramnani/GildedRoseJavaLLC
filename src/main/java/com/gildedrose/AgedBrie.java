package com.gildedrose;

public class AgedBrie implements Ageable {
    private int qualityIncrementation;
    private final Item item;

    public AgedBrie(Item item) {
        this.item = item;
        this.qualityIncrementation = 1;
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
        return Math.min(item.quality, 50);
    }

    private int updateSellIn() {
        return item.sellIn - 1;
    }

}
