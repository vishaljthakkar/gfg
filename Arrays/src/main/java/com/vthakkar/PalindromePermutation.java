package com.vthakkar;

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
