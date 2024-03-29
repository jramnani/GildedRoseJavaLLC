package com.gildedrose.items;

import com.gildedrose.goblins_grotto.Item;

public class AgedBrie implements Ageable {
    private int qualityCoefficient;
    private final Item item;
    private final int maxQuality;
    private String id;


    public AgedBrie(Item item) {
        this.item = item;
        this.qualityCoefficient = 1;
        this.maxQuality = 50;
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

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void age() {
        item.quality = updateQuality();
        item.sellIn = updateSellIn();
    }

    private int updateQuality() {
        if (item.sellIn <= 0) {
            this.qualityCoefficient = 2;
        }
        item.quality += this.qualityCoefficient;
        return Math.min(item.quality, maxQuality);
    }

    private int updateSellIn() {
        return item.sellIn - 1;
    }

}
