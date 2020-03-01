package com.gildedrose.item;

import com.gildedrose.Item;

public class OtherItem extends Item {

    public OtherItem(String name, int sell_in, int quality) {
        super(name, sell_in, quality);
    }

    @Override
    protected void updateQuality() {
        subQualityIfInStock();
    }

    @Override
    protected void updateWhenExpired() {
        if (this.getSell_in() < 0) {
            subQualityIfInStock();
        }
    }
}
