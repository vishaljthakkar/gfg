package com.vthakkar;

public class QueueStack<T> {
    Stack<T> oldStack, newStack;

    public QueueStack() {
        oldStack = new Stack<>();
        newStack = new Stack<>();
    }

    public void add(T item) {
        newStack.push(item);
    }

    public T peek() {
        shiftStack();
        return oldStack.peek();
    }

    public T remove() {
        shiftStack();
        return oldStack.pop();
    }

    public void shiftStack() {
        if(oldStack.isEmpty()) {
            while (!newStack.isEmpty())
                oldStack.push(newStack.pop());
        }
    }
}
