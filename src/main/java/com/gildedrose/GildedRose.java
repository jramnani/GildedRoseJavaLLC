package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie":
                    AgedBrie agedBrie = new AgedBrie();
                    agedBrie.age(item);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    BackstagePass backstagePass = new BackstagePass();
                    backstagePass.age(item);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    Sulfuras sulfuras = new Sulfuras();
                    sulfuras.age(item);
                    break;
                case "Conjured":
                    Conjured conjured = new Conjured();
                    conjured.age(item);
                    break;
                default:
                    DefaultItem defaultItem = new DefaultItem();
                    defaultItem.age(item);
                    break;
            }
        }
    }

}
