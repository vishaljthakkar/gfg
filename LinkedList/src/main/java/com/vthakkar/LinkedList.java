package com.vthakkar;

import java.util.HashSet;

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
}
