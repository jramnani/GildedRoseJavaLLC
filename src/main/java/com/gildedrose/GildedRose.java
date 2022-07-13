package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateSulfuras() {
        //nothing
    }

    public void updateAgedBrie(Item item) {
        if (item.sellIn <= 0) {
            item.quality += 2;
        } else {
            item.quality += 1;
        }

        if (item.quality > 50) {
            item.quality = 50;
        }

        item.sellIn = item.sellIn - 1;
    }

    public void updateBackstage(Item item) {

        if (item.sellIn > 10) {
            item.quality += 1;
        } else if (item.sellIn <= 10
                && item.sellIn > 5) {
            item.quality += 2;
        } else if (item.sellIn <= 5
                && item.sellIn > 0) {
            item.quality += 3;
        } else {
            item.quality = 0;
        }

        if (item.quality > 50) {
            item.quality = 50;
        }

        item.sellIn = item.sellIn - 1;
    }

    public void updateNormal(Item item){
        if (item.sellIn <= 0) {
            item.quality -= 2;
        } else {
            item.quality -= 1;
        }
        if (item.quality < 0) {
            item.quality = 0;
        }
        item.sellIn = item.sellIn - 1;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie":
                    updateAgedBrie(item);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    updateBackstage(item);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    updateSulfuras();
                    break;
                default:
                    updateNormal(item);
                    break;
            }
        }
    }

}
