package com.gildedrose.items;

import com.gildedrose.goblins_grotto.Item;

public class BackstagePass implements Ageable {
    private final int maxQuality;
    private int qualityCoefficient;
    private final Item item;
    private final float markUp;

    public BackstagePass(Item item) {
        this.item = item;
        this.qualityCoefficient = 1;
        this.maxQuality = 50;
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
        if (item.sellIn <= 10
                && item.sellIn > 5) {
            this.qualityCoefficient = 2;
        } else if (item.sellIn <= 5
                && item.sellIn > 0) {
            this.qualityCoefficient = 3;
        } else if (item.sellIn == 0) {
            this.qualityCoefficient = -(item.quality);
        }
        item.quality += qualityCoefficient;
        return Math.min(item.quality, maxQuality);
    }

    private int updateSellIn() {
        return item.sellIn - 1;
    }

}
