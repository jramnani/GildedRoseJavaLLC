package com.gildedrose;

public class Sulfuras implements Ageable {

    private final Item item;

    public Sulfuras(Item item) {
        this.item = item;
    }

    public void age() {
        item.quality = 80;
    }

}
