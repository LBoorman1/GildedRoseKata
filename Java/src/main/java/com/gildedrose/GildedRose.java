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
                case "Sulfuras, Hand of Ragnaros" -> updateOtherItems(item);
                default -> updateOtherItems(item);
            }

            sellByDateReached(item);
        }
    }

    private static void updateOtherItems(Item item) {
        if (item.quality > 0) {
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.quality = item.quality - 1;
            }
        }
        updateSellIn(item);
        sellByDateReached(item);
    }

    private static void updateAgedBrie(Item item) {
        if(item.quality < 50) {
            item.quality++;
        }
        updateSellIn(item);
        sellByDateReached(item);
    }

    private static void updateBackstagePass(Item item) {
        if(item.quality < 50) {
            item.quality++;
            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
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
                        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    item.quality = 0;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }

    private static void updateSellIn(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn--;
        }
    }
}
