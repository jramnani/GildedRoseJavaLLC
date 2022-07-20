package com.gildedrose;

public class RedWine extends DefaultItem {

    private final float redWineQualityDegradationPastSellIn;
    private final float redWineQualityDegradation;
    private final Item item;
    private float preciseQuality;
    private final int minQuality;


    public RedWine(Item item) {
        super(item);
        this.redWineQualityDegradation = super.qualityCoefficient /3.0f;
        this.redWineQualityDegradationPastSellIn = this.redWineQualityDegradation * 2.0f;
        this.item = item;
        this.preciseQuality = item.quality;
        this.minQuality = 0;
    }

    public void age() {
        item.quality = updateQuality();
        item.sellIn = super.updateSellIn();
    }

    private int updateQuality() {
        if(item.sellIn <= 0) {
            preciseQuality -= redWineQualityDegradationPastSellIn;
        }
        else {
            preciseQuality -= redWineQualityDegradation;
        }

        int qualityToReturn = Math.round(preciseQuality);

        return Math.max(qualityToReturn, minQuality);
    }

}
