package com.yuvaraj.dsa.hashing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Test;

class GroupAnagramsTest {

    @Test
    void groupsBasicExample() {
        assertGroups(
                List.of(List.of("bat"), List.of("nat", "tan"), List.of("ate", "eat", "tea")),
                GroupAnagrams.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    @Test
    void returnsEachStringAloneWhenNoAnagrams() {
        assertGroups(
                List.of(List.of("abc"), List.of("def"), List.of("ghi")),
                GroupAnagrams.groupAnagrams(new String[] {"abc", "def", "ghi"}));
    }

    @Test
    void groupsAllStringsTogetherWhenAllAreAnagrams() {
        assertGroups(
                List.of(List.of("cab", "abc", "bca")),
                GroupAnagrams.groupAnagrams(new String[] {"abc", "bca", "cab"}));
    }

    @Test
    void keepsDuplicateStringsInSameGroup() {
        assertGroups(
                List.of(List.of("ab", "ab", "ba")),
                GroupAnagrams.groupAnagrams(new String[] {"ab", "ba", "ab"}));
    }

    @Test
    void doesNotGroupWordsWithSameLettersButDifferentCounts() {
        assertGroups(
                List.of(List.of("aab"), List.of("abb")),
                GroupAnagrams.groupAnagrams(new String[] {"aab", "abb"}));
    }

    @Test
    void groupsEmptyStringsTogether() {
        assertGroups(
                List.of(List.of("", "")),
                GroupAnagrams.groupAnagrams(new String[] {"", ""}));
    }

    @Test
    void treatsCaseAsDistinct() {
        assertGroups(
                List.of(List.of("Ab"), List.of("ba")),
                GroupAnagrams.groupAnagrams(new String[] {"Ab", "ba"}));
    }

    @Test
    void returnsSingleGroupForSingleString() {
        assertGroups(List.of(List.of("a")), GroupAnagrams.groupAnagrams(new String[] {"a"}));
    }

    @Test
    void returnsEmptyListForEmptyArray() {
        assertEquals(List.of(), GroupAnagrams.groupAnagrams(new String[] {}));
    }

    @Test
    void throwsOnNullArray() {
        assertThrows(NullPointerException.class, () -> GroupAnagrams.groupAnagrams(null));
    }

    // Groups and strings within a group come back in no guaranteed order, so compare sorted copies.
    private static void assertGroups(List<List<String>> expected, List<List<String>> actual) {
        assertEquals(normalize(expected), normalize(actual));
    }

    private static List<List<String>> normalize(List<List<String>> groups) {
        List<List<String>> result = new ArrayList<>();
        for (List<String> group : groups) {
            List<String> sorted = new ArrayList<>(group);
            sorted.sort(Comparator.naturalOrder());
            result.add(sorted);
        }
        result.sort(Comparator.comparing(List::toString));
        return result;
    }
}
