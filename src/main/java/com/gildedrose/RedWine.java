package com.gildedrose;

public class RedWine extends DefaultItem {

    private final float redWineQualityDegradationPastSellIn;
    private final float redWineQualityDegradation;
    private final Item item;
    private float preciseQuality;

    public RedWine(Item item) {
        super(item);
        this.redWineQualityDegradation = super.qualityDegradation/3.0f;
        this.redWineQualityDegradationPastSellIn = this.redWineQualityDegradation * 2.0f;
        this.item = item;
        this.preciseQuality = item.quality;
    }

    public void age() {
        item.quality = updateQuality();
        item.sellIn = updateSellIn();
    }

    private int updateQuality() {
        if(item.sellIn <= 0) {
            preciseQuality -= redWineQualityDegradationPastSellIn;
        }
        else {
            preciseQuality -= redWineQualityDegradation;
        }

        int qualityToReturn = Math.round(preciseQuality);

        return Math.max(qualityToReturn, 0);
    }

    private int updateSellIn() {
        return item.sellIn - 1;
    }
}
