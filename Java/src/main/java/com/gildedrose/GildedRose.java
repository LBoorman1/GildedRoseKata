package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {
            String itemName = item.name;
            switch (itemName) {
                case "Aged Brie" -> updateAgedBrie(item);
                case "Backstage passes to a TAFKAL80ETC concert" -> updateBackstagePass(item);
                case "Sulfuras, Hand of Ragnaros" -> {}
                default -> updateOtherItems(item);
            }
        }
    }

    //This method handles all logic for items other than special items
    private static void updateOtherItems(Item item) {
        if (item.quality > 0) {
                item.quality--;
        }
        decreaseSellIn(item);
        if(item.sellIn < 0) {
            item.quality--;
        }

    }

    //This method handles all logic for backstage passes
    private static void updateBackstagePass(Item item) {
        if(item.quality < 50) {
            item.quality++;
            if(item.sellIn < 6) {
                item.quality+=2;
            } else if (item.sellIn < 11) {
                item.quality++;
            }
        }
        decreaseSellIn(item);
        if(item.sellIn < 0) {
            item.quality = 0;
        }

    }

    //This method handles all logic if the item is aged brie
    private static void updateAgedBrie(Item item) {
        decreaseSellIn(item);
        if(item.quality < 50) {
            item.quality++;
            if(item.sellIn < 0) {
                item.quality++;
            }
        }

    }
    private static void decreaseSellIn(Item item) {
        item.sellIn--;
    }
}
