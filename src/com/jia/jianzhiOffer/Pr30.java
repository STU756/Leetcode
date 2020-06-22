package com.jia.jianzhiOffer;

import java.util.Stack;

/**
 * 30.包含min函数的栈 题目描述 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 * 
 * @author Administrator
 *
 */
public class Pr30 {
	Stack<Integer> s = new Stack<Integer>();
	Stack<Integer> ms = new Stack<Integer>();

	public void push(int node) {
		s.push(node);
		ms.push(ms.isEmpty() ? node : Math.min(ms.peek(), node));
	}

	public void pop() {
		if (s.isEmpty())
			throw new RuntimeException("stack is empty.");
		s.pop();
		ms.pop();
	}

	public int top() {
		if (s.isEmpty())
			throw new RuntimeException("stack is empty.");
		return s.peek();
	}

	public int min() {
		if (ms.isEmpty())
			throw new RuntimeException("stack is empty.");
		return ms.peek();
	}
}
