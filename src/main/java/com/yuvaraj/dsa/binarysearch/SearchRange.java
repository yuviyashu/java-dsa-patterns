package com.yuvaraj.dsa.binarysearch;

/**
 * Problem: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * Pattern: Binary Search
 * Intuition: Like finding where a surname starts and ends in a phone book — on a match, don't stop;
 * keep halving to the left for the first entry, then again to the right for the last.
 * Time: O(log n)   Space: O(1)
 */
public final class SearchRange {

    private SearchRange() {
    }

    /**
     * Returns the first and last index of {@code target} in the sorted array {@code nums}.
     *
     * @param nums values sorted in ascending order
     * @param target the value to look for
     * @return {@code [first, last]}, or {@code [-1, -1]} if {@code target} is not present
     * @throws NullPointerException if {@code nums} is null
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private static int findFirst(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int first = -1;

        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                first = mid;
                right = mid-1;
            }else if(nums[mid] < target){
                left = mid +1;
            }else{
                right = mid -1;
            }
        }

        return first;
    }

    private static int findLast(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int last = -1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                last = mid;
                left = mid+1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid -1;
            }
        }
        return last;
    }
}
