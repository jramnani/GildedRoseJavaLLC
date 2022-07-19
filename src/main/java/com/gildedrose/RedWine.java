package com.gildedrose;

public class RedWine extends DefaultItem {

    private final float redWineQualityDegradationPastSellIn;
    private final float redWineQualityDegradation;
    private float remainder;
    private float amountToDegradeBy;

    public RedWine() {
        this.redWineQualityDegradation = super.qualityDegradation/3.0f;
        this.redWineQualityDegradationPastSellIn = this.redWineQualityDegradation * 2.0f;
        this.amountToDegradeBy = 0;
        this.remainder = 0;
    }

    public void age(Item item) {
        item.quality = updateQuality(item.quality, item.sellIn);
        item.sellIn = updateSellIn(item.sellIn);
    }

    private int updateQuality(float quality, int sellIn) {
        amountToDegradeBy -= remainder;
        if(sellIn <= 0) {
            amountToDegradeBy += redWineQualityDegradationPastSellIn;
        }
        else {
            amountToDegradeBy += redWineQualityDegradation;
        }

        int qualityToReturn = Math.round(quality - amountToDegradeBy);
        remainder = quality - qualityToReturn;

        return Math.max(qualityToReturn, 0);
    }

    private int updateSellIn(int sellIn) {
        return sellIn - 1;
    }
}
