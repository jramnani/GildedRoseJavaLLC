package com.gildedrose.items;

import com.gildedrose.goblins_grotto.Item;

public class DefaultItem implements Ageable {

    private final Item item;
    private final int minQuality;
    protected int qualityCoefficient;
    protected String id;

    public DefaultItem(Item item) {
        this.item = item;
        this.qualityCoefficient = 1;
        this.minQuality = 0;
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

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
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
