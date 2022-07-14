package com.gildedrose;

public class DefaultItem {
    protected Updatable qualityBehavior;
    protected Updatable sellInBehavior;

    public DefaultItem() {
        this.qualityBehavior = new DefaultDecrease();
        this.sellInBehavior = new DefaultDecrease();
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
            setQualityBehavior(new DecreasableBy2());
        }
        quality = qualityBehavior.update(quality);
        return Math.max(quality, 0);
    }

    private int updateSellIn(int sellIn) {
        return sellInBehavior.update(sellIn);
    }

}
