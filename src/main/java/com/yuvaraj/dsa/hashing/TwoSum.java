package com.yuvaraj.dsa.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum (LeetCode 1): <a href="https://leetcode.com/problems/two-sum/">https://leetcode.com/problems/two-sum/</a>
 *
 * <p>Given an array of integers {@code nums} and an integer {@code target}, return the indices of
 * the two numbers that add up to {@code target}. Each input is assumed to have exactly one
 * solution, and the same element may not be used twice.
 *
 * <p>Pattern: hashing / complement lookup. As we scan, store each value's index in a map; for
 * every element, check whether its complement ({@code target - nums[i]}) has already been seen.
 *
 * <p>Intuition: like pairing dance partners at a party. As each guest arrives, the host checks
 * the guest book for someone who would make the perfect pair; if found, the pair is matched
 * instantly, otherwise the newcomer signs the book and waits for their match to arrive.
 *
 * <p>Time: O(n) — single pass with O(1) average map operations. Space: O(n) for the map.
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
