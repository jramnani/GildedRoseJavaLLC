package com.gildedrose;

public class AgedBrie extends NewItem {
    public AgedBrie(Item item) {
        super(item);
        super.qualityBehavior = new DefaultIncrease();
        super.sellInBehavior = new DefaultDecrease();
    }

    public void setQualityBehavior(Updatable updatable) {
        super.qualityBehavior = updatable;
    }

    public void setSellInBehavior(Updatable updatable) {
        super.sellInBehavior = updatable;
    }

    public int updateQuality() {
        if (sellIn <= 0) {
            setQualityBehavior(new IncreasableBy2());
        }
        this.quality = qualityBehavior.update(this.quality);
        return Math.min(this.quality, 50);
    }

    public int updateSellIn() {
        return sellInBehavior.update(this.sellIn);
    }

}
