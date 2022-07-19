package com.gildedrose;

import java.util.HashMap;

class GildedRose {
    private final HashMap<Item, Ageable> inventory;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
        this.inventory = populateInventory();
    }

    public void updateQuality() {
        for (Item item : items) {
            Ageable ageable = inventory.get(item);
            ageable.age();
        }
    }

    private HashMap<Item, Ageable> populateInventory() {
        HashMap<Item, Ageable> itemInventory = new HashMap<>();
        for (Item item : items) {
            switch (item.name){
                case "Aged Brie":
                    itemInventory.put(item, new AgedBrie(item));
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    itemInventory.put(item, new BackstagePass(item));
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    itemInventory.put(item, new Sulfuras(item));
                    break;
                case "Conjured":
                    itemInventory.put(item, new Conjured(item));
                    break;
                case "Red Wine":
                    itemInventory.put(item, new RedWine(item));
                    break;
                default:
                    itemInventory.put(item, new DefaultItem(item));
                    break;
            }
        }
        return itemInventory;
    }

}
