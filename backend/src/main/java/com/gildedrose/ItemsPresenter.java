package com.gildedrose;

import com.gildedrose.items.Ageable;

import java.util.Collection;

public class ItemsPresenter {

    public String singleItemJson(Ageable item) {

        return String.format("""
                {
                    "id": "%s",
                    "name": "%s",
                    "quality": "%s",
                    "sellIn": "%s",
                    "price": "%f"
                }
                """, item.getId(), item.getName(), item.getQuality(), item.getSellIn(), item.getPrice());
    }

    public String allItemsJson(Collection<Ageable> items) {
        StringBuilder allItemsJson = new StringBuilder();
        for (Ageable item : items) {
            allItemsJson.append(String.format("""
                {
                    "id": "%s",
                    "name": "%s",
                    "quality": "%s",
                    "sellIn": "%s",
                    "price": "%f"
                },
                """, item.getId(), item.getName(),item.getQuality(), item.getSellIn(), item.getPrice()));
        }

        return formatJsonBrackets(allItemsJson);
    }

    private String formatJsonBrackets(StringBuilder allItemsJson) {
        allItemsJson.insert(0, "[");
        int bracketIndex = allItemsJson.lastIndexOf(",");
        allItemsJson.replace(bracketIndex, bracketIndex + 1, "]");
        return allItemsJson.toString();
    }
}
