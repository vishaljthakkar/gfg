package com.vthakkar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntersectionTest {

    @Test
    void findIntersection() {
        LinkedListNode node1 = new LinkedListNode(7);
        node1 = LinkedListAddSum.insertBefore(node1, 1);
        node1 = LinkedListAddSum.insertBefore(node1, 6);

        LinkedListNode node2 = new LinkedListNode(9);
        node2 = LinkedListAddSum.insertBefore(node2, 2);
        node2.next = node1.next.next;

        System.out.println(new Intersection().findIntersection(node1, node2));
    }
}