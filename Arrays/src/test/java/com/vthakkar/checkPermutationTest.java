package com.vthakkar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class checkPermutationTest {

    @Test
    void isPermutationTest1() {
        assertTrue(checkPermutation.isPermutation(new String("abcd"), new String("dcba")));
    }
    @Test
    void isPermutationTest2() {
        assertFalse(checkPermutation.isPermutation(new String(""), new String("dcba")));
    }
    @Test
    void isPermutationTest3() {
        assertFalse(checkPermutation.isPermutation(new String("abcd"), new String("")));
    }
    @Test
    void isPermutationTest4() {
        assertFalse(checkPermutation.isPermutation(new String(), new String("")));
    }
    @Test
    void isPermutationTest5() {
        assertFalse(checkPermutation.isPermutation(new String("abcd      "), new String("dcba")));
    }
    @Test
    void isPermutationTest6() {
        assertFalse(checkPermutation.isPermutation(new String("ABCD"), new String("dcba")));
    }
    @Test
    void isPermutationTest7() {
        assertTrue(checkPermutation.isPermutation(new String("aaaa"), new String("aaaa")));
    }
    @Test
    void isPermutationTest8() {
        assertFalse(checkPermutation.isPermutation(new String("aaaa"), new String("aaab")));
    }

}