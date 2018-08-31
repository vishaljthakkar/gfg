package com.vthakkar;

public class SOSStack {
    private int capacity;
    private SOSNode top;
    private SOSNode bottom;
    public int size = 0;

    public SOSStack(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void updateAboveBelow(SOSNode below, SOSNode above) {
        if (below != null)
            below.above = above;
        if (above != null)
            above.below = below;
    }

    public boolean push(int value) {
        if(size >= capacity)
            return false;
        size++;
        SOSNode newNode = new SOSNode(value);

        if (size == 1)
            bottom = newNode;
        updateAboveBelow(top, newNode);
        top = newNode;
        return true;
    }

    public int pop() {
        if (top == null)
            throw new MyEmptyClassException("Stack is empty");
        SOSNode node = top;
        top = top.below;
        size--;
        return top.value;
    }

    public int removeBottom() {
        SOSNode b = bottom;
        bottom = bottom.above;
        if (bottom != null)
            bottom.below = null;
        size--;
        return b.value;
    }
}
