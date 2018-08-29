package com.vthakkar;

/* ctci LinkedList 2.5 */

/*
Sum Lists: You have two numbers represented by a linked list,where each node contains a single digit. The digits are stored in reverse order,such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
EXAMPLE
Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295. Output:2 -> 1 -> 9.Thatis,912.
FOLLOW UP
Suppose the digits are stored in forward order. Repeat the above problem. Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).Thatis,617 + 295. Output:9 ->1 ->2.Thatis,912.


NOTE: This Solution is for the followup part of above question

 */
public class LinkedListAddSum {
    class PartialSum {
        public LinkedListNode sum = null;
        public int carry = 0;
    }

    public LinkedListNode addList(LinkedListNode head1, LinkedListNode head2) {
        int length1 = length(head1);
        int length2 = length(head2);

        LinkedListNode shorterList = (length1 < length2) ? head1 : head2;
        LinkedListNode longerList = (length1 < length2) ? head2 : head1;

        shorterList = padList(shorterList, Math.abs(length1 - length2));

        PartialSum sum = addListHelper(shorterList, longerList);
        if (sum.carry == 0) {
            return sum.sum;
        } else {
            LinkedListNode result = insertBefore(sum.sum, sum.carry);
            return result;
        }
    }

    private PartialSum addListHelper(LinkedListNode list1, LinkedListNode list2) {
            if (list1 == null && list2 == null) {
                PartialSum sum = new PartialSum();
                return sum;
            }

            PartialSum sum = addListHelper(list1.next, list2.next);

            int val = sum.carry + list1.data + list2.data;
            LinkedListNode fullResult = insertBefore(sum.sum, val % 10);

            sum.sum = fullResult;
            sum.carry = val / 10;
            return sum;
    }

    private int length(LinkedListNode head) {
        LinkedListNode current = head;
        int count = 0;

        while(current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    private LinkedListNode padList(LinkedListNode head, int padCount) {
        LinkedListNode current = head;

        for(int i = 0; i < padCount; i++) {
            current = insertBefore(current, 0);
        }
        return current;
    }

    public static LinkedListNode insertBefore(LinkedListNode head, int data) {
        LinkedListNode node = new LinkedListNode(data);
        if (head != null) {
            node.next = head;
        }
        return node;
    }
}
