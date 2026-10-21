package com.yuvaraj.dsa.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem: https://leetcode.com/problems/group-anagrams/
 * Pattern: Hashing
 * Intuition: Like a post office sorting letters into mailboxes labelled with each word's letters in
 * alphabetical order — "eat", "tea" and "ate" all land in the "aet" box.
 * Time: O(n·k log k)   Space: O(n·k)   (n = number of strings, k = max string length)
 */
public final class GroupAnagrams {

    private GroupAnagrams() {
    }

    /**
     * Groups the strings in {@code strs} so that anagrams of each other end up in the same list.
     *
     * @param strs the strings to group
     * @return one list per anagram group; neither the groups nor the strings within a group are in
     *     any guaranteed order, and an empty input gives an empty list
     * @throws NullPointerException if {@code strs} or any of its elements is null
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        // YOUR LOGIC HERE
        Map<String, List<String>> bucket = new HashMap<>();
        for (String str : strs) {
            char[] sortedStrArray = str.toCharArray();
            Arrays.sort(sortedStrArray);
            String sortedStr = new String(sortedStrArray);
            bucket.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }
        return bucket.values().stream().toList();
    }
}
