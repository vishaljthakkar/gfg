package com.vthakkar.LruCache;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LRUCache<K, V> {
    /*
     * The LRU cache is a hash table of keys and double linked nodes. The hash table
     * makes the time of get() to be O(1). The list of double linked nodes make the
     * nodes adding/removal operations O(1)
     */

    class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;
        private Node<K, V> prev;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(" Value : " + this.value);
            return sb.toString();
        }
    }

    private int capacity;
    private Node<K, V> head;
    private Node<K, V> tail;
    private Map<K, Node<K, V>> cacheMap = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LRUCache{\n");
        final Set<Map.Entry<K, Node<K, V>>> entries = cacheMap.entrySet();
        for(Map.Entry entry : entries) {
            sb.append(" Key: ").append(entry.getKey()).append(entry.getValue()).append("\n");
        }
        sb.append("\n}");
        return sb.toString();
    }

    /* Remove node if exists and put it in the front of the doubly linked list */
    public int get(int key) {
        if (cacheMap.containsKey(key)) {
            Node<K, V> node = cacheMap.get(Integer.valueOf(key));
            int value = (Integer)node.value;
            removeNode(node);
            setHead(node);
            return value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            Node<K, V> node = cacheMap.get(key);
            node.value = (V)Integer.valueOf(value);
            removeNode(node);
            setHead(node);
        } else {
            Node<K, V> newNode = new Node(key, value);
            if (cacheMap.size() == capacity) {
                cacheMap.remove(tail.key);
                removeNode(tail);
            }
            setHead(newNode);
            cacheMap.put((K)Integer.valueOf(key), newNode);
        }
    }

    /* Utility function */
    private void setHead(Node<K, V> node) {
        node.next = head;
        node.prev = null;
        if (head == null) {
            head = node;
        } else {
            head.prev = node;
            head = node;
        }
        if (tail == null) {
            tail = head;
        }
    }

    private void removeNode(Node<K, V> node) {
        Node prev = node.prev;
        Node next = node.next;

        if (prev != null) {
            prev.next = next;
        } else {
            head = node.next;
        }
        if (next != null) {
            next.prev = prev;
        } else {
            tail = node.prev;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
