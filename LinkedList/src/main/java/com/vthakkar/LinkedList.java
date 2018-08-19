package com.vthakkar;

import java.util.HashSet;
import java.util.NoSuchElementException;

public class LinkedList<T extends Comparable> {
    public Node head;
    public static int size;

    private class Node {
        private T data;
        Node next;

        public Node(T data) {
            this.data = data;
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
}
