package com.gildedrose.items;

public interface Ageable {

    float markUp = 1.3f;

    void age();

    String getName();

    float getPrice();

    int getQuality();

    int getSellIn();
    void setId(String id);

    String getId();
}
