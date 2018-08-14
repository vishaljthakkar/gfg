package com.vthakkar;

import java.util.Arrays;

public class Urlify {

    /*
    URLify : Write a method to replace all spaces in a string with '%20
    You may assume that the string has sufficient space at the end to hold the additional characters,
    and that you are given the "true" length of the string.
    (Note: if implementing in Java, please use a character array so that you can perform this operation in place.)
    EXAMPLE
    Input: "Mr John Smith ", 13 Output: "Mr%20John%20Smith"
     */

    public static String toUrlify(char[] input, int trueLength) {
        if (trueLength <= 0 || input.length <= 0) {
            throw new IllegalArgumentException("True length needs to be positive or passed input is empty");
        }

        int numSpaces = 0;
        for(int i = 0; i < trueLength; i++) {
            if (input[i] == ' ') {
                numSpaces++;
            }
        }

        if (numSpaces != 0) {

            int endIndex = trueLength + 2 * numSpaces; // len(%20) = 3 but space is already factored in the array. So 2.

            for (int i = trueLength - 1; i >= 0; i--) {
                if (input[i] == ' ') {
                    endIndex--;
                    input[endIndex--] = '0';
                    input[endIndex--] = '2';
                    input[endIndex] = '%';
                } else {
                    endIndex--;
                    input[endIndex] = input[i];// zero offset (array starts from 0)
                }
            }
        }
        return Arrays.toString(input);
    }
}
