package com.jia.jianzhiOffer;

import java.math.BigInteger;

/**
 * 面试题65. 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。

 

示例:

输入: a = 1, b = 1
输出: 2
 

提示：

a, b 均可能是负数或 0
结果不会溢出 32 位整数
 * @author Administrator
 *
 */
public class Pro65 {
	public int add3(int a, int b) {
		return b == 0? a : add3(a ^ b, (a & b)<<1);
	}
    public int add2(int a, int b) {
        BigInteger b1 = new BigInteger(String.valueOf(a));
        BigInteger b2 = new BigInteger(String.valueOf(b));
        return b1.add(b2).intValue();
    }
    
    public int add(int a, int b) {
    	while(b!=0) {
    		int temp = a ^ b;
    		b = (a&b) << 1;
    		a = temp;
    	}
    	return a;
    }
    public static void main(String[] args) {
		Pro65 pro65 = new Pro65();
		System.out.println(pro65.add(1, 2));
	}
}
