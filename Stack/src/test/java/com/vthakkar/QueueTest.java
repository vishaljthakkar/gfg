package com.vthakkar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    Queue<Integer> integerQueue = new Queue<>();

    @BeforeEach
    void init() {
        integerQueue.add(1);
        integerQueue.add(2);
        integerQueue.add(3);
        integerQueue.add(4);
        integerQueue.add(5);
        System.out.println("Current Queue status");
        System.out.println(integerQueue);
    }
    @Test
    void add() {
        System.out.println("After Add");
        integerQueue.add(100);
        System.out.println(integerQueue);
    }

    @Test
    void remove() {
        System.out.println("After remove");
        integerQueue.remove();
        System.out.println(integerQueue);
    }

    @Test
    void peek() {
        System.out.println("Queue Peek");
        System.out.println(integerQueue.peek());
    }

    @Test
    void isEmpty() {
        System.out.println("Queue Empty? " + integerQueue.isEmpty());
        remove();
        remove();
        remove();
        remove();
        remove();
        System.out.println("Queue Empty? " + integerQueue.isEmpty());
    }
}