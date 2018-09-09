package com.vthakkar.LruCache;

public class Node {
    private Integer key;
    private Integer value;
    private Node next;
    private Node prev;

    public Node(Integer key, Integer value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public void addFirst(Node node) {

    }

    public void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

    }
}
