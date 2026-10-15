package com.yuvaraj.dsa.hashing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ContainsDuplicateTest {

    @Test
    void returnsTrueWhenValueRepeats() {
        assertTrue(ContainsDuplicate.containsDuplicate(new int[] {1, 2, 3, 1}));
    }

    @Test
    void returnsFalseWhenAllDistinct() {
        assertFalse(ContainsDuplicate.containsDuplicate(new int[] {1, 2, 3, 4}));
    }

    @Test
    void returnsTrueWithManyRepeats() {
        assertTrue(ContainsDuplicate.containsDuplicate(new int[] {1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }

    @Test
    void returnsTrueForAdjacentDuplicates() {
        assertTrue(ContainsDuplicate.containsDuplicate(new int[] {7, 7}));
    }

    @Test
    void handlesNegativeNumbers() {
        assertTrue(ContainsDuplicate.containsDuplicate(new int[] {-1, -2, -3, -1}));
        assertFalse(ContainsDuplicate.containsDuplicate(new int[] {-1, 1, -2, 2}));
    }

    @Test
    void handlesZeroAndIntegerBounds() {
        assertTrue(ContainsDuplicate.containsDuplicate(
                new int[] {Integer.MIN_VALUE, 0, Integer.MAX_VALUE, Integer.MIN_VALUE}));
        assertFalse(ContainsDuplicate.containsDuplicate(
                new int[] {Integer.MIN_VALUE, 0, Integer.MAX_VALUE}));
    }

    @Test
    void returnsFalseForEmptyArray() {
        assertFalse(ContainsDuplicate.containsDuplicate(new int[] {}));
    }

    @Test
    void returnsFalseForSingleElement() {
        assertFalse(ContainsDuplicate.containsDuplicate(new int[] {42}));
    }

    @Test
    void throwsOnNullArray() {
        assertThrows(NullPointerException.class, () -> ContainsDuplicate.containsDuplicate(null));
    }
}
