package com.vthakkar;

import java.util.ArrayList;
import java.util.List;

/*
Write a program to print all the LEADERS in the array.

An element is leader if it is greater than all the elements to its right side. And the rightmost element is always a leader. For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.

Let the input array be arr[] and size of the array be size.
 */
public class LeaderInArray {

//    O(N^2)
    public static ArrayList<Integer> findLeaderInArrayBF(int array[]) {
        ArrayList<Integer> leaders = new ArrayList<>();

        if (array.length <= 0) {
            System.out.println("Error: Input data should not be empty");
            return leaders;
        }
        for(int i = 0; i < array.length; i++) {
            int j;
            for (j = i + 1; j < array.length; j++) {
                if (array[j] >= array[i]) {
                    break;
                }
            }
            if (j == array.length) {
                leaders.add(array[i]);
            }
        }
        return leaders;
    }

    public static ArrayList<Integer> findLeaderInArray(int[] array) {
        ArrayList<Integer> leaders = new ArrayList<>();

        if (array.length <= 0) {
            System.out.println("Error: Input data should not be empty");
            return leaders;
        }

        int i = array.length;
        int maxSoFar = array[i - 1];
        leaders.add(maxSoFar);

        for (i =  i - 2; i >=0; i--) {
            if (array[i] > maxSoFar) {
                maxSoFar = array[i];
                leaders.add(maxSoFar);
            }
        }
        return leaders;
    }

}
