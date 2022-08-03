package com.gildedrose;

import java.util.Collection;

public interface Datasource<T> {

    T get(String id);

    Collection<T> getAll();

    void updateAll();
}
