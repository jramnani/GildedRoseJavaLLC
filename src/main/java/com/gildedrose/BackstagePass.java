package com.gildedrose;

public class BackstagePass extends DefaultItem {

    public BackstagePass() {
        super.qualityBehavior = new DefaultIncrease();
    }

    public void age(Item item) {
        item.quality = updateQuality(item.quality, item.sellIn);
        item.sellIn = updateSellIn(item.sellIn);
    }

    private int updateQuality(int quality, int sellIn) {
        if (sellIn <= 10
                && sellIn > 5) {
            setQualityBehavior(new IncreasableBy2());
        } else if (sellIn <= 5
                && sellIn > 0) {
            setQualityBehavior(new IncreasableBy3());
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
