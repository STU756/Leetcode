package com.jia.explore.stackqueue.view;

import java.util.Stack;

public class 用栈实现队列 {
    Stack<Integer> push = new Stack<Integer>(); // this stack is used for pushing new elements
    Stack<Integer> pop = new Stack<Integer>(); // this stacks is used for popping old elements
    // Push element x to the back of queue.
    public void push(int x) {
        push.push(x);
    }

    // Removes the element from in front of queue.
    public int pop() {
        if(!pop.empty()) {
            return pop.pop();
        }
        while(!push.empty()) {
            pop.push(push.pop());
        }
        return pop.pop();
    }
    // Get the front element.
    public int peek() {
        if(!pop.empty()) {
            return pop.peek();
        }
        while(!push.empty()) {
            pop.push(push.pop());
        }
        return pop.peek();
        
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return push.empty() && pop.empty();
    }
}
