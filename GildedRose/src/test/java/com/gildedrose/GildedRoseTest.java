package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void AgedBrieQualityIncreases() {
        Item[] items = new Item[]{new AgedBrie(2, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);
    }

    @Test
    void AgedBrieQualityIncreasesWithSellInZero() {
        Item[] items = new Item[]{new AgedBrie(0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void AgedBrieQualityIncreasesWithSellInNegative() {
        Item[] items = new Item[]{new AgedBrie(-1, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }

    @Test
    void AgedBrieQualityIncreasesWithFullQuality() {
        Item[] items = new Item[]{new AgedBrie(2, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);
    }

    @Test
    void AgedBrieQualityIncreasesWithFourtyNineQuality() {
        Item[] items = new Item[]{new AgedBrie(2, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);
    }

    @Test
    void AgedBrieQualityIncreasesWithSellInZeroAndFullQuality() {
        Item[] items = new Item[]{new AgedBrie(0, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void SulfurasQualityDoesNotChange() {
        Item[] items = new Item[]{new Sulfuras(2, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(20, app.items[0].quality);
        assertEquals(2, app.items[0].sellIn);
    }

    @Test
    void SulfurasQualityDoesNotChangeWithSellInZero() {
        Item[] items = new Item[]{new Sulfuras(0, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(20, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    void SulfurasQualityDoesNotChangeWithSellInNegative() {
        Item[] items = new Item[]{new Sulfuras(-1, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(20, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void SulfrasQualityDoesNotChangeWithZeroQualityAndSellInNegative() {
        Item[] items = new Item[]{new Sulfuras(-1, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void BackstagePassesQualityIncreases() {
        Item[] items = new Item[]{new BackstagePasses(15, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, app.items[0].quality);
        assertEquals(14, app.items[0].sellIn);
    }

    @Test
    void BackstagePassesQualityIncreasesWithSellInTen() {
        Item[] items = new Item[]{new BackstagePasses(10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(22, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void BackstagePassesQualityIncreasesWithSellInFive() {
        Item[] items = new Item[]{new BackstagePasses(5, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(23, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void BackstagePassesQualityIncreasesWithSellInZero() {
        Item[] items = new Item[]{new BackstagePasses(0, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void BackstagePassesQualityIncreasesWithSellInNegative() {
        Item[] items = new Item[]{new BackstagePasses(-1, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }

    @Test
    void BackstagePassesQualityIncreasesWithFullQuality() {
        Item[] items = new Item[]{new BackstagePasses(15, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(14, app.items[0].sellIn);
    }

    @Test
    void BackstagePassesQualityIncreasesWithFourtyNineQuality() {
        Item[] items = new Item[]{new BackstagePasses(2, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);
    }

    @Test
    void OtherItemQualityDecreases() {
        Item[] items = new Item[]{new OtherItem("Item", 2, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);
    }

    @Test
    void OtherItemQualityDecreasesWithSellInZero() {
        Item[] items = new Item[]{new OtherItem("Item", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void OtherItemQualityDecreasesWithSellInNegative() {
        Item[] items = new Item[]{new OtherItem("Item", -1, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }

    @Test
    void OtherItemQualityDecreasesWithZeroQuality() {
        Item[] items = new Item[]{new OtherItem("Item", 2, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);
    }

    @Test
    void OtherItemQualityDecreasesWithZeroQualityAndSellInNegative() {
        Item[] items = new Item[]{new OtherItem("Item", -1, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }
}
