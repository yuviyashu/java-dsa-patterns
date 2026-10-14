package com.yuvaraj.dsa.hashing;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TwoSumTest {

    @Test
    void findsPairInBasicExample() {
        assertArrayEquals(new int[] {0, 1}, TwoSum.twoSum(new int[] {2, 7, 11, 15}, 9));
    }

    @Test
    void findsPairNotAtStart() {
        assertArrayEquals(new int[] {1, 2}, TwoSum.twoSum(new int[] {3, 2, 4}, 6));
    }

    @Test
    void handlesDuplicateValues() {
        assertArrayEquals(new int[] {0, 1}, TwoSum.twoSum(new int[] {3, 3}, 6));
    }

    @Test
    void doesNotReuseSameElement() {
        // 5 + 5 = 10, but there is only one 5, so no valid pair exists
        assertArrayEquals(new int[] {}, TwoSum.twoSum(new int[] {5, 1, 2}, 10));
    }

    @Test
    void handlesNegativeNumbers() {
        assertArrayEquals(new int[] {2, 4}, TwoSum.twoSum(new int[] {-1, -2, -3, -4, -5}, -8));
    }

    @Test
    void handlesZeroTarget() {
        assertArrayEquals(new int[] {0, 3}, TwoSum.twoSum(new int[] {0, 4, 3, 0}, 0));
    }

    @Test
    void handlesValuesNearIntegerBounds() {
        assertArrayEquals(
                new int[] {0, 1},
                TwoSum.twoSum(new int[] {Integer.MAX_VALUE, -1, 5}, Integer.MAX_VALUE - 1));
    }

    @Test
    void returnsEmptyWhenNoPairExists() {
        assertArrayEquals(new int[] {}, TwoSum.twoSum(new int[] {1, 2, 3}, 100));
    }

    @Test
    void returnsEmptyForEmptyArray() {
        assertArrayEquals(new int[] {}, TwoSum.twoSum(new int[] {}, 0));
    }

    @Test
    void returnsEmptyForSingleElement() {
        assertArrayEquals(new int[] {}, TwoSum.twoSum(new int[] {5}, 5));
    }

    @Test
    void throwsOnNullArray() {
        assertThrows(IllegalArgumentException.class, () -> TwoSum.twoSum(null, 0));
    }
}
