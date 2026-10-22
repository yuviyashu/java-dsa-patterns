package com.yuvaraj.dsa.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Pattern: Sliding Window
 * Intuition: Like a queue for a photo where no two people may wear the same shirt — when someone
 * arrives in a shirt already in the queue, people leave from the front until that clash is gone.
 * Time: O(n)   Space: O(min(n, charset))
 */
public final class LongestSubstring {

    private LongestSubstring() {
    }

    /**
     * Returns the length of the longest substring of {@code s} with no repeated characters.
     *
     * @param s the string to scan
     * @return the length of the longest substring without repeating characters
     * @throws NullPointerException if {@code s} is null
     */
    public static int lengthOfLongestSubstring(String s) {
        char[] stringArray = s.toCharArray();
        int length = stringArray.length;
        Set<Character> characterSet = new HashSet<>();
        int maxLength = 0;
        int leftPointer = 0;

        for(int rightPointer=0;rightPointer<length;rightPointer++){

            while(characterSet.contains(stringArray[rightPointer])) {
                characterSet.remove(stringArray[leftPointer]);
                leftPointer++;
            }

            characterSet.add(stringArray[rightPointer]);
            maxLength = Math.max(maxLength,rightPointer-leftPointer+1);
        }

        return maxLength;
    }
}
