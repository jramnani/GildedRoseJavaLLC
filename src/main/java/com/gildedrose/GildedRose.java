package com.gildedrose;

import java.util.HashMap;

class GildedRose {
    private final HashMap<Item, Ageable> inventory;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
        this.inventory = new HashMap<>();
    }

    public void updateQuality() {
        populateInventory();
        for (Item item : items) {
            Ageable ageable = inventory.get(item);
            ageable.age(item);
        }
    }

    private void populateInventory() {
        for (Item item : items) {
            switch (item.name){
                case "Aged Brie":
                    inventory.put(item, new AgedBrie());
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    inventory.put(item, new BackstagePass());
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    inventory.put(item, new Sulfuras());
                    break;
                case "Conjured":
                    inventory.put(item, new Conjured());
                    break;
                default:
                    inventory.put(item, new DefaultItem());
                    break;
            }
        }
    }

}
