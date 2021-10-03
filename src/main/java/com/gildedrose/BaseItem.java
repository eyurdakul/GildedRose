package com.gildedrose;

abstract class BaseItem {

    protected String name;
    protected int sellIn;
    protected int quality;

    BaseItem(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    protected abstract void process();

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
