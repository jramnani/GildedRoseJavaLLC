package com.gildedrose;

public class DefaultItem {
    protected Updatable qualityBehavior;
    protected Updatable sellInBehavior;

    private void setQualityBehavior(Updatable updatable) {
        qualityBehavior = updatable;
    }

    private void setSellInBehavior(Updatable updatable) {
        sellInBehavior = updatable;
    }

    private int updateQuality(int quality, int sellIn) {
        return 0;
    }

    private int updateSellIn(int sellIn) {
        return sellInBehavior.update(sellIn);
    }

    public void age(Item item) {
        
    }

}
