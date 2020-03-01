package com.gildedrose.item;

import com.gildedrose.Item;

public class AgedBrie extends Item {

    public AgedBrie(int sell_in, int quality) {
        super("Aged Brie", sell_in, quality);
    }

    @Override
    protected void updateQuality() {
        addQualityBeforeReach50();
    }

    @Override
    protected void updateWhenExpired() {
        if (this.getSell_in() < 0) {
            addQualityBeforeReach50();
        }
    }
}
