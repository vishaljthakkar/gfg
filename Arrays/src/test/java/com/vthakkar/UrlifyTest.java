package com.vthakkar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UrlifyTest {

    @Test
    void toUrlify1() {
        String inputString = "Mr. John Smith";
        char[] inputArray = inputString.toCharArray();
        char[] inputArray2 = new char[inputString.length() + 4];
        for (int i = 0; i < inputArray.length; i++)
            inputArray2[i] = inputArray[i];
        System.out.println(Urlify.toUrlify(inputArray2, 14));
    }
}