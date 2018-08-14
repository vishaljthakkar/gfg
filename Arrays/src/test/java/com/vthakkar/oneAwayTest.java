package com.vthakkar;

import org.junit.jupiter.api.Test;

import javax.jws.Oneway;

import static org.junit.jupiter.api.Assertions.*;

class oneAwayTest {

    @Test
    void isOneAway() {
        assertTrue(OneAway.isOneAway("pale", "ple"));
        assertTrue(OneAway.isOneAway("pale", "pales"));
        assertTrue(OneAway.isOneAway("pale", "bale"));
        assertFalse(OneAway.isOneAway("pale", "bae"));
    }
}