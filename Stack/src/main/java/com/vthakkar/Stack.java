package com.vthakkar;

import java.util.NoSuchElementException;

public class Stack<T> {
    private StackNode<T> topOfStack;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        StackNode<T> current = topOfStack;
        sb.append("TOS").append("=>");
        while(current != null) {
            sb.append(current).append("=>");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }

    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return this.data.toString();
        }
    }

    public T pop() {
        if (topOfStack == null)
            throw new NoSuchElementException("Stack is Empty");
        T result = topOfStack.data;
        topOfStack = topOfStack.next;
        return result;
    }

    public void push(T item) {
        StackNode newNode = new StackNode(item);
        newNode.next = topOfStack;
        topOfStack = newNode;
    }

    public T peek() {
        if (topOfStack == null)
            throw new NoSuchElementException("Stack is empty");
        return topOfStack.data;
    }

    public boolean isEmpty() {
        return topOfStack == null;
    }
}
