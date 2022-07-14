package com.gildedrose;

public class AgedBrie extends DefaultItem {
    public AgedBrie() {
        super.qualityBehavior = new DefaultIncrease();
        super.sellInBehavior = new DefaultDecrease();
    }

    private int updateQuality(int quality, int sellIn) {
        if (sellIn <= 0) {
            setQualityBehavior(new IncreasableBy2());
        }
        quality = qualityBehavior.update(quality);
        return Math.min(quality, 50);
    }

    private int updateSellIn(int sellIn) {
        return sellInBehavior.update(sellIn);
    }

    public void age(Item item) {
        item.quality = updateQuality(item.quality, item.sellIn);
        item.sellIn = updateSellIn(item.sellIn);
    }

}
