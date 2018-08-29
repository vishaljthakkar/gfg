package com.vthakkar;

public class LinkedListNode {
    LinkedListNode next = null;
    int data;

    public LinkedListNode(int data) {
        this.next = null;
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(data).append("->").append(next);
        return sb.toString();
    }
}
