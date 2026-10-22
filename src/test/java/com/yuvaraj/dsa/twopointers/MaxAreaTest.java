package com.yuvaraj.dsa.twopointers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MaxAreaTest {

    @Test
    void findsMaxAreaInBasicExample() {
        // lines at index 1 (8) and 8 (7): width 7 * height 7
        assertEquals(49, MaxArea.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    @Test
    void handlesTwoLines() {
        assertEquals(1, MaxArea.maxArea(new int[] {1, 1}));
    }

    @Test
    void picksInnerPairWhenTallerThanOuterPair() {
        // outer pair: width 3 * 1 = 3; inner pair (10, 10): width 1 * 10 = 10
        assertEquals(10, MaxArea.maxArea(new int[] {1, 10, 10, 1}));
    }

    @Test
    void handlesIncreasingHeights() {
        // best is heights 2 and 4: width 2 * height 2 = 4
        assertEquals(4, MaxArea.maxArea(new int[] {1, 2, 3, 4}));
    }

    @Test
    void handlesDecreasingHeights() {
        assertEquals(4, MaxArea.maxArea(new int[] {4, 3, 2, 1}));
    }

    @Test
    void handlesEqualHeights() {
        assertEquals(15, MaxArea.maxArea(new int[] {5, 5, 5, 5}));
    }

    @Test
    void handlesZeroHeightLines() {
        assertEquals(0, MaxArea.maxArea(new int[] {0, 0}));
        // the two 2s at index 1 and 3: width 2 * height 2
        assertEquals(4, MaxArea.maxArea(new int[] {0, 2, 0, 2}));
    }

    @Test
    void returnsZeroForSingleLine() {
        assertEquals(0, MaxArea.maxArea(new int[] {7}));
    }

    @Test
    void returnsZeroForEmptyArray() {
        assertEquals(0, MaxArea.maxArea(new int[] {}));
    }

    @Test
    void throwsOnNullArray() {
        assertThrows(NullPointerException.class, () -> MaxArea.maxArea(null));
    }
}
