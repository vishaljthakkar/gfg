package com.vthakkar;

/* ctci 2.6  pg 228
Palindrome: Implement a function to check if a linked list is a palindrome.
0 -> 1 -> 2 -> 1 -> 0
 */
public class isPalindrome {

    public static boolean isPalindrome(LinkedListNode head) {
        LinkedListNode reversedList = reverseAndClone(head);
        return isEqual(head, reversedList);
    }

    private static LinkedListNode reverseAndClone(LinkedListNode node) {
        LinkedListNode head = null;
        while(node != null) {
            LinkedListNode n = new LinkedListNode(node.data); //Clone
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    private static boolean isEqual(LinkedListNode head1, LinkedListNode head2) {
        while(head1 != null && head2 != null) {
            if (head1.data != head2.data) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1 == null && head2 == null;
    }
}
