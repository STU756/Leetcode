package com.jia.explore.stackqueue.view;

import java.util.LinkedList;

public class 用队列实现栈 {
    LinkedList<Integer> list = new LinkedList<Integer>();
  // Push element x onto stack.
  public void push(int x) {
      list.addFirst(x);
  }

  // Removes the element on top of the stack.
  public int pop() {
      return list.removeFirst();
  }

  // Get the top element.
  public int top() {
      return list.peekFirst();
  }

  // Return whether the stack is empty.
  public boolean empty() {
  	return list.isEmpty();
  }
}
