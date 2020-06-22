package com.jia.explore.genal.design;

import java.util.Stack;

/**
 * 
 * 最小栈
设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) -- 将元素 x 推入栈中。
pop() -- 删除栈顶的元素。
top() -- 获取栈顶元素。
getMin() -- 检索栈中的最小元素。
示例:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.
 * 
 * @author Administrator
 *
 */
public class Pro02 {
	Stack<Integer> stack = new Stack<>();
	Stack<Integer> minStack = new Stack<>();
	
    /** initialize your data structure here. */
    public Pro02() {
        
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
