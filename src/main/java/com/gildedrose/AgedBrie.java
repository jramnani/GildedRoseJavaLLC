package com.gildedrose;

public class AgedBrie extends NewItem {
    public AgedBrie(Item item) {
        super(item);
        super.qualityBehavior = new DefaultIncrease();
        super.sellInBehavior = new DefaultDecrease();
    }

    private void setQualityBehavior(Updatable updatable) {
        super.qualityBehavior = updatable;
    }

    private void setSellInBehavior(Updatable updatable) {
        super.sellInBehavior = updatable;
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
