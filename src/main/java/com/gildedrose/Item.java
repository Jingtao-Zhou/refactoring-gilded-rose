package com.gildedrose;

public class Item {

    private String name;

    private int sell_in;

    private int quality;

    public Item(String name, int sell_in, int quality) {
        this.name = name;
        this.sell_in = sell_in;
        this.quality = quality;
    }

    void update_quality() {
        if (!this.name.equals("Aged Brie")
                && !this.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            subQualityIfInStockExceptSulfuras();
        } else {
            if (this.quality < 50) {
                this.quality = this.quality + 1;

                if (this.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (this.sell_in < 11) {
                        addQualityBeforeReach50();
                    }

                    if (this.sell_in < 6) {
                        addQualityBeforeReach50();
                    }
                }
            }
        }

        if (!this.name.equals("Sulfuras, Hand of Ragnaros")) {
            this.sell_in = this.sell_in - 1;
        }

        if (this.sell_in < 0) {
            if (!this.name.equals("Aged Brie")) {
                if (!this.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    subQualityIfInStockExceptSulfuras();
                } else {
                    this.quality = 0;
                }
            } else {
                addQualityBeforeReach50();
            }
        }

    }

    private void addQualityBeforeReach50() {
        if (this.quality < 50) {
            this.quality = this.quality + 1;
        }
    }

    private void subQualityIfInStockExceptSulfuras() {
        if (this.quality > 0) {
            if (!this.name.equals("Sulfuras, Hand of Ragnaros")) {
                this.quality = this.quality - 1;
            }
        }
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sell_in + ", " + this.quality;
    }

    public String getName() {
        return name;
    }

    public int getSell_in() {
        return sell_in;
    }

    public int getQuality() {
        return quality;
    }
}
