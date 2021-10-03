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
}