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
        if (item.sellIn < 0) {
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
        item.sellIn = item.sellIn - 1;
    }

    public void updateQuality() {
        for (Item item : items) {
            // This if is for normal items, maybe think about it being the base else case
            if (!item.name.equals("Aged Brie")
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > 0) {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                //This could be a general statement for every item except sulfurase
                if (item.name.equals("Aged Brie")) {
                    updateAgedBrie(item);
                } else if (item.quality < 50) {
                    updateBackstage(item);
                }
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                item.quality = item.quality - 1;
                            }
                        }
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }

}
