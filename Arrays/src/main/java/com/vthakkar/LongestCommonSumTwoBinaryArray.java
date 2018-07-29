package com.vthakkar;

//https://www.geeksforgeeks.org/longest-span-sum-two-binary-arrays/
public class LongestCommonSumTwoBinaryArray {

    //O(n^2)
    public static int longestCommonSum(int[] array1, int[] array2) {
        int arrayLength = array1.length;

        int maxLen = 0;

        for(int i = 0; i <= arrayLength; i++) {
            int sum1 = 0, sum2 = 0;
            for(int j = i; j < arrayLength; j++) {
                sum1 += array1[j];
                sum2 += array2[j];

                if (sum1 == sum2) {
                    int len = j - i + 1;
                    if (len > maxLen) {
                        maxLen = len;
                    }
                }
                System.out.printf("array1[%d], array2[%d], sum1: %d, sum2: %d, maxLen: %d\n", j, j, sum1, sum2, maxLen);
            }
        }
        return maxLen;
    }

    // O(n)
    public static int longestCommonSumFaster(int[] array1, int[] array2) {
        int arrayLen = array1.length;
        int maxLen = 0;
        int preSum1 = 0, preSum2 = 0;

        int[] diff = new int[(2 * arrayLen) + 1];

        for(int i = 0; i < diff.length; i++) {
            diff[i] = -1;
        }

        for (int i = 0; i < arrayLen; i++) {
            preSum1 += array1[i];
            preSum2 += array2[i];

            int currDiff = preSum1 - preSum2;
            int diffIndex = arrayLen + currDiff;

            if (currDiff == 0) {
                maxLen = i + 1;
            } else if (diff[diffIndex] == -1) {
                diff[diffIndex]  = i;
            } else {
                int len = i - diff[diffIndex];
                if (len > maxLen) {
                    maxLen = len;
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        // See Unit test files.
    }
}
