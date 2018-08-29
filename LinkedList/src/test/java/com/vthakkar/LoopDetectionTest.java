package com.vthakkar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoopDetectionTest {

    @Test
    void findBeginning() {
        LinkedListNode head = new LinkedListNode(7);
        LinkedListNode node1 = head;
        node1.next = new LinkedListNode(6);
        node1 = node1.next;
        node1.next = new LinkedListNode(5);
        node1 = node1.next;
        node1.next = new LinkedListNode(4);
        node1 = node1.next;
        node1.next = new LinkedListNode(3);
        node1 = node1.next;
        node1.next = new LinkedListNode(2);
        node1 = node1.next;
        node1.next = head.next;


        System.out.println(new LoopDetection().findBeginning(head));
    }
}