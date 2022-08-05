package com.gildedrose;

import com.gildedrose.items.Ageable;

import java.util.Collection;

public interface DataRepository {

    Ageable get(String id);

    Collection<Ageable> getAll();

    void updateAll();
}
