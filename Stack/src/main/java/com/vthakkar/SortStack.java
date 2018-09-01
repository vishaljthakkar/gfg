package com.vthakkar;

/* CTCI 3.5 pg. 249 */
public class SortStack {

    public static void sortStack(Stack<Integer> originalStack) {
        Stack<Integer> tempStack = new Stack<>();

        if (!originalStack.isEmpty()) {
            tempStack.push(originalStack.pop());
        }
        while(!originalStack.isEmpty()) {
            int tmp = originalStack.pop();
            while(!tempStack.isEmpty() && tmp < tempStack.peek()) {
                originalStack.push(tempStack.pop());
            }
            tempStack.push(tmp);
        }

        while (!tempStack.isEmpty())
            originalStack.push(tempStack.pop());
    }
}
