package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateItem();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    @DisplayName("Testing Update Quality with Aged Brie")
    //should increase by 1
    public void testingUpdateQuality(){
        Item[] items = new Item[] { new Item("Aged Brie", 4, 30)};
        GildedRose app = new GildedRose(items);
        app.updateItem();
        assertEquals(31, app.items[0].quality);
    }

    @Test
    @DisplayName("Testing Update Quality with Sulfuras, Hand of Ragnaros")
    //should never decrease
    public void testingUpdateQualityWithSulfurasHandOfRagnaros(){
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 4, 80)};
        GildedRose app = new GildedRose(items);
        app.updateItem();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    @DisplayName("Testing update quality with Ale")
    //should decrease by 1???
    public void testingUpdateQualityWithAle(){
        Item[] items = new Item[] { new Item("Ale", 4, 30)};
        GildedRose app = new GildedRose(items);
        app.updateItem();
        assertEquals(29, app.items[0].quality);
    }

    @Test
    @DisplayName("Testing that quality goes to 0 of concert ticket after reaching sell by date")
    public void testingThatQualityGoesTo0OfConcertTicketAfterReachingSellByDate(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 45)};
        GildedRose app = new GildedRose(items);
        app.updateItem();
        assertEquals(0, app.items[0].quality);
    }


    @Test
    @DisplayName("Testing updateQuality to check sellIn values with Ale")
    public void testingUpdateQualityToCheckSellInValues(){
        Item[] items = new Item[] { new Item("Ale", 4, 30)};
        GildedRose app = new GildedRose(items);
        app.updateItem();
        assertEquals(3, app.items[0].sellIn);
    }

    @Test
    @DisplayName("Testing updateQuality to check sellIn with Sulfuras")
    public void testingUpdateQualityToCheckSellInWithSulfuras(){
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 4, 80)};
        GildedRose app = new GildedRose(items);
        app.updateItem();
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    @DisplayName("TestingQualityIncreaseOnPassesThatAreClose")
    public void testingQualityIncreaseOnPassesThatAreClose(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 3, 34)};
        GildedRose app = new GildedRose(items);
        app.updateItem();
        assertEquals(37, app.items[0].quality);
    }

    @Test
    @DisplayName("TestingQualityIncreaseOnPassesThatAreClose9")
    public void testingQualityIncreaseOnPassesThatAreClose9(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 9, 34)};
        GildedRose app = new GildedRose(items);
        app.updateItem();
        assertEquals(36, app.items[0].quality);
    }



}
