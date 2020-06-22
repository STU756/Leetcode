package com.jia.leetCode;

import java.util.Stack;

/**
 * 
 *  每日温度
根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。

例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。

提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 * @author Administrator
 *
 */
public class Pro0793 {
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
