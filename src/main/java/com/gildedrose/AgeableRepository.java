package com.gildedrose;

import com.gildedrose.goblins_grotto.Item;
import com.gildedrose.items.*;

import java.util.*;
//separate file which is the hashmap construction, this would be imported similar to any database connection

public class AgeableRepository implements DataRepository {

    public Ageable get(String id) {
        return ItemToAgeableMapper.get(id);
    }

    public Collection<Ageable> getAll() {
        return ItemToAgeableMapper.getAll();
    }

    public void updateAll() {
        ArrayList<Ageable> allAgeableItems = ItemToAgeableMapper.getAll();
        for (Ageable ageableItem : allAgeableItems) {
            ageableItem.age();
        }
    }
}

class ItemToAgeableMapper {

    //This is where other db connections would be established and transformed into an Ageable object
    static HashMap<String, Item> hashMapDB = populateHashMapDB();

    static Ageable get(String id) {
        //This would be a res set in the DB case
        Item item = hashMapDB.get(id);
        //If this was a DB this is where the setting of fields in an item would be, in this case we can just pass an Item
        //Item item = new Item();
        //item.quality = corresponding db results set quality col;
        //item.sellIn = corresponding db results set sellIn col;
        Ageable desiredItem;
        switch (item.name) {
            case "Aged Brie" -> desiredItem = new AgedBrie(item);
            case "Backstage passes to a TAFKAL80ETC concert" -> desiredItem = new BackstagePass(item);
            case "Sulfuras, Hand of Ragnaros" -> desiredItem = new Sulfuras(item);
            case "Conjured" -> desiredItem = new Conjured(item);
            case "Red Wine" -> desiredItem = new RedWine(item);
            default -> desiredItem = new DefaultItem(item);
        }
        return desiredItem;
    }

    static ArrayList<Ageable> getAll() {
        ArrayList<Ageable> allItems = new ArrayList<>();
        Set<String> allItemIds = hashMapDB.keySet();
        for (String id : allItemIds) {
            allItems.add(ItemToAgeableMapper.get(id));
        }
        return allItems;
    }

    //Only here for the inlined DB (Hashmap)
    private static HashMap<String, Item> populateHashMapDB() {
        HashMap<String, Item> hashMapDB = new HashMap<>();
        int id = 0;
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Conjured", 3, 6) };

        for (Item item : items) {
            hashMapDB.put(String.valueOf(id++), item);
        }

        return hashMapDB;
    }

}
