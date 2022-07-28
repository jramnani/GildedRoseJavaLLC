package com.gildedrose;

import com.gildedrose.goblins_grotto.Item;
import com.gildedrose.items.*;

import java.util.HashMap;
import java.util.Map;

class GildedRose {
    private final HashMap<String, Ageable> inventory;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
        this.inventory = populateInventory();
    }

    public void updateQuality() {
        int id = 1;
        for (Item item : items) {
            Ageable ageable = inventory.get(String.valueOf(id));
            ageable.age();
            id++;
        }
    }

    public Map<String,Ageable> getInventory() {
        return this.inventory;
    }

    private HashMap<String, Ageable> populateInventory() {
        HashMap<String, Ageable> itemInventory = new HashMap<>();
        int id = 0;
        for (Item item : items) {
            id++;
            String passedId = String.valueOf(id);
            switch (item.name) {
                case "Aged Brie" -> itemInventory.put(passedId, new AgedBrie(item));
                case "Backstage passes to a TAFKAL80ETC concert" -> itemInventory.put(passedId, new BackstagePass(item));
                case "Sulfuras, Hand of Ragnaros" -> itemInventory.put(passedId, new Sulfuras(item));
                case "Conjured" -> itemInventory.put(passedId, new Conjured(item));
                case "Red Wine" -> itemInventory.put(passedId, new RedWine(item));
                default -> itemInventory.put(passedId, new DefaultItem(item));
            }
        }
        return itemInventory;
    }

}
