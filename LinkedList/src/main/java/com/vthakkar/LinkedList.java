package com.vthakkar;

import java.util.HashSet;
import java.util.NoSuchElementException;

public class LinkedList<T extends Comparable> {
    public Node head;
    public int size;

    public class Node {
        private T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node(Integer integer) {
            this.data = (T) integer;
            this.next = null;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.data).append(" -> ").append(this.next);
            return sb.toString();
        }
    }

    public LinkedList() {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Head -> ").append(head).append(" Size: ").append(size);
        return sb.toString();
    }

    public void insert(T data) {
        Node node = new Node(data);

        if (head == null) {
            head = node;
        } else {
            Node current = head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        size += 1;

    }

    public void deleteDuplicatesUnSorted() {
        deleteDuplicatesUnSorted(head);
    }

    private void deleteDuplicatesUnSorted(Node head) {
        if (head == null || size == 1) {
            return;
        }
        HashSet<T> hashSet = new HashSet<>();
        Node current = head;
        Node previous = null;
        while(current != null) {
            if (hashSet.contains(current.data)) {
                previous.next = current.next;
                size -= 1;
            } else {
                hashSet.add(current.data);
                previous = current;
            }
            current = current.next;
        }
    }

    public void deleteDuplicatesSorted() {
        deleteDuplicatesSorted(head);
    }

    private void deleteDuplicatesSorted(Node head) {
        if (head == null || size == 1) {
            return;
        }
        Node current = head;
        while(current.next != null) {
            if (current.data.compareTo(current.next.data) == 0) {
                current.next = current.next.next;
                size -= 1;
            } else {
                current = current.next;
            }
        }
    }

    // K = 1 return last element, K = 2 return penultimate
    public T findNthToLast(int N) {
        Node p1 = head;
        Node p2 = head;

        if (head == null) {
            throw new NoSuchElementException("Linkedlist is empty");
        }
        for(int i = 0; i < N; i++) {
            if (p2 == null) {
                return null;
            }
            p2 = p2.next;
        }
        while(p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1.data;
    }

    // ctci 222: Delete a node that node itself is supplied and you do not have access to head node.
    public boolean deleteNode(Node node) {
        if (node == null || node.next == null) {
            return Boolean.FALSE;
        }
        Node next = node.next;
        node.data = next.data;
        node.next = next.next;
        return Boolean.TRUE;
    }


    /*
    https://www.geeksforgeeks.org/partitioning-a-linked-list-around-a-given-value-and-keeping-the-original-order/
    ctci pg. 223.
    Partition the node around x such that data less than x comes before x and data more than x comes after x
    but elements on either side should maintain their relative order of precedence.
    Input : 1->4->3->2->5->2->3,
        x = 3
Output: 1->2->2->3->3->4->5

Input : 1->4->2->10
        x = 3
Output: 1->2->4->10

Input : 10->4->20->10->3
        x = 3
Output: 3->10->4->20->10

NOTE: CTCI and Gfg have different approach. Leet code works fine with CTCI
     */

    public Node partition(T x) {
        return partition(head, x);
    }

    private Node partition(Node head, T x) {
        if (head == null) {
            return null;
        }
        Node ltStart = null, ltEnd = null;
        Node gtStart = null, gtEnd = null;
        Node equalStart = null, equalEnd = null;

        while (head != null) {
            // If current node is less than X, append
            // it to the list of smaller values
            if (head .data.compareTo(x) < 0) {
                if (ltStart == null) {
                    ltStart = ltEnd = head;
                } else {
                    ltEnd.next = head;
//                    ltEnd = ltEnd.next;
                    ltEnd = head;
                }
            } else if (head.data.compareTo(x) >= 0) {
                if (gtStart == null) {
                    gtStart = gtEnd = head;
                } else {
                    gtEnd.next = head;
//                    gtEnd = gtEnd.next;
                    gtEnd = head;
                }
            }
                // If current node is equal to x, append it
                // to the list of x values
//            } else if (head.data.compareTo(x) == 0) {
//                    if (equalStart == null) {
//                        equalStart = equalEnd = head;
//                    } else {
//                        equalEnd.next = head;
//                        equalEnd = equalEnd.next;
//                    }
//            }
            head = head.next;
        }

        // Fix end of greater linked list to NULL if this
        // list has some nodes
        if (gtEnd != null)
            gtEnd.next = null;

        // Connect three lists

        // If smaller list is empty
        if (ltStart == null) {
//            if (equalStart == null) {
                return gtStart;
//            }
//            equalEnd.next = gtStart;
//            return equalStart;
        }

        // If smaller list is not empty
        // and equal list is empty
//        if (equalStart == null) {
//            ltEnd.next = gtStart;
//            return ltStart;
//        }

        // If both smaller and equal list
        // are non-empty
        ltEnd.next = gtStart;//equalStart;
//        gtStart.next = gtStart;
        return ltStart;
    }


    /*
    Sum Lists: You have two numbers represented by a linked list,where each node contains a single digit.
    The digits are stored in reverse order,such that the 1's digit is at the head of the list.
    Write a function that adds the two numbers and returns the sum as a linked list.
    EXAMPLE
    Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295. Output:2 -> 1 -> 9.Thatis,912.
    FOLLOW UP
    Suppose the digits are stored in forward order. Repeat the above problem. Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).Thatis,617 + 295. Output:9 ->1 ->2.Thatis,912.

     */

    public <T extends Comparable<T>> Node addTwoNumbers(Node head1, Node head2) {

        Node result = null;
        Node previous = null;
        Node temp = null;
        int carry = 0, sum;

        while(head1 != null || head2 != null) {
            final Integer data1 = head1 != null ?  (Integer) head1.data : 0;
            final Integer data2 = head2 != null ? (Integer) head2.data : 0;
            sum = Integer.sum(carry, Integer.sum(data1, data2));
            carry = (sum >= 10) ? 1 : 0;
            sum = sum % 10;

            temp = new Node(Integer.valueOf(sum));
            if (result == null) {
                result = temp;
            } else {
                previous.next = temp;
            }

            previous = temp;
            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }
        }
        if(carry > 0) {
            temp.next= new Node(Integer.valueOf(carry));
        }
        return result;

    }
}
