package com.vthakkar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindMissingNumberTest {

    @Test
    void findMissingNumber() {
        int[] a = {1,2,4,5,6};
        assertEquals(3, FindMissingNumber.findMissingNumber(a, a.length));
    }

    @Test
    void findMissingNumber2() {
        int[] a = {1,2,4,5,6};
        assertEquals(3, FindMissingNumber.findMissingNumber2(a, a.length));
    }
}