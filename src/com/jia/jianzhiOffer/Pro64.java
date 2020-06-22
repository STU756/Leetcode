package com.jia.jianzhiOffer;
/**
 * 
 * 面试题64. 求1+2+…+n
求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

 

示例 1：

输入: n = 3
输出: 6
示例 2：

输入: n = 9
输出: 45
 

限制：

1 <= n <= 10000
通过次数2,719提交次数3,
 * @author Administrator
 *
 */
public class Pro64 {
	/**
	 * 利用&&短路来结束递归
	 * @param n
	 * @return
	 */
    public int sumNums(int n) {
        int sum = n;
        boolean a = (n > 0) && ((sum+=sumNums(n - 1))>0);
        return sum;
    }
}
