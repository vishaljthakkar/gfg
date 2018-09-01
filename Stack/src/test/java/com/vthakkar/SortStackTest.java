package com.vthakkar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortStackTest {

    @Test
    void sortStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(1);
        stack.push(100);
        stack.push(12);
        stack.push(2);
        stack.push(1011);
        System.out.println("Before Sort");
        System.out.println(stack);
        System.out.println("After Sort");
        SortStack.sortStack(stack);
        System.out.println(stack);
    }
}