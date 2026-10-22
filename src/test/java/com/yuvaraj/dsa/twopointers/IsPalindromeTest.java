package com.yuvaraj.dsa.twopointers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class IsPalindromeTest {

    @Test
    void acceptsPhraseIgnoringCaseAndPunctuation() {
        assertTrue(IsPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    void rejectsNonPalindrome() {
        assertFalse(IsPalindrome.isPalindrome("race a car"));
    }

    @Test
    void acceptsOddLengthPalindrome() {
        assertTrue(IsPalindrome.isPalindrome("racecar"));
    }

    @Test
    void acceptsEvenLengthPalindrome() {
        assertTrue(IsPalindrome.isPalindrome("abba"));
    }

    @Test
    void ignoresCase() {
        assertTrue(IsPalindrome.isPalindrome("AbBa"));
    }

    @Test
    void treatsDigitsAsSignificant() {
        assertTrue(IsPalindrome.isPalindrome("1a2a1"));
        assertFalse(IsPalindrome.isPalindrome("0P"));
    }

    @Test
    void handlesRepeatedCharacters() {
        assertTrue(IsPalindrome.isPalindrome("aaaa"));
        assertFalse(IsPalindrome.isPalindrome("aaab"));
    }

    @Test
    void acceptsStringWithOnlyPunctuation() {
        assertTrue(IsPalindrome.isPalindrome(".,!?"));
    }

    @Test
    void acceptsSingleCharacter() {
        assertTrue(IsPalindrome.isPalindrome("a"));
    }

    @Test
    void acceptsEmptyString() {
        assertTrue(IsPalindrome.isPalindrome(""));
    }

    @Test
    void acceptsBlankString() {
        assertTrue(IsPalindrome.isPalindrome("   "));
    }

    @Test
    void throwsOnNull() {
        assertThrows(NullPointerException.class, () -> IsPalindrome.isPalindrome(null));
    }
}
