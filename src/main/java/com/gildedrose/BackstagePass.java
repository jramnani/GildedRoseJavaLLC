package com.gildedrose;

public class BackstagePass {
    private Updatable qualityBehavior;
    private Updatable sellInBehavior;

    public BackstagePass() {
        qualityBehavior = new DefaultIncrease();
        sellInBehavior = new DefaultDecrease();
    }

    public void setQualityBehavior(Updatable updatable) {
        qualityBehavior = updatable;
    }

    public void age(Item item) {
        item.quality = updateQuality(item.quality, item.sellIn);
        item.sellIn = updateSellIn(item.sellIn);
    }

    private int updateQuality(int quality, int sellIn) {
        if (sellIn <= 10
                && sellIn > 5) {
            setQualityBehavior(new IncreaseBy2());
        } else if (sellIn <= 5
                && sellIn > 0) {
            setQualityBehavior(new IncreaseBy3());
        } else if (sellIn == 0) {
            setQualityBehavior(new DecreaseToZero());
        }
        quality = qualityBehavior.update(quality);
        return Math.min(quality, 50);
    }

    private int updateSellIn(int sellIn) {
        return sellInBehavior.update(sellIn);
    }

}
