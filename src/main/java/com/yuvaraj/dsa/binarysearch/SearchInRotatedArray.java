package com.yuvaraj.dsa.binarysearch;

/**
 * Problem: https://leetcode.com/problems/search-in-rotated-sorted-array/
 * Pattern: Binary Search
 * Intuition: Like a shuffled deck that was cut once — whichever half you open, one side is still
 * in order, so check if the card can be in that ordered side; if not, it's in the other half.
 * Time: O(log n)   Space: O(1)
 */
public final class SearchInRotatedArray {

    private SearchInRotatedArray() {
    }

    /**
     * Returns the index of {@code target} in {@code nums}, an ascending array of distinct values
     * that has been rotated at some unknown pivot.
     *
     * @param nums distinct values, sorted ascending and then rotated
     * @param target the value to look for
     * @return the index of {@code target}, or {@code -1} if it is not present
     * @throws NullPointerException if {@code nums} is null
     */
    public static int searchInRotatedArray(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[left] <= nums[mid] ){
                if(nums[left] <= target && target < nums[mid]){
                    right = mid-1;
                }else{
                    left = mid + 1;
                }
            }else{
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid -1;
                }
            }
        }
        return -1;
    }
}
