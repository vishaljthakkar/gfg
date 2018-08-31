package com.vthakkar;

import java.util.Arrays;

/* CTCI 3.1 pg 238

    Three in One: Describe how you could use a single array to implement three stacks.


    Approach one: Fixed size stacks
 */
public class FixedMultiStack {
    private int numofStack = 3;
    private int stackCapacity;
    private int[] values;
    private int[] stackSizes;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numofStack; i++) {
            sb.append("Stack ").append(i).append(" Values: ");
            for (int j = 0; j <= stackSizes[i]; j++) {
                sb.append(values[j]).append("\t");
            }
        }
        return sb.toString();
    }

    public FixedMultiStack(int stackSize) {
        this.stackCapacity = stackSize;
        values = new int[numofStack * stackSize];
        stackSizes = new int[numofStack];
    }

    public void push(int stackNum, int item) throws MyFullStackException {
        if (isStackFull(stackNum))
            throw new MyFullStackException("Stack is full");
        values[gettopIndex(stackNum)] = item;
        stackSizes[stackNum]++;
    }

    public int pop(int stackNum) throws MyEmptyClassException {
        if (isStackEmpty(stackNum))
            throw new MyEmptyClassException("Stack is empty");

        int topIndex = gettopIndex(stackNum);
        int res = values[topIndex];
        values[topIndex] = 0;
        stackSizes[stackNum]--;
        return res;
    }

    public int peek(int stackNum) throws MyEmptyClassException {
        if (isStackEmpty(stackNum))
            throw new MyEmptyClassException("Stack is empty");
        int topIndex = gettopIndex(stackNum);
        return values[topIndex];
    }

    public boolean isStackFull(int stackNum) {
        return stackSizes[stackNum] == stackCapacity;
    }

    public int gettopIndex(int stackNum) {
        int offset = stackNum * stackCapacity;
        return offset + stackSizes[stackNum];
    }

    public boolean isStackEmpty(int stackNum) {
        return stackSizes[stackNum] == 0;
    }

}

