package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    @Test
    void qualityIsNeverNegative() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(app.items[0].quality >= 0);
    }

    @Test
    void qualityIsNeverMoreThan50() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(app.items[0].quality <= 50);
    }

    @Test
    void qualityDegradesTwiceAsFastWhenPassedSellBy() {
        Item[] items = new Item[] { new Item("FLAvorTown", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(48, app.items[0].quality);
    }

    @Test
    void updateNormalItem_QualityShouldReduceBy1() {
        Item[] items = new Item[] { new Item("FLAvorTown", 7, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(49, app.items[0].quality);
    }

    @Test
    void updateNonLegendaryItem_SellByWillReduceBy1() {
        Item[] items = new Item[] { new Item("FLAvorTown", 7, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[0].sellIn);
    }

    @Test
    void updateAgedBrie_QualityShouldIncreaseBy1() {
        Item[] items = new Item[] { new Item("Aged Brie", 7, 7) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void updateAgedBrie_QualityShouldIncreaseBy2WhenPastSellBy() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 7) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
    }

    @Test
    void legendaryItemDetails_ShouldNeverUpdate() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 7, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        assertEquals(7, app.items[0].sellIn);
    }

    @Test
    void backstagePassesQualityIncreasesBy1_MoreThan10DaysAway() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 12, 32) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(33, app.items[0].quality);
    }

    @Test
    void backstagePassesQualityIncreasesBy2_When6To10DaysAway() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 6, 32) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(34, app.items[0].quality);
    }

    @Test
    void backstagePassesQualityIncreasesBy3_When1To5DaysAway() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 1, 32) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(35, app.items[0].quality);
    }

    @Test
    void backstagePassesQualityDropsTo0_WhenSellInEquals0() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 32) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

}
