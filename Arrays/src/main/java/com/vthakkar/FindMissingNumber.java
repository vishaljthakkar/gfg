package com.vthakkar;

/* You are given a list of n-1 integers and these integers are in the range of 1 to n.
   There are no duplicates in list.
   One of the integers is missing in the list.
   Write an efficient code to find the missing integer.

 */
public class FindMissingNumber {

    /*
    1.  Get the sum of numbers
        total = n*(n+1)/2
    2.  Subtract all the numbers from sum and
        you will get the missing number.
     */
    public static int findMissingNumber(int numbers[], int n) {
        int total = (n + 1) * (n + 2) / 2;
        for (int i = 0; i < n; i++) {
            total -= numbers[i];
        }
        return total;
    }

    /*
    1) XOR all the array elements, let the result of XOR be X1.
    2) XOR all numbers from 1 to n, let XOR be X2.
    3) XOR of X1 and X2 gives the missing number.
     */

    public static int findMissingNumber2(int numbers[], int n) {
        int x1 = numbers[0]; // This will store xor of the array
        int x2 = 1;          // This will store xor of numbers form 1 to n + 1 (n + 1 because n has one less element)

        for(int i = 1; i < n; i++) {
            x1 ^= numbers[i];
        }

        for(int i = 2; i <= n + 1; i++) {
            x2 ^= i;
        }
        return (x1 ^ x2);
    }

    public static void main(String[] args) {
        // See Unit test files.
    }

}
