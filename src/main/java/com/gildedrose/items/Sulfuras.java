package com.gildedrose.items;

import com.gildedrose.goblins_grotto.Item;

public class Sulfuras implements Ageable {

    private final Item item;
    private final float markUp;

    public Sulfuras(Item item) {
        this.item = item;
        this.markUp = 1.3f;
    }

    public void age() {
        item.quality = 80;
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

}
