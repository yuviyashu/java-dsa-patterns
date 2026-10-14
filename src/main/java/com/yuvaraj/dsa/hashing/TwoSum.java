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
     * {@code target}, or an empty array if no such pair exists.
     *
     * @throws IllegalArgumentException if {@code nums} is null
     */
    public static int[] twoSum(int[] nums, int target) {

        if (nums == null) {
            throw new IllegalArgumentException("nums must not be null");
        }

        Map<Integer, Integer> board = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (board.containsKey(diff)) {
                return new int[]{board.get(diff), i};
            } else {
                board.put(nums[i], i);
            }
        }
        return new int[]{};
    }



}
