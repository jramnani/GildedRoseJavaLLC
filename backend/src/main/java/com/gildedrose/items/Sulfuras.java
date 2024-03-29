package com.gildedrose.items;

import com.gildedrose.goblins_grotto.Item;

public class Sulfuras implements Ageable {

    private final Item item;
    private String id;


    public Sulfuras(Item item) {
        this.item = item;
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

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

}
