package com.yuvaraj.dsa.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: https://leetcode.com/problems/two-sum/
 * Pattern: Hashing
 * Intuition: Like a host at a party with a guest book — each new guest checks the book for their
 * perfect partner; if they're there, it's an instant match, otherwise they sign in and wait.
 * Time: O(n)   Space: O(n)
 */
public final class TwoSum {

    private TwoSum() {
    }

    /**
     * Returns the indices {@code [i, j]} (with {@code i < j}) of the two elements summing to
     * {@code target}.
     *
     * @throws IllegalArgumentException if {@code nums} is null or no such pair exists
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            throw new IllegalArgumentException("nums must not be null");
        }

        Map<Integer, Integer> indexByValue = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // long arithmetic avoids overflow when target and nums[i] are near int bounds
            long complement = (long) target - nums[i];
            if (complement >= Integer.MIN_VALUE && complement <= Integer.MAX_VALUE) {
                Integer j = indexByValue.get((int) complement);
                if (j != null) {
                    return new int[] {j, i};
                }
            }
            indexByValue.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two elements sum to " + target);
    }
}
