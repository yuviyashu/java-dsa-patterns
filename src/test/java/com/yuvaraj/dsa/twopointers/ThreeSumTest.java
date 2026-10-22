package com.yuvaraj.dsa.twopointers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class ThreeSumTest {

    @Test
    void findsTripletsInBasicExample() {
        assertEquals(
                List.of(List.of(-1, -1, 2), List.of(-1, 0, 1)),
                ThreeSum.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
    }

    @Test
    void returnsEmptyWhenNoTripletSumsToZero() {
        assertEquals(List.of(), ThreeSum.threeSum(new int[] {0, 1, 1}));
    }

    @Test
    void findsAllZeroTriplet() {
        assertEquals(List.of(List.of(0, 0, 0)), ThreeSum.threeSum(new int[] {0, 0, 0}));
    }

    @Test
    void doesNotRepeatTripletWhenValuesRepeat() {
        assertEquals(List.of(List.of(0, 0, 0)), ThreeSum.threeSum(new int[] {0, 0, 0, 0, 0}));
        assertEquals(List.of(List.of(-2, 0, 2)), ThreeSum.threeSum(new int[] {-2, -2, 0, 0, 2, 2}));
    }

    @Test
    void findsSeveralTripletsSharingFirstValue() {
        assertEquals(
                List.of(List.of(-2, 0, 2), List.of(-2, 1, 1)),
                ThreeSum.threeSum(new int[] {-2, 0, 1, 1, 2}));
    }

    @Test
    void returnsEmptyForAllPositive() {
        assertEquals(List.of(), ThreeSum.threeSum(new int[] {1, 2, 3, 4}));
    }

    @Test
    void returnsEmptyForAllNegative() {
        assertEquals(List.of(), ThreeSum.threeSum(new int[] {-4, -3, -2, -1}));
    }

    @Test
    void returnsEmptyForFewerThanThreeElements() {
        assertEquals(List.of(), ThreeSum.threeSum(new int[] {0, 0}));
        assertEquals(List.of(), ThreeSum.threeSum(new int[] {0}));
    }

    @Test
    void returnsEmptyForEmptyArray() {
        assertEquals(List.of(), ThreeSum.threeSum(new int[] {}));
    }

    @Test
    void sortsInputArrayInPlace() {
        int[] nums = {3, -1, -2};
        ThreeSum.threeSum(nums);
        assertArrayEquals(new int[] {-2, -1, 3}, nums);
    }

    @Test
    void throwsOnNullArray() {
        assertThrows(NullPointerException.class, () -> ThreeSum.threeSum(null));
    }
}
