package com.jia.jianzhiOffer;

import java.util.Stack;

public class Pro30 {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;
    private int min;

    /** initialize your data structure here. */
    public Pro30() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        dataStack.push(x);
        min = x < min ? x : min;
        minStack.push(min);
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
        min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
