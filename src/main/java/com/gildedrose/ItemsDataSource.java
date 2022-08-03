package com.gildedrose;

import java.util.*;

public class ItemsDataSource<T> implements Datasource<T> {

    private final HashMap<String, T> hashMapDB;

    ItemsDataSource(HashMap<String, T> hashMap) {
        hashMapDB = hashMap;
    }

    public T get(String id) {
        return hashMapDB.get(id);
    }

    public Collection<T> getAll() {
        return new ArrayList<>(hashMapDB.values());
    }

    public void updateAll() {
        int hashMapId = 0;
        for (T item : hashMapDB.values()) {
            hashMapDB.put(String.valueOf(hashMapId++), item);
        }
    }

}
