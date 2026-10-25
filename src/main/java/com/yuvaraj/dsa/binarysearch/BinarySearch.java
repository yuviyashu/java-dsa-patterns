package com.yuvaraj.dsa.binarysearch;

import java.util.Arrays;

/**
 * Problem: https://leetcode.com/problems/binary-search/
 * Pattern: Binary Search
 * Intuition: Like finding a word in a dictionary — open it in the middle, see whether your word
 * comes before or after that page, and throw away the half it can't be in.
 * Time: O(n log n) because of the sort (the search itself is O(log n))   Space: O(1)
 */
public final class BinarySearch {

    private BinarySearch() {
    }

    /**
     * Returns whether {@code searchValue} appears in {@code nums}.
     *
     * <p>Note: sorts {@code nums} in place, so the caller's array is reordered.
     *
     * @param nums the values to search
     * @param searchValue the value to look for
     * @return {@code true} if {@code searchValue} is present, otherwise {@code false}
     * @throws NullPointerException if {@code nums} is null
     */
    public static boolean binarySearch(int[] nums, int searchValue){
        Arrays.sort(nums);
        int size = nums.length;
        int left = 0;
        int right = size-1;

        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == searchValue){
                return true;
            }else if(nums[mid]> searchValue){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return false;
    }
}
