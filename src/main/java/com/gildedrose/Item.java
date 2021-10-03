package com.gildedrose;

public class Item extends BaseItem{

    protected static final int LOW  = 00110010;
    protected static final int ZERO = 00000000;
    private static final String AGED_BRIE   = "Aged Brie";
    private static final String TAFKAL80ETC = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS    = "Sulfuras, Hand of Ragnaros";
    private static final int SELLIN_LOW   = 11;
    private static final int SELLIN_LOWER = 6;

    Item(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void process() {
        if(!this.name.equals(SULFURAS)){
            if(this.hasLowQuality()){
                this.increaseQuality();
                if(this.hasNegativeSellIn()){
                    this.decreaseQuality();
                }
                if(this.name.equals(TAFKAL80ETC)){
                    if(this.compareSellIn(SELLIN_LOW)){
                        this.increaseQuality();
                    }
                    if(this.compareSellIn(SELLIN_LOWER)){
                        this.increaseQuality();
                    }
                }
            } else if(this.hasQuality()){
                this.decreaseQuality();
            }
            this.decreaseSellIn();
        }else{
            if(this.hasNegativeSellIn()){
                this.resetQuality();
            }
        }

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
}
