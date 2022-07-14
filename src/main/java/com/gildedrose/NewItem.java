package com.gildedrose;

public class NewItem {
    protected String name;
    protected int sellIn;
    protected int quality;

    protected Updatable qualityBehavior;
    protected Updatable sellInBehavior;

    public NewItem(Item item) {
        this.name = item.name;
        this.sellIn = item.sellIn;
        this.quality = item.quality;
    }

    public void update() {

    };

}
