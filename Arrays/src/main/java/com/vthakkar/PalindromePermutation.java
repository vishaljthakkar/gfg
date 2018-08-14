package com.vthakkar;

/*
Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
A palindrome is a word or phrase that is the same forwards and backwards.
 A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
 EXAMPLE
Input: Tact Coa
Output: True (permutations: "taco cat'; "atc o eta·; etc.)
 */
public class PalindromePermutation {
    public static final int MAX_ASCII_LENGTH = 128;

    // Assumption of ASCII chars in the given string.
    // Check ctci pg # 197 for another interesting approach
    public static boolean isPalindromePermutation(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input null or empty");
        }

        String normalizeInput = input.toLowerCase();

        int trueLength = 0;
        int[] charCount = new int[MAX_ASCII_LENGTH];
        int singleCharCount = 0;

        for(char c : normalizeInput.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                charCount[c] += 1;
                if ((charCount[c] % 2) == 1) {
                    singleCharCount++;
                } else {
                    singleCharCount--;
                }
            }
        }
        return singleCharCount <= 1;
    }
}
