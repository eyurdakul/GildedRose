package com.gildedrose;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

class GildedRose {
    List<Item> items;

    public GildedRose(Item[] items) {
        this.items = Arrays.asList(items);
    }

    private Consumer<Item> consumer = new Consumer<Item>() {

        private Item item;

        @Override
        public void accept(Item item) {
            this.item.process();
        }
    };

    public void updateQuality() {
        this.items.stream().forEach(consumer);
    }
}