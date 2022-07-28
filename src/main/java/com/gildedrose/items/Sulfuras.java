package com.gildedrose.items;

import com.gildedrose.goblins_grotto.Item;

public class Sulfuras implements Ageable {

    private final Item item;

    public Sulfuras(Item item) {
        this.item = item;
    }

    public void age() {
        item.quality = 80;
    }

    public String getName() {
        return this.item.name;
    }

    public int getPrice() {
        return this.item.quality;
    }

}
