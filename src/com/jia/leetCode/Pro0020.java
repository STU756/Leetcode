package com.jia.leetCode;

import java.util.Stack;

public class Pro0020 {
    public boolean isValid(String s) {
    	if(s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	switch (c) {
			case '(':
				stack.push(')');
				break;
			case '{':
				stack.push('}');
				break;
			case '[':
				stack.push(']');
				break;

			default:
				if(stack.isEmpty() || c != stack.pop()) 
					return false;
				break;
			}
        }
        return (stack.size() == 0)? true : false;
    }
    
    public static void main(String[] args) {
		Pro0020 pro0020 = new Pro0020();
		System.out.println(pro0020.isValid("()"));
		System.out.println(pro0020.isValid("()[]{}"));
		System.out.println(pro0020.isValid("(]"));
		System.out.println(pro0020.isValid("([)]"));
		System.out.println(pro0020.isValid("{[]}"));
	}
}
