package com.vthakkar;

/*
One Away: There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character.
Given two strings, write a function to check if they are one edit (or zero edits) away.
EXAMPLE
pale, ple true
pales, pale -> true
pale, bale -> true
pale, bae -> false
 */
public class OneAway {

    // ctci pg. 210
    public static Boolean isOneAway(String originalString, String modifiedString) {
        if (originalString == null || originalString.isEmpty() || modifiedString.isEmpty() || modifiedString == null) {
            throw new IllegalArgumentException("Passed string argument cannot be null or empty");
        }
        int originalStringLength = originalString.length();
        int modifiedStringLength = modifiedString.length();

        //Replace
        if (originalStringLength == modifiedStringLength) {
            return isReplace(originalString, modifiedString);
            //Insert
        } else if (originalStringLength + 1 == modifiedStringLength) {
            return  isInsertOrDelete(originalString, modifiedString);
            //delete
        } else if (originalStringLength - 1 == modifiedStringLength) {
            return isInsertOrDelete(modifiedString, originalString);
        }
        return Boolean.FALSE;

    }

    private static Boolean isReplace(String original, String modified) {
        Boolean differenceFound = Boolean.FALSE;
        for(int i = 0; i < original.length(); i++) {
            if (original.charAt(i) != modified.charAt(i)) {
                if (differenceFound) {
                    return Boolean.FALSE;
                }
                differenceFound = Boolean.TRUE;
            }
        }
        return Boolean.TRUE;
    }

    private static Boolean isInsertOrDelete(String original, String modified) {
        int originalIndex = 0;
        int modifiedIndex = 0;

        while(originalIndex < original.length() && modifiedIndex < modified.length()) {
            // Characters matched in both the string.
            if (original.charAt(originalIndex) == modified.charAt(modifiedIndex)) {
                originalIndex++;
                modifiedIndex++;
            } else {
                if (originalIndex != modifiedIndex) {
                    return Boolean.FALSE;
                }
                modifiedIndex++;
            }
        }
        return Boolean.TRUE;
    }
}
