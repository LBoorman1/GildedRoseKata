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

            sellByDateReached(item);
        }
    }

    private static void updateOtherItems(Item item) {
        if (item.quality > 0) {
                item.quality = item.quality - 1;
        }
        updateSellIn(item);
        sellByDateReached(item);
    }

    private static void updateBackstagePass(Item item) {
        if(item.quality < 50) {
            item.quality++;
            if(item.sellIn < 6) {
                item.quality+=2;
            } else if (item.sellIn < 11) {
                item.quality++;
            }
        }
        updateSellIn(item);
        sellByDateReached(item);
    }


    private static void sellByDateReached(Item item) {
        if (item.sellIn < 0) {
            if (!item.name.equals("Aged Brie")) {
                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality > 0) {
                        item.quality = item.quality - 1;
                    }
                } else {
                    item.quality = 0;
                }
            } else {
                if (item.quality < 50) {
                    item.quality++;
                }
            }
        }
    }

    private static void updateAgedBrie(Item item) {
        if(item.quality < 50) {
            item.quality++;
        }
        updateSellIn(item);
        sellByDateReached(item);
    }
    private static void updateSellIn(Item item) {
        item.sellIn--;
    }
}
