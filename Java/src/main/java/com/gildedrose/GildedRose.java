package com.gildedrose;

import logging.LoggerInit;

import java.util.logging.Level;
import java.util.logging.Logger;

class GildedRose {
    Item[] items;
    public static final Logger logger = Logger.getLogger(GildedRose.class.getName());

    static {
        LoggerInit.setLoggerParameters(logger);
    }
    public GildedRose(Item[] items) {
        this.items = items;
    }
    //This method is essentially the main method, it is the starting point for this class
    public void updateItem() {

        for (Item item : items) {
            String itemName = item.name;
            if(itemName.startsWith("Conjured")) {
                logger.log(Level.INFO, "Conjured Item is being updated");
                updateConjuredItem(item);
            } else {
                switch (itemName) {
                    case "Aged Brie" -> updateAgedBrie(item);
                    case "Backstage passes to a TAFKAL80ETC concert" -> updateBackstagePass(item);
                    case "Sulfuras, Hand of Ragnaros" -> {
                    }
                    default -> updateOtherItems(item);
                }
            }
        }
    }
    //This method handles all logic for items other than special items
    private static void updateOtherItems(Item item) {
        logger.log(Level.INFO, "Regular Item is being updated");
        try {
            decreaseSellIn(item);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        if (item.quality > 0) {
                item.quality--;
        }
        if(item.sellIn < 0) {
            item.quality--;
        }

    }
    //This method handles all logic for backstage passes
    private static void updateBackstagePass(Item item) {
        logger.log(Level.INFO, "Backstage pass is being updated");
        try {
            decreaseSellIn(item);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        if(item.quality < 50) {
            item.quality++;
            if(item.sellIn < 6) {
                item.quality+=2;
            } else if (item.sellIn < 11) {
                item.quality++;
            }
        }
        if(item.sellIn < 0) {
            item.quality = 0;
        }
    }
    //This method handles all logic if the item is aged brie
    private static void updateAgedBrie(Item item) {
        logger.log(Level.INFO, "Aged Brie is being updated");
        try {
            decreaseSellIn(item);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        if(item.quality < 50 && item.sellIn < 0) {
            item.quality+=2;
        } else if (item.quality < 50) {
            item.quality++;
        }
    }
    private static void updateConjuredItem(Item item) {
        try {
            decreaseSellIn(item);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        if (item.quality > 0) {
            item.quality-=2;
        }
        if(item.sellIn < 0) {
            item.quality-=2;
        }
    }
    public static void decreaseSellIn(Item item) throws SelloutException {
        item.sellIn--;
        if (item.sellIn <= 0) {
            throw new SelloutException("Item is past sell by date!");
        }
    }
}
