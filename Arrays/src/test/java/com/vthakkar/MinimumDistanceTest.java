package com.vthakkar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumDistanceTest {

    @Test
    void minDistanceBruteForceTest1() {
        int arr[] = {1, 2};
        assertEquals(1, MinimumDistance.minDistanceBruteForce(arr, 1,2));
    }

    @Test
    void minDistanceBruteForceTest2() {
        int arr[] = {3,4,5};
        assertEquals(2, MinimumDistance.minDistanceBruteForce(arr, 3, 5));
    }

    @Test
    void minDistanceBruteForceTest3() {
        int arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
        assertEquals(4, MinimumDistance.minDistanceBruteForce(arr, 3, 6));
    }

    @Test
    void minDistanceBruteForceTest4() {
        int arr[] =  {2, 5, 3, 5, 4, 4, 2, 3};
        assertEquals(1, MinimumDistance.minDistanceBruteForce(arr, 3, 2));
    }

    @Test
    void minDistanceBruteForceTest5() {
        int arr[] = {};
        assertEquals(-1, MinimumDistance.minDistanceBruteForce(arr, 1, 1));
    }

    @Test
    void minDistanceBruteForceTest6() {
        int arr[] = {1,2,3,4,54,5};
        assertEquals(-1, MinimumDistance.minDistanceBruteForce(arr, 1, 1));
    }

    @Test
    void minDistanceBruteForceTest7() {
        int arr[] =  {-2, 5, 3, -5, -4, 4, 2, -3};
        assertEquals(2, MinimumDistance.minDistanceBruteForce(arr, 3, -2));
    }

    @Test
    void minDistanceTest1() {
        int arr[] = {1, 2};
        assertEquals(1, MinimumDistance.minDistance(arr, 1,2));
    }

    @Test
    void minDistanceTest2() {
        int arr[] = {3,4,5};
        assertEquals(2, MinimumDistance.minDistance(arr, 3, 5));
    }

    @Test
    void minDistanceTest3() {
        int arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
        assertEquals(4, MinimumDistance.minDistance(arr, 3, 6));
    }

    @Test
    void minDistanceTest4() {
        int arr[] =  {2, 5, 3, 5, 4, 4, 2, 3};
        assertEquals(1, MinimumDistance.minDistance(arr, 3, 2));
    }

    @Test
    void minDistanceTest5() {
        int arr[] = {};
        assertEquals(-1, MinimumDistance.minDistance(arr, 1, 1));
    }

    @Test
    void minDistanceTest6() {
        int arr[] = {1,2,3,4,54,5};
        assertEquals(-1, MinimumDistance.minDistance(arr, 1, 1));
    }

    @Test
    void minDistanceTest7() {
        int arr[] =  {-2, 5, 3, -5, -4, 4, 2, -3};
        assertEquals(2, MinimumDistance.minDistance(arr, 3, -2));
    }
}