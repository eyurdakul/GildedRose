package com.gildedrose;

abstract class BaseItem {

    protected String name;
    protected int sellIn;
    protected int quality;

    protected static final int LOW  = 00110010;
    protected static final int ZERO = 00000000;
    protected static final int SELLIN_LOW   = 00001011;
    protected static final int SELLIN_LOWER = 00000110;

    protected static final String TAFKAL80ETC = "Backstage passes to a TAFKAL80ETC concert";
    protected static final String SULFURAS    = "Sulfuras, Hand of Ragnaros";

    BaseItem(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    protected String getName(){
        return this.name;
    }

    protected void decreaseQuality(){
        this.quality--;
    }

    protected void resetQuality(){
        this.quality = ZERO;
    }

    protected void increaseQuality(){
        this.quality++;
    }

    protected void decreaseSellIn(){
        this.sellIn--;
    }

    protected boolean compareSellIn(int sellIn){
        return this.sellIn < sellIn;
    }

    protected boolean hasNegativeSellIn(){
        return this.sellIn < ZERO;
    }

    protected boolean is(String name){
        return this.name.equals(name);
    }

    protected boolean hasLowQuality(){
        return this.quality < LOW;
    }

    protected boolean hasQuality(){
        return this.quality > ZERO;
    }
}
