package com.vthakkar;

import java.util.NoSuchElementException;

public class Queue<T> {
    private QueueNode<T> first;
    private QueueNode<T> last;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        QueueNode<T> current = first;
        if (first == null) {
            return "Queue Empty";
        }
        sb.append("first =>");
        while(current != last) {
            sb.append(current.data).append("=>");
            current = current.next;
        }
        sb.append(last.data).append("<= last");
        return sb.toString();
    }

    private static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }
    }

    public void add(T item) {
        QueueNode newNode = new QueueNode(item);
        if (last != null)
            last.next = newNode;
        last = newNode;
        if (first == null)
            first = last;
    }

    public T remove() {
        if (first == null)
            throw new NoSuchElementException("Queue is empty");
        T res = first.data;
        first = first.next;
        if (first == null)
            last = null;
        return res;
    }

    public T peek() {
        if (first == null)
            throw new NoSuchElementException("Queue is empty");
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
