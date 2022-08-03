package com.gildedrose;

import com.gildedrose.items.Ageable;

import java.util.Collection;

public class ItemsPresenter {

    public String singleItemJson(Ageable item) {

        return String.format("""
                {
                    "name": "%s",
                    "price": "%f"
                }
                """, item.getName(), item.getPrice());
    }

    public String allItemsJson(Collection<Ageable> items) {
        StringBuilder allItemsJson = new StringBuilder();
        for (Ageable item : items) {
            allItemsJson.append(String.format("""
                {
                    "name": "%s",
                    "price": "%f"
                },
                """, item.getName(), item.getPrice()));
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
