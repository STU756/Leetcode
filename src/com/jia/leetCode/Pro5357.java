package com.jia.leetCode;

import java.util.Stack;

/**
 * 5357.设计一个支持增量的操作的栈
 * 
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class Pro5357 {
	//元素的个数
	private int size;
	private Stack<Integer> stack;
	
	
    public Pro5357(int maxSize) {
    	if(maxSize <= 0)
    		throw new RuntimeException("input value MaxSize error.");
    	this.size = maxSize;
    	stack = new Stack<Integer>();
    }
    
    public void push(int x) {
    	if(stack.size()>=size) {
    		return;
    	}
    	stack.push(x);
    }
    
    public int pop() {
    	if(stack.isEmpty()) {
    		return -1;
    	}
    	return stack.pop();
    }
    
    public void increment(int k, int val) {
    	if(k <=0)
    		throw new RuntimeException("input value k error.");
    	Stack<Integer> s = new Stack<Integer>();
    	while(!stack.isEmpty()) {
    		s.push(stack.pop());
    	}
    	while(!s.isEmpty()) {
    		if(k > 0) {
    			stack.push(s.pop() + val);
    			--k;
    		}else {
    			stack.push(s.pop());
    		}
    	}
    }
    
    public static void main(String[] args) {
    	Pro5357 customStack = new Pro5357(3); // 栈是空的 []
    	customStack.push(1);                          // 栈变为 [1]
    	customStack.push(2);                          // 栈变为 [1, 2]
    	customStack.pop();                            // 返回 2 --> 返回栈顶值 2，栈变为 [1]
    	customStack.push(2);                          // 栈变为 [1, 2]
    	customStack.push(3);                          // 栈变为 [1, 2, 3]
    	customStack.push(4);                          // 栈仍然是 [1, 2, 3]，不能添加其他元素使栈大小变为 4
    	customStack.increment(5, 100);                // 栈变为 [101, 102, 103]
    	customStack.increment(2, 100);                // 栈变为 [201, 202, 103]
    	System.out.println(customStack.pop());;                            // 返回 103 --> 返回栈顶值 103，栈变为 [201, 202]
    	System.out.println(customStack.pop());;                            // 返回 202 --> 返回栈顶值 202，栈变为 [201]
    	System.out.println(customStack.pop());;                            // 返回 201 --> 返回栈顶值 201，栈变为 []
    	System.out.println(customStack.pop());;       // 返回 -1 --> 栈为空，返回 -1
	}
}
