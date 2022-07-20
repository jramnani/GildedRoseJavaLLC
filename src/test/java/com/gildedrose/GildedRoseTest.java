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

        int MinQuality = 0;
        assertTrue(app.items[0].quality >= MinQuality);
    }

    @Test
    void nonLegendaryItems_update_sellInWillReduceBy1() {
        String name = "FlavorTown";
        int sellInDays = 7;
        int quality = 50;
        Item[] items = new Item[] { new Item(name, sellInDays, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        int expectedQuality = 6;
        assertEquals(expectedQuality, app.items[0].sellIn);
    }

    @Test
    void normalItems_update_qualityShouldReduceBy1() {
        String name = "FlavorTown";
        int sellInDays = 7;
        int quality = 50;
        Item[] items = new Item[] { new Item(name, sellInDays, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        int expectedQuality = 49;
        assertEquals(expectedQuality, app.items[0].quality);
    }

    @Test
    void normalItems_update_qualityDegradesTwiceAsFastWhenPassedSellIn() {
        String name = "FlavorTown";
        int sellInDays = 0;
        int quality = 50;
        Item[] items = new Item[] { new Item(name, sellInDays, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        int expectedQuality = 48;
        assertEquals(expectedQuality, app.items[0].quality);
    }

    @Test
    void agedBrie_update_qualityShouldIncreaseBy1() {
        String name = "Aged Brie";
        int sellInDays = 7;
        int quality = 7;
        Item[] items = new Item[] { new Item(name, sellInDays, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        int expectedQuality = 8;
        assertEquals(expectedQuality, app.items[0].quality);
    }

    @Test
    void agedBrie_update_qualityShouldIncreaseBy2WhenPastSellIn() {
        String name = "Aged Brie";
        int sellInDays = 0;
        int quality = 7;
        Item[] items = new Item[] { new Item(name, sellInDays, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        int expectedQuality = 9;
        assertEquals(expectedQuality, app.items[0].quality);
    }

    @Test
    void agedBrie_update_qualityNeverIncreasesAbove50() {
        String name = "Aged Brie";
        int sellInDays = 0;
        int quality = 50;
        Item[] items = new Item[] { new Item(name, sellInDays, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        int maxQuality = 50;
        assertTrue(app.items[0].quality <= maxQuality);
    }

    @Test
    void legendaryItem_update_detailsShouldNeverChange() {
        String name = "Sulfuras, Hand of Ragnaros";
        int sellInDays = 7;
        int quality = 80;
        Item[] items = new Item[] { new Item(name, sellInDays, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        int expectedQuality = 80;
        int expectedSellIn = 7;
        assertEquals(expectedQuality, app.items[0].quality);
        assertEquals(expectedSellIn, app.items[0].sellIn);
    }

    @Test
    void backstagePass_update_qualityIncreasesBy1WhenMoreThan10DaysAway() {
        String name = "Backstage passes to a TAFKAL80ETC concert";
        int sellInDays = 12;
        int quality = 32;
        Item[] items = new Item[] { new Item(name, sellInDays, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        int expectedQuality = 33;
        assertEquals(expectedQuality, app.items[0].quality);
    }

    @Test
    void backstagePass_update_qualityIncreasesBy2When6To10DaysAway() {
        String name = "Backstage passes to a TAFKAL80ETC concert";
        int sellInDays = 6;
        int quality = 32;
        Item[] items = new Item[] { new Item(name, sellInDays, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        int expectedQuality = 34;
        assertEquals(expectedQuality, app.items[0].quality);
    }

    @Test
    void backstagePass_update_qualityIncreasesBy3When1To5DaysAway() {
        String name = "Backstage passes to a TAFKAL80ETC concert";
        int sellInDays = 1;
        int quality = 32;
        Item[] items = new Item[] { new Item(name, sellInDays, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        int expectedQuality = 35;
        assertEquals(expectedQuality, app.items[0].quality);
    }

    @Test
    void backstagePass_update_qualityDropsTo0WhenSellInEquals0() {
        String name = "Backstage passes to a TAFKAL80ETC concert";
        int sellInDays = 0;
        int quality = 32;
        Item[] items = new Item[] { new Item(name, sellInDays, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        int expectedQuality = 0;
        assertEquals(expectedQuality, app.items[0].quality);
    }

    @Test
    void conjured_update_qualityDropsTwiceAsFastAsNormalItems() {
        String name = "Conjured";
        int sellInDays = 27;
        int quality = 32;
        Item[] items = new Item[] { new Item(name, sellInDays, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        int expectedQuality = 30;
        assertEquals(expectedQuality, app.items[0].quality);
    }
    @Test
    void conjured_update_qualityDropsTwiceAsFastAsNormalItemsWhenSellInIsPassed0() {
        String name = "Conjured";
        int sellInDays = 0;
        int quality = 32;
        Item[] items = new Item[] { new Item(name, sellInDays, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        int expectedQuality = 28;
        assertEquals(expectedQuality, app.items[0].quality);
    }

    @Test
    void redWine_update_qualityDropsThreeTimesSlowerThanNormalItems() {
        String name = "Red Wine";
        int sellInDays = 7;
        int quality = 32;
        Item[] items = new Item[] { new Item(name, sellInDays, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        app.updateQuality();
        app.updateQuality();

        int expectedQuality = 31;
        assertEquals(expectedQuality, app.items[0].quality);
    }

    @Test
    void redWine_update_qualityDropsThreeTimesSlowerThanNormalItemsWhenSellInIsPassed0() {
        String name = "Red Wine";
        int sellInDays = 0;
        int quality = 32;
        Item[] items = new Item[] { new Item(name, sellInDays, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        app.updateQuality();
        app.updateQuality();

        int expectedQuality = 30;
        assertEquals(expectedQuality, app.items[0].quality);
    }

}
