package com.vthakkar;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.jupiter.api.Test;

import static com.vthakkar.StringRotation.isRotation;
import static org.junit.jupiter.api.Assertions.*;

class StringRotationTest {

    @Test
    void isRotationTest() {
        assertTrue(isRotation("waterbottle", "erbottlewat"));
        assertFalse(isRotation("waterbottle", "erbottlewata"));
        assertTrue(isRotation("a", "a"));
        assertFalse(isRotation("abba", "abab"));
        assertTrue(isRotation("abba", "baab"));
        assertTrue(isRotation("", ""));
    }
}