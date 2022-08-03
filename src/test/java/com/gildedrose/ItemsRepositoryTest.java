package com.gildedrose;

import com.gildedrose.goblins_grotto.Item;
import com.gildedrose.items.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ItemsRepositoryTest {

    ArrayList<Ageable> mockedDB;
    ItemsRepository repository;

    @BeforeEach
    void setUp() {
        mockedDB = new ArrayList<>();
        repository = new ItemsRepository(new ItemsDataSourceMock<>(mockedDB));
    }

    @Test
    void ItemsRepository_Get_WillReturn_AnAgeableMatchingTheMockItemName() {
        int sellIn = 5;
        int quality = 16;
        mockedDB.add(new DefaultItem(new Item("foo", sellIn, quality)));
        String id = "1";

        Ageable retrievedItem = repository.get(id);

        assertEquals("foo", retrievedItem.getName());
    }

    @Test
    void ItemsRepository_GetAll_WillReturn_AnAgeableCollectionMatchingEachItemName() {
        int sellIn = 5;
        int quality = 16;
        mockedDB.add(new DefaultItem(new Item("foo", sellIn, quality)));
        mockedDB.add(new DefaultItem(new Item("bar", sellIn, quality)));

        ArrayList<Ageable> retrievedItems = repository.getAll();

        assertEquals("foo", retrievedItems.get(0).getName());
        assertEquals("bar", retrievedItems.get(1).getName());
    }

    @Test
    void ItemsRepository_UpdateAll_AllItemsQualityNeverDropsBelow0() {
        int sellIn = 5;
        int quality = 0;
        this.mockedDB.add(new DefaultItem(new Item("FlavorTown", sellIn, quality)));
        String id = "1";

        repository.updateAll();

        assertEquals(0, repository.get(id).getQuality());
    }

    @Test
    void ItemsRepository_UpdateAll_NonLegendarySellInWillReduceBy1() {
        int sellIn = 5;
        int quality = 16;
        this.mockedDB.add(new DefaultItem(new Item("FlavorTown", sellIn, quality)));
        String id = "1";

        repository.updateAll();

        assertEquals(4, repository.get(id).getSellIn());
    }

    @Test
    void ItemsRepository_UpdateAll_DefaultItemsQualityShouldReduceBy1() {
        int sellIn = 5;
        int quality = 16;
        this.mockedDB.add(new DefaultItem(new Item("FlavorTown", sellIn, quality)));
        String id = "1";

        repository.updateAll();

        assertEquals(15, repository.get(id).getQuality());
    }

    @Test
    void ItemsRepository_UpdateAll_DefaultItemsQualityDegradesTwiceAsFastWhenPassedSellIn() {
        int sellIn = 0;
        int quality = 16;
        this.mockedDB.add(new DefaultItem(new Item("FlavorTown", sellIn, quality)));
        String id = "1";

        repository.updateAll();

        assertEquals(14, repository.get(id).getQuality());
    }

    @Test
    void ItemsRepository_UpdateAll_AgedBrieQualityShouldIncreaseBy1() {
        int sellIn = 5;
        int quality = 16;
        this.mockedDB.add(new AgedBrie(new Item("Aged Brie", sellIn, quality)));
        String id = "1";

        repository.updateAll();

        assertEquals(17, repository.get(id).getQuality());
    }

    @Test
    void ItemsRepository_UpdateAll_AgedBrieQualityIncreasesTwiceAsFastWhenPassedSellIn() {
        int sellIn = 0;
        int quality = 16;
        this.mockedDB.add(new AgedBrie(new Item("Aged Brie", sellIn, quality)));
        String id = "1";

        repository.updateAll();

        assertEquals(18, repository.get(id).getQuality());
    }

    @Test
    void ItemsRepository_UpdateAll_AgedBrieQualityNeverIncreasesAbove50() {
        int sellIn = 0;
        int quality = 50;
        this.mockedDB.add(new AgedBrie(new Item("Aged Brie", sellIn, quality)));
        String id = "1";

        repository.updateAll();

        assertEquals(50, repository.get(id).getQuality());
    }

    @Test
    void ItemsRepository_UpdateAll_LegendaryItemDetailsNeverChange() {
        int sellIn = 5;
        int quality = 80;
        this.mockedDB.add(new Sulfuras(new Item("Sulfuras, Hand of Ragnaros", sellIn, quality)));
        String id = "1";

        repository.updateAll();

        assertEquals(80, repository.get(id).getQuality());
        assertEquals(5, repository.get(id).getSellIn());
    }

    @Test
    void ItemsRepository_UpdateAll_BackStagePassQualityIncreasesBy1WhenMoreThan10DaysAway() {
        int sellIn = 12;
        int quality = 32;
        this.mockedDB.add(new BackstagePass(new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality)));
        String id = "1";

        repository.updateAll();

        assertEquals(33, repository.get(id).getQuality());
    }

    @Test
    void ItemsRepository_UpdateAll_BackStagePassQualityIncreasesBy2When6To10DaysAway() {
        int sellIn = 6;
        int quality = 32;
        this.mockedDB.add(new BackstagePass(new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality)));
        String id = "1";

        repository.updateAll();

        assertEquals(34, repository.get(id).getQuality());
    }

    @Test
    void ItemsRepository_UpdateAll_BackStagePassQualityIncreasesBy3When1To5DaysAway() {
        int sellIn = 1;
        int quality = 32;
        this.mockedDB.add(new BackstagePass(new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality)));
        String id = "1";

        repository.updateAll();

        assertEquals(35, repository.get(id).getQuality());
    }

    @Test
    void ItemsRepository_UpdateAll_BackStagePassQualityDropsTo0WhenSellInEquals0() {
        int sellIn = 0;
        int quality = 32;
        this.mockedDB.add(new BackstagePass(new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality)));
        String id = "1";

        repository.updateAll();

        assertEquals(0, repository.get(id).getQuality());
    }

    @Test
    void ItemsRepository_UpdateAll_ConjuredQualityDropsTwiceAsFastAsDefaultItems() {
        int sellIn = 27;
        int quality = 32;
        this.mockedDB.add(new Conjured(new Item("Conjured", sellIn, quality)));
        String id = "1";

        repository.updateAll();

        assertEquals(30, repository.get(id).getQuality());
    }

    @Test
    void ItemsRepository_UpdateAll_ConjuredQualityDropsTwiceAsFastAsDefaultItemsWhenPassedSellIn() {
        int sellIn = 0;
        int quality = 32;
        this.mockedDB.add(new Conjured(new Item("Conjured", sellIn, quality)));
        String id = "1";

        repository.updateAll();

        assertEquals(28, repository.get(id).getQuality());
    }

    @Test
    void ItemsRepository_UpdateAll_RedWineQualityDropsThreeTimesSlowerThanDefaultItems() {
        int sellIn = 7;
        int quality = 32;
        this.mockedDB.add(new RedWine(new Item("Red Wine", sellIn, quality)));
        String id = "1";

        repository.updateAll();
        repository.updateAll();
        repository.updateAll();

        assertEquals(31, repository.get(id).getQuality());
    }

    @Test
    void ItemsRepository_UpdateAll_RedWineQualityDropsThreeTimesSlowerThanDefaultItemsWhenPassedSellIn() {
        int sellIn = 0;
        int quality = 32;
        this.mockedDB.add(new RedWine(new Item("Red Wine", sellIn, quality)));
        String id = "1";

        repository.updateAll();
        repository.updateAll();
        repository.updateAll();

        assertEquals(30, repository.get(id).getQuality());
    }
}
