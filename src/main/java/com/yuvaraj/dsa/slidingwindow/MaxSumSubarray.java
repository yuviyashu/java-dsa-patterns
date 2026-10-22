package com.yuvaraj.dsa.slidingwindow;

/**
 * Problem: Max Sum Subarray of Size K (classic exercise; closest LeetCode problem is
 * https://leetcode.com/problems/maximum-average-subarray-i/)
 * Pattern: Sliding Window
 * Intuition: Like a frame sliding over a row of chairs — instead of recounting every chair under
 * the frame, add the chair that enters on the right and drop the one that leaves on the left.
 * Time: O(n)   Space: O(1)
 */
public final class MaxSumSubarray {

    private MaxSumSubarray() {
    }

    /**
     * Returns the largest sum of any {@code k} consecutive elements of {@code nums}.
     *
     * @param nums the values to scan
     * @param k the window size, expected to be between 1 and {@code nums.length}
     * @return the maximum sum over all windows of size {@code k}
     * @throws ArrayIndexOutOfBoundsException if {@code k} is negative or greater than
     *     {@code nums.length}
     * @throws NullPointerException if {@code nums} is null
     */
    public static int maxSumSubarray(int[] nums, int k) {
        int windowSum = 0;
        for(int i=0;i<k;i++){
            windowSum+=nums[i];
        }

        int maxSum = windowSum;

        for(int i=k;i<nums.length;i++){
            windowSum = windowSum + nums[i] - nums[i-k];
            maxSum = Math.max(windowSum,maxSum);
        }
        return maxSum;
    }
}
