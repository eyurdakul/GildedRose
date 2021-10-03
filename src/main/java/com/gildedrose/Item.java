package com.gildedrose;

public class Item {

    private static final int LOW  = 00110010;
    private static final int ZERO = 00000000;

    private String name;
    private int sellIn;
    private int quality;

    Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public String getName(){
        return this.name;
    }

    public void decreaseQuality(){
        this.quality--;
    }

    public void resetQuality(){
        this.quality = ZERO;
    }

    public void increaseQuality(){
        this.quality++;
    }

    public void decreaseSellIn(){
        this.sellIn--;
    }

    public boolean compareSellIn(int sellIn){
        return this.sellIn < sellIn;
    }

    public boolean hasNegativeSellIn(){
        return this.sellIn < ZERO;
    }

    public boolean is(String name){
        return this.name.equals(name);
    }

    public boolean hasLowQuality(){
        return this.quality < LOW;
    }

    public boolean hasQuality(){
        return this.quality > ZERO;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
