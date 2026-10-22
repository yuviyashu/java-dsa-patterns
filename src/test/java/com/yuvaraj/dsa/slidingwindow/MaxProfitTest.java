package com.yuvaraj.dsa.slidingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MaxProfitTest {

    @Test
    void findsBestTradeInBasicExample() {
        // buy at 1, sell at 6
        assertEquals(5, MaxProfit.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
    }

    @Test
    void returnsZeroWhenPricesOnlyFall() {
        assertEquals(0, MaxProfit.maxProfit(new int[] {7, 6, 4, 3, 1}));
    }

    @Test
    void buysAtNewLowAfterEarlierPeak() {
        // 2 -> 8 gives 6, but the later low of 1 -> 9 gives 8
        assertEquals(8, MaxProfit.maxProfit(new int[] {2, 8, 1, 9}));
    }

    @Test
    void keepsEarlierBestWhenLaterLowDoesNotBeatIt() {
        // 1 -> 10 gives 9; the later 0 -> 3 only gives 3
        assertEquals(9, MaxProfit.maxProfit(new int[] {1, 10, 0, 3}));
    }

    @Test
    void handlesSteadilyRisingPrices() {
        assertEquals(4, MaxProfit.maxProfit(new int[] {1, 2, 3, 4, 5}));
    }

    @Test
    void returnsZeroForFlatPrices() {
        assertEquals(0, MaxProfit.maxProfit(new int[] {3, 3, 3}));
    }

    @Test
    void handlesTwoDays() {
        assertEquals(1, MaxProfit.maxProfit(new int[] {1, 2}));
        assertEquals(0, MaxProfit.maxProfit(new int[] {2, 1}));
    }

    @Test
    void returnsZeroForSingleDay() {
        assertEquals(0, MaxProfit.maxProfit(new int[] {5}));
    }

    @Test
    void throwsOnEmptyArray() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> MaxProfit.maxProfit(new int[] {}));
    }

    @Test
    void throwsOnNullArray() {
        assertThrows(NullPointerException.class, () -> MaxProfit.maxProfit(null));
    }
}
