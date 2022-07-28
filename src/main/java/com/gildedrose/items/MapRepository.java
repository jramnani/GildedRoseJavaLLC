package com.gildedrose.items;

import com.gildedrose.DataRepository;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MapRepository implements DataRepository {
    private Map<String, Ageable> data;

    public MapRepository(Map<String, Ageable> data) {
        this.data = data;
    }
    @Override
    public Ageable get(String id) {
        return data.get(id);
    }

    @Override
    public Collection<Ageable> getAll() {
        return data.values();
    }

    @Override
    public void updateAll() {
        for (Ageable ageableItem : data.values()) {
            ageableItem.age();
        }
    }
}
