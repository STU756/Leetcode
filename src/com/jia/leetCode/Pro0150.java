package com.jia.leetCode;

import java.util.LinkedList;
import java.util.Stack;
import java.util.regex.Pattern;

public class Pro0150 {
	public int evalRPN1(String[] tokens) {
		if (tokens == null || tokens.length == 0)
			return 0;
		int result = 0;
		int a = 0;
		boolean flag = true;
		LinkedList<Integer> stack = new LinkedList<Integer>();
		int j = 0;
		while (j < tokens.length && Pattern.matches("[-+]*[0-9]+", tokens[j])) {
			stack.push(Integer.parseInt(tokens[j]));
			j++;
		}
		result = stack.pollLast();
		System.out.println(result);
		for (int i = j; i < tokens.length; i++) {
			if ("+".equals(tokens[i])) {
				while (!stack.isEmpty()) {
					a = stack.pollFirst();
					result = result + a;
				}
			} else if ("-".equals(tokens[i])) {
				while (!stack.isEmpty()) {
					a = stack.pop();
					System.out.println(a);
					result = result - a;
				}
			} else if ("*".equals(tokens[i])) {
				while (!stack.isEmpty()) {
					a = stack.pop();
					result = result * a;
				}
			} else if ("/".equals(tokens[i])) {
				while (!stack.isEmpty()) {
					a = stack.pop();
					try {
						result = result / a;
					} catch (java.lang.ArithmeticException e) {
						return 0;
					}
				}
			} else {
				stack.push(Integer.parseInt(tokens[i]));
			}

		}
		if (!stack.isEmpty())
			return 0;
		return result;
	}

	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		int a=0;
		int b = 0;
		for(String str : tokens) {
			if(str.equals("+")){
				stack.push(stack.pop() + stack.pop());
			}
			if(str.equals("-")) {
				b = stack.pop();
				a = stack.pop();
				stack.push(a - b);
			}
			if(str.equals("*")) {
				b = stack.pop();
				a = stack.pop();
				stack.push(a * b);
			}
			if(str.equals("/")) {
				b = stack.pop();
				a = stack.pop();
				try {
					stack.push(a / b);
				} catch (ArithmeticException e) {
					return 0;
				}
			}else {
				stack.push(Integer.parseInt(str));
			}
		}
		return stack.pop();
	}

}
