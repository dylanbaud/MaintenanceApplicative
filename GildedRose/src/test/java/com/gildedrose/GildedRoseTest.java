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
    void AgedBrieQualityIncreasesWithFourtyNineQuality() {
        Item[] items = new Item[]{new Item("Aged Brie", 2, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);
    }

    @Test
    void AgedBrieQualityIncreasesWithSellInZeroAndFullQuality() {
        Item[] items = new Item[]{new Item("Aged Brie", 0, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
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

    @Test
    void SulfrasQualityDoesNotChangeWithZeroQualityAndSellInNegative() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", -1, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void BackstagePassesQualityIncreases() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, app.items[0].quality);
        assertEquals(14, app.items[0].sellIn);
    }

    @Test
    void BackstagePassesQualityIncreasesWithSellInTen() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(22, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void BackstagePassesQualityIncreasesWithSellInFive() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(23, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void BackstagePassesQualityIncreasesWithSellInZero() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void BackstagePassesQualityIncreasesWithSellInNegative() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", -1, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }

    @Test
    void BackstagePassesQualityIncreasesWithFullQuality() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(14, app.items[0].sellIn);
    }

    @Test
    void BackstagePassesQualityIncreasesWithFourtyNineQuality() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 2, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);
    }

    @Test
    void ConjuredQualityDecreases() {
        Item[] items = new Item[]{new Item("Conjured", 2, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);
    }

    @Test
    void ConjuredQualityDecreasesWithSellInZero() {
        Item[] items = new Item[]{new Item("Conjured", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void ConjuredQualityDecreasesWithSellInNegative() {
        Item[] items = new Item[]{new Item("Conjured", -1, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }

    @Test
    void ConjuredQualityDecreasesWithZeroQuality() {
        Item[] items = new Item[]{new Item("Conjured", 2, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);
    }

    @Test
    void ConjuredQualityDecreasesWithZeroQualityAndSellInNegative(){
        Item[] items = new Item[]{new Item("Conjured", -1, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }
}
