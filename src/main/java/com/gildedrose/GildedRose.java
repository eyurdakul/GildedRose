package com.gildedrose;

class GildedRose {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String TAFKAL80ETC = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {

            if(item.name.equals(AGED_BRIE)) {
                if (item.quality < 50) item.quality++;
                if (item.sellIn < 0) item.quality++;
            }

            if(item.name.equals(TAFKAL80ETC)) {
                if (item.quality < 50) item.quality++;
                if (item.sellIn < 11 && item.quality < 50) item.quality++;
                if (item.sellIn < 6 && item.quality < 50) item.quality++;
                if (item.sellIn < 0) item.quality = 0;
            }

            if (!item.name.equals(SULFURAS)) item.sellIn--;

            if (!item.name.equals(AGED_BRIE)
                    && !item.name.equals(TAFKAL80ETC)
                    && !item.name.equals(SULFURAS)
                    && item.quality > 0) {
                item.quality--;
                if(item.sellIn < 0) item.quality--;
            }
        }
    }
}