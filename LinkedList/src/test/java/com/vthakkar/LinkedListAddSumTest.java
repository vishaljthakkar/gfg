package com.vthakkar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListAddSumTest {

    @Test
    void addList() {
        LinkedListNode node1 = new LinkedListNode(7);
        node1 = LinkedListAddSum.insertBefore(node1, 1);
        node1 = LinkedListAddSum.insertBefore(node1, 6);

        LinkedListNode node2 = new LinkedListNode(9);
        node2 = LinkedListAddSum.insertBefore(node2, 2);

        LinkedListAddSum addSum = new LinkedListAddSum();
        System.out.println(addSum.addList(node1, node2));
    }
}