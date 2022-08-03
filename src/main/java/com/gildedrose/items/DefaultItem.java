package com.gildedrose.items;

import com.gildedrose.goblins_grotto.Item;

public class DefaultItem implements Ageable {

    private final Item item;
    private final int minQuality;
    protected int qualityCoefficient;
    private final float markUp;

    public DefaultItem(Item item) {
        this.item = item;
        this.qualityCoefficient = 1;
        this.minQuality = 0;
        this.markUp = 1.3f;
    }

    public void age() {
        item.quality = updateQuality();
        item.sellIn = updateSellIn();
    }

    public String getName() {
        return this.item.name;
    }

    public float getPrice() {
        return this.item.quality * markUp;
    }

    public int getQuality() {
        return item.quality;
    }

    public int getSellIn() {
        return item.sellIn;
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
