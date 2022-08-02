package com.gildedrose;

import java.util.*;

public class ItemsDataSourceMock<T> implements Datasource<T> {

    private final ArrayList<T> mockedDB;

    ItemsDataSourceMock(ArrayList<T> mockedDB) {
        this.mockedDB = mockedDB;
    }

    public T get(String id) {
        return mockedDB.get(Integer.parseInt(id) - 1);
    }

    public Collection<T> getAll() {
        return new ArrayList<>(mockedDB);
    }

    public void updateAll() {
        int hashMapId = 0;
        for( T item : mockedDB) {
            this.mockedDB.set(hashMapId, item);
            hashMapId++;
        }
    }

}
