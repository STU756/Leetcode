package com.jia.jianzhiOffer;

import java.util.Stack;

/**
 * 31.栈的亚茹和弹出序列
 * 题目描述
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。

例如序列 1,2,3,4,5 是某栈的压入顺序，序列 4,5,3,2,1 是该压栈序列对应的一个弹出序列，但 4,3,5,1,2 就不可能是该压栈序列的弹出序列。
 * @author Administrator
 *
 */
public class Pro31 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int n = pushA.length;
        Stack<Integer> stack = new Stack<Integer>();
        for(int pushAIndex = 0, popAIndex = 0; pushAIndex<n; pushAIndex++){
            stack.push(pushA[pushAIndex]);
            while(popAIndex < n && !stack.isEmpty() && stack.peek() == popA[popAIndex]){
                stack.pop();
                ++popAIndex;
            }
        }
        return stack.isEmpty();
    }
}
