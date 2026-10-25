package com.yuvaraj.dsa.binarysearch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class SearchInRotatedArrayTest {

    @Test
    void findsTargetInRightHalf() {
        assertEquals(4, SearchInRotatedArray.searchInRotatedArray(new int[] {4, 5, 6, 7, 0, 1, 2}, 0));
    }

    @Test
    void findsTargetInLeftHalf() {
        assertEquals(1, SearchInRotatedArray.searchInRotatedArray(new int[] {4, 5, 6, 7, 0, 1, 2}, 5));
    }

    @Test
    void returnsMinusOneWhenAbsent() {
        assertEquals(-1, SearchInRotatedArray.searchInRotatedArray(new int[] {4, 5, 6, 7, 0, 1, 2}, 3));
    }

    @Test
    void findsEveryElementForEveryRotation() {
        int[] sorted = {1, 3, 5, 7, 9, 11};
        for (int shift = 0; shift < sorted.length; shift++) {
            int[] rotated = new int[sorted.length];
            for (int i = 0; i < sorted.length; i++) {
                rotated[i] = sorted[(i + shift) % sorted.length];
            }
            for (int i = 0; i < rotated.length; i++) {
                assertEquals(i, SearchInRotatedArray.searchInRotatedArray(rotated, rotated[i]),
                        "rotation " + shift + ", value " + rotated[i]);
            }
        }
    }

    @Test
    void handlesNotRotatedArray() {
        assertEquals(2, SearchInRotatedArray.searchInRotatedArray(new int[] {1, 2, 3, 4}, 3));
    }

    @Test
    void handlesTwoElements() {
        assertEquals(1, SearchInRotatedArray.searchInRotatedArray(new int[] {3, 1}, 1));
        assertEquals(0, SearchInRotatedArray.searchInRotatedArray(new int[] {3, 1}, 3));
    }

    @Test
    void handlesNegativeNumbers() {
        assertEquals(3, SearchInRotatedArray.searchInRotatedArray(new int[] {2, 5, -7, -1}, -1));
    }

    @Test
    void handlesSingleElement() {
        assertEquals(0, SearchInRotatedArray.searchInRotatedArray(new int[] {1}, 1));
        assertEquals(-1, SearchInRotatedArray.searchInRotatedArray(new int[] {1}, 0));
    }

    @Test
    void returnsMinusOneForEmptyArray() {
        assertEquals(-1, SearchInRotatedArray.searchInRotatedArray(new int[] {}, 5));
    }

    @Test
    void throwsOnNullArray() {
        assertThrows(NullPointerException.class, () -> SearchInRotatedArray.searchInRotatedArray(null, 0));
    }
}
