package com.vthakkar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackMinTest {

    StackMin stackMin = new StackMin();

    @BeforeEach
    void init() {
        stackMin.push(5);
        stackMin.push(4);
        stackMin.push(10);
        stackMin.push(12);
        stackMin.push(3);
        stackMin.push(22);
        stackMin.push(2);
        stackMin.push(20);
        System.out.println("Stack state");
        System.out.println(stackMin);
    }

    @Test
    void pop() {
        System.out.println("Min after popping");
        stackMin.pop();
        System.out.println(stackMin);
        System.out.println("Min after popping");
        stackMin.pop();
        System.out.println(stackMin);
        System.out.println("Min after popping");
        stackMin.pop();
        System.out.println(stackMin);
    }

    @Test
    void push() {
        System.out.println("Min after pushing");
        stackMin.push(1);
        System.out.println(stackMin);
    }
}