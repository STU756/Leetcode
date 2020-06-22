package com.jia.leetCode;

import java.util.Stack;

public class Pro0155 {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    /** initialize your data structure here. */
    public Pro0155() {

    }

    public void push(int x) {
        if(minStack.isEmpty()) {
            minStack.push(x);
        }else {
            minStack.push(minStack.peek() < x? minStack.peek() : x);
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.isEmpty())
            throw new RuntimeException("stack is empty!");
        stack.pop();
        minStack.pop();
    }

    public int top() {
        if(stack.isEmpty())
            throw new RuntimeException("stack is empty!");
        return stack.peek();
    }

    public int getMin() {
        if(minStack.isEmpty())
            throw new RuntimeException("minStack is empty!");
        return minStack.peek();
    }
}
