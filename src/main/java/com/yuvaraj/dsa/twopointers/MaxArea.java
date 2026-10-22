package com.yuvaraj.dsa.twopointers;

/**
 * Problem: https://leetcode.com/problems/container-with-most-water/
 * Pattern: Two Pointers
 * Intuition: Like stretching a tarp between the two outermost poles and moving the shorter pole
 * inward — the water level is set by the shorter pole, so only replacing it can ever help.
 * Time: O(n)   Space: O(1)
 */
public final class MaxArea {

    private MaxArea() {
    }

    /**
     * Returns the most water that can be held between two of the vertical lines in
     * {@code height}, where the width is the distance between their indices.
     *
     * @param height the line heights
     * @return the maximum area, or {@code 0} if there are fewer than two lines
     * @throws NullPointerException if {@code height} is null
     */
    public static int maxArea(int[] height) {
        // YOUR LOGIC HERE
        int leftPointer = 0;
        int rightPointer = height.length-1;
        int maxArea = 0;

        while(leftPointer < rightPointer){


            int tempArea = (rightPointer - leftPointer) * Math.min(height[leftPointer] , height[rightPointer]);

            if(tempArea > maxArea){
                maxArea = tempArea;
            }

            if(height[leftPointer] < height[rightPointer]){
                leftPointer++;
            }else{
                rightPointer--;
            }
        }
        return maxArea;
    }
}
