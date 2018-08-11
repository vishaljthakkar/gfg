package com.vthakkar;

import org.junit.jupiter.api.Test;

import static com.vthakkar.isUnique.isStringUnique;
import static org.junit.jupiter.api.Assertions.*;

class isUniqueTest {

    @Test
    void isStringUnique1() {
        assertTrue(isStringUnique(new String("ABCD")));
    }
    @Test
    void isStringUnique2() {
        assertTrue(isStringUnique(new String("A")));
    }
    @Test
    void isStringUnique3() {
        assertFalse(isStringUnique(new String("AAAAAAA")));
    }
    @Test
    void isStringUnique4() {
        assertFalse(isStringUnique(new String("")));
    }
    @Test
    void isStringUnique5() {
        assertFalse(isStringUnique(new String()));
    }
}