package com.gildedrose;

public class Item extends BaseItem{

    Item(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        if(!this.is(SULFURAS)){
            if(this.hasLowQuality()){
                this.increaseQuality();
                if(this.hasNegativeSellIn()){
                    this.decreaseQuality();
                }
                if(this.is(TAFKAL80ETC)){
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
}
