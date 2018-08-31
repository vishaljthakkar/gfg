package com.vthakkar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixedMultiStackTest {

    FixedMultiStack fsm = new FixedMultiStack(3);


    @BeforeEach
    void init() {
        fsm.push(0, 1);
        fsm.push(0, 2);
        fsm.push(0, 3);
        fsm.push(1, 4);
        fsm.push(1, 5);
        fsm.push(1, 6);
        fsm.push(2, 7);
        fsm.push(2, 8);
        fsm.push(2, 9);
        System.out.println("Initial Stack status");
        System.out.println(fsm);
    }

    @Test
    void push() {
        System.out.println("After popping from stack 1 and pushing to stack 1");
        fsm.pop(1);
        fsm.push(1, 10);
        System.out.println(fsm);
    }

    @Test
    void pop() {
        System.out.println("After pop from stack 1");
        fsm.pop(1);
        System.out.println(fsm);
    }

    @Test
    void peek() {
    }
}