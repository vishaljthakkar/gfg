package com.vthakkar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCompressionTest {

    @Test
    void compress() {
        System.out.println(StringCompression.compress("aabbccddeeff"));
        System.out.println(StringCompression.compress("aabbbccddeeff"));
        System.out.println("abcd");
    }
}