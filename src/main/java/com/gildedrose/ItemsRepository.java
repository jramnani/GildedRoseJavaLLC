package com.gildedrose;

import com.gildedrose.goblins_grotto.Item;
import com.gildedrose.items.*;

import java.util.*;

public class ItemsRepository implements DataRepository {

    private final Datasource<Ageable> itemsDataSource;

    ItemsRepository(Datasource<Ageable> itemsDataSource) {
        this.itemsDataSource = itemsDataSource;
    }

    public Ageable get(String id) {
        return itemsDataSource.get(id);
    }

    public ArrayList<Ageable> getAll() {
        return new ArrayList<>(itemsDataSource.getAll());
    }

    public void updateAll() {
        for (Ageable item : getAll()) {
            item.age();
        }
        itemsDataSource.updateAll();
    }
}
