package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    @Test
    void allItems_update_qualityNeverDropsBelow0() {
        String name = "foo";
        int sellInDays = 0;
        int quality = 0;
        Item[] items = new Item[] { new Item(name, sellInDays, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertTrue(app.items[0].quality >= 0);
    }

    @Test
    void nonLegendaryItems_update_sellInWillReduceBy1() {
        String name = "FlavorTown";
        int sellInDays = 7;
        int quality = 50;
        Item[] items = new Item[] { new Item(name, sellInDays, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(6, app.items[0].sellIn);
    }

    @Test
    void normalItems_update_qualityShouldReduceBy1() {
        String name = "FlavorTown";
        int sellInDays = 7;
        int quality = 50;
        Item[] items = new Item[] { new Item(name, sellInDays, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(49, app.items[0].quality);
    }

    @Test
    void normalItems_update_qualityDegradesTwiceAsFastWhenPassedSellIn() {
        String name = "FlavorTown";
        int sellInDays = 0;
        int quality = 50;
        Item[] items = new Item[] { new Item(name, sellInDays, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(48, app.items[0].quality);
    }

    @Test
    void agedBrie_update_qualityShouldIncreaseBy1() {
        String name = "Aged Brie";
        int sellInDays = 7;
        int quality = 7;
        Item[] items = new Item[] { new Item(name, sellInDays, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(8, app.items[0].quality);
    }

    @Test
    void agedBrie_update_qualityShouldIncreaseBy2WhenPastSellIn() {
        String name = "Aged Brie";
        int sellInDays = 0;
        int quality = 7;
        Item[] items = new Item[] { new Item(name, sellInDays, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, app.items[0].quality);
    }

    @Test
    void agedBrie_update_qualityNeverIncreasesAbove50() {
        String name = "Aged Brie";
        int sellInDays = 0;
        int quality = 50;
        Item[] items = new Item[] { new Item(name, sellInDays, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertTrue(app.items[0].quality <= 50);
    }

    @Test
    void legendaryItem_update_detailsShouldNeverChange() {
        String name = "Sulfuras, Hand of Ragnaros";
        int sellInDays = 7;
        int quality = 80;
        Item[] items = new Item[] { new Item(name, sellInDays, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(80, app.items[0].quality);
        assertEquals(7, app.items[0].sellIn);
    }

    @Test
    void backstagePass_update_qualityIncreasesBy1WhenMoreThan10DaysAway() {
        String name = "Backstage passes to a TAFKAL80ETC concert";
        int sellInDays = 12;
        int quality = 32;
        Item[] items = new Item[] { new Item(name, sellInDays, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(33, app.items[0].quality);
    }

    @Test
    void backstagePass_update_qualityIncreasesBy2When6To10DaysAway() {
        String name = "Backstage passes to a TAFKAL80ETC concert";
        int sellInDays = 6;
        int quality = 32;
        Item[] items = new Item[] { new Item(name, sellInDays, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(34, app.items[0].quality);
    }

    @Test
    void backstagePass_update_qualityIncreasesBy3When1To5DaysAway() {
        String name = "Backstage passes to a TAFKAL80ETC concert";
        int sellInDays = 1;
        int quality = 32;
        Item[] items = new Item[] { new Item(name, sellInDays, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(35, app.items[0].quality);
    }

    @Test
    void backstagePass_update_qualityDropsTo0WhenSellInEquals0() {
        String name = "Backstage passes to a TAFKAL80ETC concert";
        int sellInDays = 0;
        int quality = 32;
        Item[] items = new Item[] { new Item(name, sellInDays, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    void conjured_update_qualityDropsTwiceAsFastAsNormalItems() {
        String name = "Conjured";
        int sellInDays = 27;
        int quality = 32;
        Item[] items = new Item[] { new Item(name, sellInDays, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(30, app.items[0].quality);
    }
    @Test
    void conjured_update_qualityDropsTwiceAsFastAsNormalItemsWhenSellInIsPassed0() {
        String name = "Conjured";
        int sellInDays = 0;
        int quality = 32;
        Item[] items = new Item[] { new Item(name, sellInDays, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(28, app.items[0].quality);
    }


}
