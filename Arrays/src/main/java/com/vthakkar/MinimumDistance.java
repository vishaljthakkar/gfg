package com.vthakkar;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/find-the-minimum-distance-between-two-numbers/

Given an unsorted array arr[] and two numbers x and y, find the minimum distance between x and y in arr[].
The array might also contain duplicates. You may assume that both x and y are different and present in arr[].

Examples:
Input: arr[] = {1, 2}, x = 1, y = 2
Output: Minimum distance between 1 and 2 is 1.

Input: arr[] = {3, 4, 5}, x = 3, y = 5
Output: Minimum distance between 3 and 5 is 2.

Input: arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3}, x = 3, y = 6
Output: Minimum distance between 3 and 6 is 4.

Input: arr[] = {2, 5, 3, 5, 4, 4, 2, 3}, x = 3, y = 2
Output: Minimum distance between 3 and 2 is 1.


ASSUMPTION: X and Y are different values
 */
public class MinimumDistance {

    // O(N^2)
    public static int minDistanceBruteForce(int[] array, int x, int y) {
        int mininumDistance = Integer.MAX_VALUE;

        if (array.length <= 0) {
            System.out.println("ERROR: Input data should not be empty");
            return -1;
        }

        if (x == y) {
            System.out.println("ERROR: Give X and Y are the same number");
            return -1;
        }

        for(int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if ((array[i] == x && array[j] == y) || (array[j] == x && array[i] == y ) && mininumDistance > Math.abs(i - j)) {
                    mininumDistance = Math.abs(i - j);
                }
            }
        }

        System.out.printf("Minimum Distance between (%d, %d) in array: %s is %d", x, y, Arrays.toString(array), mininumDistance);
        return mininumDistance;
    }

    // O(N)
    public static int minDistance(int[] array, int x, int y) {
        int minimumDistance = Integer.MAX_VALUE;

        if (array.length <= 0) {
           return -1;
        }
        if (x == y) {
           System.out.println("ERROR: Give X and Y are the same number");
           return -1;
        }

        int i = 0;
        int prev = -1;

        /* Find the first occurence of either x or y */
        for (; i < array.length; i++) {
            if (array[i] == x || array[i] == y) {
                prev = i;
                break;
            }
        }

        for(; i < array.length; i++) {
            if (array[i] == x || array[i] == y) {
                // If the current element matches with any of the two then
                // check if current element and prev element are different
                // Also check if this value is smaller than minimm distance so far
                if (array[prev] != array[i] && minimumDistance > Math.abs(i - prev)) {
                    minimumDistance = Math.abs(i - prev);
                    prev = i;
                } else {
                    prev = i;
                }
            }
        }
        return minimumDistance;
    }
}
