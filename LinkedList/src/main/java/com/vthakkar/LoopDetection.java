package com.vthakkar;

public class LoopDetection {

    public LinkedListNode findBeginning(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            /* Collision */
            if (slow == fast) {
                break;
            }
        }

        /* No meeting point. */
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        LinkedListNode result = fast;
        result.next = null;
        return result;
    }
}
