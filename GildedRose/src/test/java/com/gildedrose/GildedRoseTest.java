package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void AgedBrieQualityIncreases() {
        Item[] items = new Item[]{new Item("Aged Brie", 2, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);
    }

    @Test
    void AgedBrieQualityIncreasesWithSellInZero() {
        Item[] items = new Item[]{new Item("Aged Brie", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void AgedBrieQualityIncreasesWithSellInNegative() {
        Item[] items = new Item[]{new Item("Aged Brie", -1, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }

    @Test
    void AgedBrieQualityIncreasesWithFullQuality() {
        Item[] items = new Item[]{new Item("Aged Brie", 2, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);
    }

    @Test
    void SulfurasQualityDoesNotChange() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 2, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(20, app.items[0].quality);
        assertEquals(2, app.items[0].sellIn);
    }

    @Test
    void SulfurasQualityDoesNotChangeWithSellInZero() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 0, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(20, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    void SulfurasQualityDoesNotChangeWithSellInNegative() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", -1, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(20, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }
}
