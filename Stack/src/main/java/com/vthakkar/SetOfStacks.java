package com.vthakkar;

import java.util.ArrayList;
/* CTCI 3.3 pg. 244 */

public class SetOfStacks {
    private ArrayList<SOSStack> setOfStacks;
    private int stackCapacity;

    public SetOfStacks(int stackCapacity) {
        this.stackCapacity = stackCapacity;
    }

    public SOSStack getLastStack() {
        if (setOfStacks.size() == 0)
            return null;
        return setOfStacks.get(setOfStacks.size() - 1);
    }

    public void push(int item) {
        SOSStack last = getLastStack();
        if (last != null && !last.isFull()) {
            last.push(item);
        } else {
            SOSStack newStack = new SOSStack(stackCapacity);
            newStack.push(item);
            setOfStacks.add(newStack);
        }
    }

    public Integer pop() {
        SOSStack last = getLastStack();
        if (last == null)
            throw new MyEmptyClassException("Stack empty");
        int value = last.pop();
        if (last.size == 0) {
            setOfStacks.remove(setOfStacks.size() - 1);
        }
        return value;
    }

    public int popAtIndex(int index) {
        return leftShift(index, true);
    }

    public int leftShift(int index, boolean removeTop) {
        SOSStack sosStack = setOfStacks.get(index);
        int removedItem;
        if (removeTop)
            removedItem = sosStack.pop();
        else
            removedItem = sosStack.removeBottom();
        if (sosStack.isEmpty()) {
            setOfStacks.remove(index);
        } else if (setOfStacks.size() > index + 1) {
            int v = leftShift(index + 1, false);
            sosStack.push(v);
        }
        return removedItem;
    }
}
