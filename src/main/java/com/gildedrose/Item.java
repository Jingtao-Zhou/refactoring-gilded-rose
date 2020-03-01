package com.gildedrose;

public abstract class Item {

    private String name;

    private int sell_in;

    private int quality;

    public Item(String name, int sell_in, int quality) {
        this.name = name;
        this.sell_in = sell_in;
        this.quality = quality;
    }

    public void updateItem() {

        updateQuality();

        updateSellIn();

        updateWhenExpired();

    }

    protected void updateQuality() {
    }

    private void updateSellIn() {
        this.sell_in = this.sell_in - 1;
    }

    protected void updateWhenExpired() {
    }

    protected void clearQuality() {
        this.quality = 0;
    }

    protected void addQualityBeforeReach50() {
        if (this.quality < 50) {
            this.quality = this.quality + 1;
        }
    }

    protected void subQualityIfInStockExceptSulfuras() {
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
