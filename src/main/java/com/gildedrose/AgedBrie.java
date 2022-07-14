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

    public void updateQuality() {
        if (quality < 0) {
            setQualityBehavior(new IncreasableBy2());
        }
        this.quality = qualityBehavior.update(this.quality);
    }

    public void updateSellIn() {
        this.sellIn = sellInBehavior.update(this.sellIn);
    }

}
