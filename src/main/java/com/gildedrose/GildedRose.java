package com.gildedrose;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

class GildedRose {
    List<Item> items;

    private static final String AGED_BRIE   = "Aged Brie";
    private static final String TAFKAL80ETC = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS    = "Sulfuras, Hand of Ragnaros";

    private static final int SELLIN_LOW   = 11;
    private static final int SELLIN_LOWER = 6;

    public GildedRose(Item[] items) {
        this.items = Arrays.asList(items);
    }

    private Consumer<Item> consumer = new Consumer<Item>() {

        @Override
        public void accept(Item item) {
            if(item.is(SULFURAS)){
                processSulfuras(item);
            }
            if(item.is(TAFKAL80ETC)){
                processTafkal(item);
            }
            if(item.is(AGED_BRIE)){
                processAgedBrie(item);
            }
        }

        private void processAgedBrie(Item item) {
            if(item.hasLowQuality()){
                item.increaseQuality();
                if(item.hasNegativeSellIn()){
                    item.decreaseQuality();
                }
            } else if(item.hasQuality()){
                item.decreaseQuality();
            }
            item.decreaseSellIn();
        }

        private void processTafkal(Item item) {
            if(item.hasLowQuality()){
                item.increaseQuality();
                if(item.hasNegativeSellIn()){
                    item.decreaseQuality();
                }
                if(item.compareSellIn(SELLIN_LOW)){
                    item.increaseQuality();
                }
                if(item.compareSellIn(SELLIN_LOWER)){
                    item.increaseQuality();
                }
            } else if(item.hasQuality()){
                item.decreaseQuality();
            }
            item.decreaseSellIn();
        }

        private void processSulfuras(Item item) {
            if(item.hasNegativeSellIn()){
                item.resetQuality();
            }
        }
    };

    public void updateQuality() {
        this.items.stream().forEach(consumer);
    }
}