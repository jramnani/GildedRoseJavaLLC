package com.gildedrose;

import com.gildedrose.goblins_grotto.Item;
import com.gildedrose.items.*;

import java.util.*;

public class ItemsRepository implements DataRepository {

    private final Datasource<Item> hashMapDB;

    ItemsRepository(Datasource<Item> hashMapDB) {
        this.hashMapDB = hashMapDB;
    }

    public Ageable get(String id) {
        Item item = hashMapDB.get(id);
        return AgeableMapper.mapToAgeable(item);
    }

    public ArrayList<Ageable> getAll() {
        ArrayList<Ageable> allItems = new ArrayList<>();
        for (Item item : hashMapDB.getAll()) {
            allItems.add(AgeableMapper.mapToAgeable(item));
        }
        return allItems;
    }

    public void updateAll() {
        for (Ageable item : getAll()) {
            item.age();
        }
        hashMapDB.updateAll();
    }
}

class AgeableMapper {

    public static Ageable mapToAgeable(Item dataBaseItem) {

        //This would be a res set in the DB case
        //If this was a DB this is where the setting of fields in an item would be, in this case we can just pass an Item
        //item.quality = corresponding db results set quality col;
        //item.sellIn = corresponding db results set sellIn col;
        return switch (dataBaseItem.name) {
            case "Aged Brie" -> new AgedBrie(dataBaseItem);
            case "Backstage passes to a TAFKAL80ETC concert" -> new BackstagePass(dataBaseItem);
            case "Sulfuras, Hand of Ragnaros" -> new Sulfuras(dataBaseItem);
            case "Conjured" -> new Conjured(dataBaseItem);
            case "Red Wine" -> new RedWine(dataBaseItem);
            default -> new DefaultItem(dataBaseItem);
        };
    }
}
