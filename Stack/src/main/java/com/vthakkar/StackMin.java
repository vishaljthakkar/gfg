package com.vthakkar;

/* CTCI 3.2 pg. 243
Stack Min: How would you design a stack which, in addition to push and pop, has a function min
which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 */
public class StackMin extends Stack<Integer> {
    public Stack<Integer> minStack;

    @Override
    public String toString() {
        return super.toString() + " min: " + minStack.peek();

    }

    public StackMin() {
        minStack = new Stack<>();
    }


    @Override
    public Integer pop() {
        int item = super.pop();
        if (item == minStack.peek()) {
            minStack.pop();
        }
        return item;
    }

    @Override
    public void push(Integer item) {
        if(minStack.isEmpty() || (item < minStack.peek())) {
            minStack.push(item);
        }
        super.push(item);
    }
}
