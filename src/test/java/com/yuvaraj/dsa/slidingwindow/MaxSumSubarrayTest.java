package com.yuvaraj.dsa.slidingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MaxSumSubarrayTest {

    @Test
    void findsMaxWindowInBasicExample() {
        // windows: 2+1+5=8, 1+5+1=7, 5+1+3=9, 1+3+2=6
        assertEquals(9, MaxSumSubarray.maxSumSubarray(new int[] {2, 1, 5, 1, 3, 2}, 3));
    }

    @Test
    void findsMaxWindowAtStart() {
        assertEquals(15, MaxSumSubarray.maxSumSubarray(new int[] {9, 6, 1, 1, 1}, 2));
    }

    @Test
    void findsMaxWindowAtEnd() {
        assertEquals(17, MaxSumSubarray.maxSumSubarray(new int[] {1, 1, 1, 8, 9}, 2));
    }

    @Test
    void windowOfSizeOneReturnsMaxElement() {
        assertEquals(7, MaxSumSubarray.maxSumSubarray(new int[] {3, -2, 7, 4}, 1));
    }

    @Test
    void windowCoveringWholeArrayReturnsTotal() {
        assertEquals(10, MaxSumSubarray.maxSumSubarray(new int[] {1, 2, 3, 4}, 4));
    }

    @Test
    void handlesAllNegativeNumbers() {
        // windows: -3, -5, -7; the best is the least negative
        assertEquals(-3, MaxSumSubarray.maxSumSubarray(new int[] {-1, -2, -3, -4}, 2));
    }

    @Test
    void handlesMixedSigns() {
        // windows: 2, -3, 8, 1
        assertEquals(8, MaxSumSubarray.maxSumSubarray(new int[] {4, -2, -1, 9, -7}, 2));
    }

    @Test
    void handlesDuplicateValues() {
        assertEquals(10, MaxSumSubarray.maxSumSubarray(new int[] {5, 5, 5, 5}, 2));
    }

    @Test
    void handlesSingleElement() {
        assertEquals(42, MaxSumSubarray.maxSumSubarray(new int[] {42}, 1));
    }

    @Test
    void returnsZeroForEmptyArrayWithZeroWindow() {
        assertEquals(0, MaxSumSubarray.maxSumSubarray(new int[] {}, 0));
    }
}
