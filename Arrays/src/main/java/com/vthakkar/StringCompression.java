package com.vthakkar;
/*
String Compression: Implement a method to perform basic string compression using the counts of repeated characters.
For example, the string aabcccccaaa would become a2blc5a3. If the "compressed" string would not become smaller than
the original string, your method should return the original string.
You can assume the string has only uppercase and lowercase letters (a - z).
 */
public class StringCompression {
    public static String compress(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            throw new IllegalArgumentException("Null of Empty input");
        }
        StringBuilder sb = new StringBuilder();
        int consecutiveCount = 0;
        for(int i = 0; i < inputString.length(); i++) {
            consecutiveCount++;
            // copy over to new string if consecutive characters differ or we reach the end

            // NOTE: String end check should be done first else you will get Array out of bound exception
            if ((i + 1) >= inputString.length() ||inputString.charAt(i) != inputString.charAt(i + 1)) {
                sb.append(inputString.charAt(i)).append(consecutiveCount);
                consecutiveCount = 0;
            }
        }
        // if all characters in the input string are unique then compressed string is not actually compressed.
        return sb.length() < inputString.length() ? sb.toString() : inputString;
    }
}
