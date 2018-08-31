package com.vthakkar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class StackTest {
    Stack<Integer> integerStack = new Stack<>();

    @BeforeEach
    void init() {
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        integerStack.push(4);
        integerStack.push(5);
        System.out.println("Current Stack Status");
        System.out.println(integerStack);
    }
    @Test
    void pop() {
        System.out.println("After Pop");
        integerStack.pop();
        System.out.println(integerStack);
    }

    @Test
    void push() {
        System.out.println("After Push");
        integerStack.push(3);
        System.out.println(integerStack);
    }

    @Test
    void peek() {
        System.out.println("Stack peek");
        System.out.println(integerStack.peek());
    }

    @Test
    void isEmpty() {
        System.out.println("Is Empty: " + integerStack.isEmpty());
        pop();
        pop();
        pop();
        pop();
        pop();
        System.out.println("Is Empty: " + integerStack.isEmpty());
    }
}