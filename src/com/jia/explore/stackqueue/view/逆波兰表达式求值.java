package com.jia.explore.stackqueue.view;

import java.util.Stack;

public class 逆波兰表达式求值 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++) {
        	switch (tokens[i]) {
			case "+":
				stack.push(stack.pop() + stack.pop());
				break;
			case "-":
				int val1 = stack.pop();
				int val2 = stack.pop();
				stack.push(val2 - val1);
				break;
			case "*":
				stack.push(stack.pop() * stack.pop());
				break;
			case "/":
				val1 = stack.pop();
				val2 = stack.pop();
				stack.push(val2 / val1);
				break;
			default:
				stack.push(Integer.parseInt(tokens[i]));
				break;
			}
        }
        return stack.peek();
    }
    
    public static void main(String[] args) {
		String[] tokens = {"4","13","5","/","+"};
		逆波兰表达式求值 aa = new 逆波兰表达式求值();
		aa.evalRPN(tokens);
	}
}
