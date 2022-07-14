package com.gildedrose;

public class Conjured extends DefaultItem {

    public void age(Item item) {
        item.quality = updateQuality(item.quality, item.sellIn);
        item.sellIn = updateSellIn(item.sellIn);
    }

    private int updateQuality(int quality, int sellIn) {
        if (sellIn <= 0) {
            setQualityBehavior(new DecreasableBy2());
        }
        quality = doubleDefaultUpdate(quality);
        return Math.max(quality, 0);
    }

    private int updateSellIn(int sellIn) {
        return sellInBehavior.update(sellIn);
    }

    private int doubleDefaultUpdate(int quality) {
        int initialUpdate = qualityBehavior.update(quality);
        return qualityBehavior.update(initialUpdate);
    }

}
