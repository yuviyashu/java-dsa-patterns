package com.yuvaraj.dsa.twopointers;

/**
 * Problem: https://leetcode.com/problems/valid-palindrome/
 * Pattern: Two Pointers
 * Intuition: Like two people reading a sign from opposite ends and walking toward each other —
 * the moment the letters they call out differ, it's not a palindrome.
 * Time: O(n)   Space: O(n)   (the cleaned-up copy of the string)
 */
public final class IsPalindrome {

    private IsPalindrome() {
    }

    /**
     * Returns whether {@code s} reads the same forwards and backwards, considering only ASCII
     * letters and digits and ignoring case.
     *
     * @param s the string to check
     * @return {@code true} if {@code s} is a palindrome; blank strings and strings with no letters
     *     or digits count as palindromes
     * @throws NullPointerException if {@code s} is null
     */
    public static boolean isPalindrome(String s) {
        if(s.isBlank()){
            return true;
        }
        s= s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
       char[] charsArray = s.toCharArray();
       int leftPointer = 0;
       int rightPointer = charsArray.length-1;

       while(leftPointer <= rightPointer){
           if(charsArray[leftPointer] != charsArray[rightPointer]){
               return false;
           }else{
               leftPointer++;
               rightPointer--;
           }
       }
       return true;
    }
}
