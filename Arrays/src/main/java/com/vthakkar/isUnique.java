package com.vthakkar;


/* Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures? */
public class isUnique {
    public static final int MAX_ASCII_LENGTH = 128;

    /* Assumption:
        - We'll assume for simplicity the char­ acter set is ASCII. If this assumption is not valid, we would need to increase the storage size.
        - One solution is to create an array of boolean values, where the flag at index i indicates whether character i in the alphabet is contained in the string.
          The second time you see this character you can immediately return false.
        - We can also immediately return false if the string length exceeds the number of unique characters in the alphabet.
          After all, you can't form a string of 280 unique characters out of a 128-character alphabet.
        - It's also okay to assume 256 characters. This would be the case in extended ASCII. You should clarify your assumptions with your interviewer.
     */
    public static Boolean isStringUnique(String str) {
        Boolean retVal = Boolean.FALSE;
        if (str == null || str.isEmpty())
            return retVal;
        /* If string length is greater that this max, then for sure there are duplicates */
        if (str.length() > MAX_ASCII_LENGTH)
            return retVal;
        boolean[] lookup = new boolean[MAX_ASCII_LENGTH];
        for(int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (lookup[val])
                return retVal;
            lookup[val] = Boolean.TRUE;
        }
        return Boolean.TRUE;
    }

    /* We can reduce our space usage by a  ctor of eight by using a bit vector.
    We will assume, in the below code, that the string only uses the lowercase letters a through z.
    This will allow us to use just a single int.
     */
    public static Boolean isStringUniqueBitVector(String str) {
        Boolean retVal = Boolean.FALSE;
        if (str == null || str.isEmpty())
            return retVal;
        /* If string length is greater that this max, then for sure there are duplicates */
        if (str.length() > MAX_ASCII_LENGTH)
            return retVal;
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return Boolean.TRUE;
    }
}
