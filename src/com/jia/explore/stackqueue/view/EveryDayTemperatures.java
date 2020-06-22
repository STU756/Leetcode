package com.jia.explore.stackqueue.view;

import java.util.Arrays;
import java.util.Stack;

public class EveryDayTemperatures {
    public int[] dailyTemperatures(int[] T) {
    	Stack<Integer> stack = new Stack<>();
    	int[] result = new int[T.length];
//    	Arrays.fill(result, 0);
    	for(int i = 0 ; i < T.length; i++) {
    		while(!stack.isEmpty() && T[i] > T[stack.peek()]) {
    			int index = stack.pop();
    			result[index] = i - index;
    		}
    		stack.push(i);
    	}
    	return result;
    }
}
