package com.gildedrose;

public class NewItem {
    protected String name;
    protected int sellIn;
    protected int quality;

    protected Updatable qualityBehavior;
    protected Updatable sellInBehavior;

    public NewItem(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void update() {

    };

}
