package com.gildedrose.items;

import com.gildedrose.goblins_grotto.Item;

public class DefaultItem implements Ageable {

    private final Item item;
    private final int minQuality;
    protected int qualityCoefficient;

    public DefaultItem(Item item) {
        this.item = item;
        this.qualityCoefficient = 1;
        this.minQuality = 0;
    }

    public void age() {
        item.quality = updateQuality();
        item.sellIn = updateSellIn();
    }

    private int updateQuality() {
        if (item.sellIn <= 0) {
            this.qualityCoefficient = 2;
        }
        item.quality -= this.qualityCoefficient;
        return Math.max(item.quality, minQuality);
    }

    protected int updateSellIn() {
        return item.sellIn - 1;
    }

}
