package com.jia.leetCode;
/**
 * 
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。

	示例:
	
	输入: 38
	输出: 2 
	解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
	进阶:
	你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
	
 * 
 * @author Administrator
 *
 */
public class Pro0258 {
    /**
    ab = a*10 + b
    ab % 9 = (a*9 + a+b) % 9 = (a+b)% 9
    
    因为num%9的时候那么可以计算[0..8]  当num=9时，计算为零，故技巧用1+(num-1)%9 可以计算[1..9]
    **/
    public int addDigits(int num) {
        return 1+(num-1)%9;  
    }
}
