package com.yuvaraj.dsa.binarysearch;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

// A wrong midpoint makes binary search loop forever, so fail fast instead of hanging the build.
// SEPARATE_THREAD is needed because a busy loop never checks for interruption.
@Timeout(value = 2, unit = TimeUnit.SECONDS, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
class BinarySearchTest {

    @Test
    void findsValueInMiddle() {
        assertTrue(BinarySearch.binarySearch(new int[] {-1, 0, 3, 5, 9, 12}, 9));
    }

    @Test
    void findsFirstAndLastElements() {
        assertTrue(BinarySearch.binarySearch(new int[] {1, 2, 3, 4, 5}, 1));
        assertTrue(BinarySearch.binarySearch(new int[] {1, 2, 3, 4, 5}, 5));
    }

    @Test
    void findsEveryElementOfLongerArray() {
        int[] nums = {2, 4, 6, 8, 10, 12, 14, 16, 18};
        for (int value : nums.clone()) {
            assertTrue(BinarySearch.binarySearch(nums, value), "should find " + value);
        }
    }

    @Test
    void returnsFalseWhenAbsent() {
        assertFalse(BinarySearch.binarySearch(new int[] {-1, 0, 3, 5, 9, 12}, 2));
        assertFalse(BinarySearch.binarySearch(new int[] {1, 3, 5}, 0));
        assertFalse(BinarySearch.binarySearch(new int[] {1, 3, 5}, 6));
    }

    @Test
    void findsValueInUnsortedInput() {
        assertTrue(BinarySearch.binarySearch(new int[] {9, -3, 7, 0}, 7));
    }

    @Test
    void handlesDuplicatesAndNegatives() {
        assertTrue(BinarySearch.binarySearch(new int[] {-5, -5, -2, 0, 0}, -5));
        assertFalse(BinarySearch.binarySearch(new int[] {-5, -5, -2, 0, 0}, -1));
    }

    @Test
    void handlesSingleElement() {
        assertTrue(BinarySearch.binarySearch(new int[] {4}, 4));
        assertFalse(BinarySearch.binarySearch(new int[] {4}, 3));
    }

    @Test
    void returnsFalseForEmptyArray() {
        assertFalse(BinarySearch.binarySearch(new int[] {}, 1));
    }

    @Test
    void sortsInputArrayInPlace() {
        int[] nums = {3, 1, 2};
        BinarySearch.binarySearch(nums, 2);
        assertArrayEquals(new int[] {1, 2, 3}, nums);
    }

    @Test
    void throwsOnNullArray() {
        assertThrows(NullPointerException.class, () -> BinarySearch.binarySearch(null, 1));
    }
}
