package com.gildedrose;

public class AgedBrie {
    private Updatable qualityBehavior;
    private Updatable sellInBehavior;

    public AgedBrie() {
        qualityBehavior = new DefaultIncrease();
        sellInBehavior = new DefaultIncrease();
    }

    protected void setQualityBehavior(Updatable updatable) {
        qualityBehavior = updatable;
    }

    public void age(Item item) {
        item.quality = updateQuality(item.quality, item.sellIn);
        item.sellIn = updateSellIn(item.sellIn);
    }

    private int updateQuality(int quality, int sellIn) {
        if (sellIn <= 0) {
            setQualityBehavior(new IncreaseBy2());
        }
        quality = qualityBehavior.update(quality);
        return Math.min(quality, 50);
    }

    private int updateSellIn(int sellIn) {
        return sellInBehavior.update(sellIn);
    }

}
