package com.vthakkar;

public class checkPermutation {
    public static final int MAX_ASCII_LENGTH = 128;
/*
Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.

Assumption: ASCII String.
 */
    public static boolean isPermutation(String string1, String string2) {
        if (string1 == null || string2 == null) {
            return false;
        }
        if (string1.isEmpty() || string2.isEmpty()) {
            return false;
        }
        if (string1.length() != string2.length()) {
            return false;
        }
        boolean[] checker = new boolean[MAX_ASCII_LENGTH];
        for(int i = 0; i < string1.length(); i++) {
            checker[string1.charAt(i)] = true;
        }
        for(int i = 0; i < string2.length(); i++) {
            if (!checker[string2.charAt(i)]) {
                return false;
            }
        }
        return true;
    }
}
