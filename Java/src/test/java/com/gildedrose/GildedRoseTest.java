package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

    @Test
    @DisplayName("Testing Update Quality with Aged Brie")
    //should increase by 1
    public void testingUpdateQuality(){
        Item[] items = new Item[] { new Item("Aged Brie", 4, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(31, app.items[0].quality);
    }

    @Test
    @DisplayName("Testing Update Quality with Sulfuras, Hand of Ragnaros")
    //should never decrease
    public void testingUpdateQualityWithSulfurasHandOfRagnaros(){
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 4, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    @DisplayName("Testing update quality with Ale")
    //should decrease by 1???
    public void testingUpdateQualityWithAle(){
        Item[] items = new Item[] { new Item("Ale", 4, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(29, app.items[0].quality);
    }
}
