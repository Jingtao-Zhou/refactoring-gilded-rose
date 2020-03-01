package com.gildedrose.item;

import com.gildedrose.Item;

public class BackstagePassesTo_a_TAFKAL80ETC_Concert extends Item {

    public BackstagePassesTo_a_TAFKAL80ETC_Concert(int sell_in, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sell_in, quality);
    }

    @Override
    protected void updateQuality() {
        addQualityBeforeReach50();
        if (this.getSell_in() < 11) {
            addQualityBeforeReach50();
        }

        if (this.getSell_in() < 6) {
            addQualityBeforeReach50();
        }
    }

    @Override
    protected void updateWhenExpired() {
        if (this.getSell_in() < 0) {
            clearQuality();
        }
    }
}
