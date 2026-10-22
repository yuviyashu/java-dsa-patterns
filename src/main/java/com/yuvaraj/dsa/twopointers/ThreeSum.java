package com.yuvaraj.dsa.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/3sum/
 * Pattern: Two Pointers
 * Intuition: Like seating three guests whose ages must balance to zero — line everyone up by age,
 * fix the first guest, then two ushers walk in from both ends of the remaining line to find the pair.
 * Time: O(n²)   Space: O(1)   (excluding the output and the sort)
 */
public final class ThreeSum {

    private ThreeSum() {
    }

    /**
     * Returns every distinct triplet of values in {@code nums} that sums to zero.
     *
     * <p>Note: sorts {@code nums} in place, so the caller's array is reordered.
     *
     * @param nums the values to search
     * @return each triplet in ascending order, with no duplicate triplets; an empty list if there
     *     are none or {@code nums} has fewer than three elements
     * @throws NullPointerException if {@code nums} is null
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        int size = nums.length;
        int left =0;
        int right = size-1;
        for(int i = 0 ; i<=size-3; i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }

            if(nums[i]> 0){
                break;
            }

            left = i+1;
            right = size-1;

            while(left<right) {

                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);

                    resultList.add(list);

                    while(left < right && nums[left] == nums[left+1]){
                        left++;
                    }

                    while(left < right && nums[right] == nums[right-1]){
                        right--;
                    }

                    left++;
                    right--;

                }
            }
        }
        return resultList;
    }
}
