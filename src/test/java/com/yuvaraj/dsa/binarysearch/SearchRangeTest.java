package com.yuvaraj.dsa.binarysearch;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class SearchRangeTest {

    @Test
    void findsRangeOfRepeatedValue() {
        assertArrayEquals(new int[] {3, 4}, SearchRange.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8));
    }

    @Test
    void returnsMinusOnesWhenAbsent() {
        assertArrayEquals(new int[] {-1, -1}, SearchRange.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 6));
    }

    @Test
    void returnsSameIndexTwiceForSingleOccurrence() {
        assertArrayEquals(new int[] {1, 1}, SearchRange.searchRange(new int[] {1, 2, 3}, 2));
    }

    @Test
    void findsRangeAtBothEnds() {
        assertArrayEquals(new int[] {0, 1}, SearchRange.searchRange(new int[] {4, 4, 6, 9}, 4));
        assertArrayEquals(new int[] {2, 3}, SearchRange.searchRange(new int[] {1, 3, 9, 9}, 9));
    }

    @Test
    void coversWholeArrayWhenAllEqual() {
        assertArrayEquals(new int[] {0, 4}, SearchRange.searchRange(new int[] {2, 2, 2, 2, 2}, 2));
    }

    @Test
    void handlesNegativeNumbers() {
        assertArrayEquals(new int[] {1, 3}, SearchRange.searchRange(new int[] {-8, -3, -3, -3, 0}, -3));
    }

    @Test
    void returnsMinusOnesWhenTargetOutsideRange() {
        assertArrayEquals(new int[] {-1, -1}, SearchRange.searchRange(new int[] {2, 4, 6}, 1));
        assertArrayEquals(new int[] {-1, -1}, SearchRange.searchRange(new int[] {2, 4, 6}, 7));
    }

    @Test
    void handlesSingleElement() {
        assertArrayEquals(new int[] {0, 0}, SearchRange.searchRange(new int[] {1}, 1));
        assertArrayEquals(new int[] {-1, -1}, SearchRange.searchRange(new int[] {1}, 0));
    }

    @Test
    void returnsMinusOnesForEmptyArray() {
        assertArrayEquals(new int[] {-1, -1}, SearchRange.searchRange(new int[] {}, 0));
    }

    @Test
    void throwsOnNullArray() {
        assertThrows(NullPointerException.class, () -> SearchRange.searchRange(null, 0));
    }
}
