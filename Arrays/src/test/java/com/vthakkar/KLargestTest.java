package com.vthakkar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KLargestTest {

    @Test
    void findKthLargest() {
        int[] arr = {1};
        assertEquals(1, KLargest.findKthLargest(arr, 1));
        int[] arr1 = {5,2,1,9,100,444,33,21};
        assertEquals(9, KLargest.findKthLargest(arr1, 5));
    }
}