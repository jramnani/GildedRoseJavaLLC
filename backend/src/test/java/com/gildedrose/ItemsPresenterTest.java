package com.gildedrose;

import com.gildedrose.goblins_grotto.Item;
import com.gildedrose.items.Ageable;
import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.DefaultItem;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemsPresenterTest {

    @Test
    void singleItem_PresentedAsJson() {
        int sellIn = 4;
        int quality = 15;
        String name = "FlavorTown";
        ItemsPresenter itemsPresenter = new ItemsPresenter();
        Ageable item = new DefaultItem(new Item(name, sellIn, quality));
        float price = quality * 1.3f;

        String singleItemJson = itemsPresenter.singleItemJson(item);

        String expectedSingleItemJson = String.format("""
                {
                    "name": "%s",
                    "price": "%f"
                }
                """, name, price);

        assertEquals(expectedSingleItemJson, singleItemJson);
    }

    @Test
    void allItems_PresentedAsJson() {
        int sellIn = 4;
        int quality = 15;
        ItemsPresenter itemsPresenter = new ItemsPresenter();
        Collection<Ageable> items = new ArrayList<>();
        items.add(new DefaultItem(new Item("FlavorTown", sellIn, quality)));
        items.add(new AgedBrie(new Item("Aged Brie", sellIn, quality)));
        float price = quality * 1.3f;

        String allItemsJson = itemsPresenter.allItemsJson(items);

        String expectedItemsJson = String.format("""
                [{
                    "name": "%s",
                    "price": "%f"
                },
                {
                    "name": "%s",
                    "price": "%f"
                }]
                """, "FlavorTown", price, "Aged Brie", price);

        assertEquals(expectedItemsJson, allItemsJson);
    }
}
