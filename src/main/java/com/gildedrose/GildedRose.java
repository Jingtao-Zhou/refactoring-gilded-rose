package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void update_quality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                subQualityIfInStockExceptSulfuras(items[i]);
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sell_in < 11) {
                            addQualityBeforeReach50(items[i]);
                        }

                        if (items[i].sell_in < 6) {
                            addQualityBeforeReach50(items[i]);
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sell_in = items[i].sell_in - 1;
            }

            if (items[i].sell_in < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        subQualityIfInStockExceptSulfuras(items[i]);
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    addQualityBeforeReach50(items[i]);
                }
            }
        }
    }

    private void addQualityBeforeReach50(Item item){
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void subQualityIfInStockExceptSulfuras(Item item){
        if (item.quality > 0) {
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.quality = item.quality - 1;
            }
        }
    }
}
