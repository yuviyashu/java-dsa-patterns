package com.yuvaraj.dsa.slidingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class LongestSubstringTest {

    @Test
    void findsLongestInBasicExample() {
        assertEquals(3, LongestSubstring.lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    void handlesAllSameCharacters() {
        assertEquals(1, LongestSubstring.lengthOfLongestSubstring("bbbbb"));
    }

    @Test
    void findsSubstringNotSubsequence() {
        // "wke" is the answer; "pwke" is a subsequence, not a substring
        assertEquals(3, LongestSubstring.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    void returnsFullLengthWhenAllDistinct() {
        assertEquals(6, LongestSubstring.lengthOfLongestSubstring("abcdef"));
    }

    @Test
    void shrinksWindowPastEarlierDuplicate() {
        // after the second 'b' the window restarts at "b"; the later 'a' must not pull it back
        assertEquals(3, LongestSubstring.lengthOfLongestSubstring("abbac"));
    }

    @Test
    void countsSpacesDigitsAndSymbols() {
        assertEquals(5, LongestSubstring.lengthOfLongestSubstring("a1 b!a"));
    }

    @Test
    void treatsCaseAsDistinct() {
        assertEquals(2, LongestSubstring.lengthOfLongestSubstring("aA"));
    }

    @Test
    void countsSingleSpaceAsLengthOne() {
        assertEquals(1, LongestSubstring.lengthOfLongestSubstring(" "));
    }

    @Test
    void handlesSingleCharacter() {
        assertEquals(1, LongestSubstring.lengthOfLongestSubstring("z"));
    }

    @Test
    void returnsZeroForEmptyString() {
        assertEquals(0, LongestSubstring.lengthOfLongestSubstring(""));
    }

    @Test
    void throwsOnNull() {
        assertThrows(NullPointerException.class, () -> LongestSubstring.lengthOfLongestSubstring(null));
    }
}
