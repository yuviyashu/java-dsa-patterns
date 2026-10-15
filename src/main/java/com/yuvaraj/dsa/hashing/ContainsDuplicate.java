package com.yuvaraj.dsa.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: https://leetcode.com/problems/contains-duplicate/
 * Pattern: Hashing
 * Intuition: Like a doorman with a guest list — each arriving name is checked against the list;
 * if it's already there, someone is entering twice, otherwise the name is added.
 * Time: O(n)   Space: O(n)
 */
public final class ContainsDuplicate {

    private ContainsDuplicate() {
    }

    /**
     * Returns whether any value appears at least twice in {@code nums}.
     *
     * @param nums the values to check
     * @return {@code true} as soon as a repeated value is found, {@code false} if all values are
     *     distinct (including an empty array)
     * @throws NullPointerException if {@code nums} is null
     */
    public static boolean containsDuplicate(int[] nums) {
        // YOUR LOGIC HERE
        Set<Integer> bucket = new HashSet<>();
        for (int num : nums) {
            if (bucket.contains(num)) {
                return true;
            } else {
                bucket.add(num);
            }
        }
        return false;
    }
}
