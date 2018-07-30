package com.vthakkar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LeaderInArrayTest {

    @Test
    void findLeaderInArrayBF() {
        int[] arr = {16, 17, 4, 3, 5, 2};
//        System.out.println(LeaderInArray.findLeaderInArrayBF(arr));
        assertArrayEquals(LeaderInArray.findLeaderInArrayBF(arr).toArray(), new Integer[]{17, 5, 2});
    }

    @Test
    void findLeaderInArrayBFTest2() {
        int[] arr = {16, 17, 4, 3, 5, 2};
//        System.out.println(LeaderInArray.findLeaderInArrayBF(arr));
        assertArrayEquals(LeaderInArray.findLeaderInArray(arr).toArray(), new Integer[]{2, 5, 17});
    }
}