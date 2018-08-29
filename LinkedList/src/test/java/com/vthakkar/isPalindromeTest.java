package com.vthakkar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class isPalindromeTest {

    @Test
    void isPalindrome() {
        LinkedListNode node1 = new LinkedListNode(1);
        node1 = LinkedListAddSum.insertBefore(node1, 2);
        node1 = LinkedListAddSum.insertBefore(node1, 3);
        node1 = LinkedListAddSum.insertBefore(node1, 2);
        node1 = LinkedListAddSum.insertBefore(node1, 1);
//        node1 = LinkedListAddSum.insertBefore(node1, 1);

        System.out.println(isPalindrome.isPalindrome(node1));
    }
}