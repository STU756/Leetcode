package com.jia.leetCode;
/**
 * x 的平方根
 * 
 * 实现 int sqrt(int x) 函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例 1:

输入: 4
输出: 2
示例 2:

输入: 8
输出: 2
说明: 8 的平方根是 2.82842..., 
     由于返回类型是整数，小数部分将被舍去。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sqrtx
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * @author Administrator
 *
 */
public class Pro0069 {
    public int mySqrt(int x) {
    	//long类型照顾特殊测试用例2147395599，mid*mid会溢出
    	//left = 0照顾0把左边界设为0，right=x/2+1 加一是为了照顾右边界1
    	long left = 0, right = x / 2 + 1;
    	while(left < right) {
    		//这里一定取右中位数，如果取左中位数，代码会进入死循环
    		long mid = (left + right + 1) >> 1;
    		if(mid * mid > x) {
    			right = mid - 1;
    		}else {
    			left = mid;
    		}
    	}
    	return (int) left;
    }
}
