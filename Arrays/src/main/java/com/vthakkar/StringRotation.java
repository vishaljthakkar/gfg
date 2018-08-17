package com.vthakkar;


/*
    StringRotation: Assume you have a method isSubString () which checks if one word is a substring of another.
    Given two strings, S1 and S2, write code to check if S2 is a rotation of S1 using only one call to isSubString
    (e.g., "waterbottle" is a rotation of" erbottlewat").
    ctci pg 218
 */
public class StringRotation {
    public static boolean isRotation(String string1, String string2) {
        if (string1 == null || string2 == null) {
            return Boolean.FALSE;
        }
        if (string1.length() == string2.length()) {
            String repeatInput = string2 + string2;
            return isSubString(string1, repeatInput);
        }
        return false;
    }

    private static boolean isSubString(String string1, String string2) {
            return  string2.indexOf(string1) != -1;
    }
}
