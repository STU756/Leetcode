package com.jia.leetCode;
/**
 * 
 *  整数的各位积和之差
难度
简单

4


收藏

分享
切换为英文
关注
通过次数

2,193

提交次数

2,641

题目描述
评论 (16)
题解(40)
提交记录
给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。

 

示例 1：

输入：n = 234
输出：15 
解释：
各位数之积 = 2 * 3 * 4 = 24 
各位数之和 = 2 + 3 + 4 = 9 
结果 = 24 - 9 = 15
示例 2：

输入：n = 4421
输出：21
解释： 
各位数之积 = 4 * 4 * 2 * 1 = 32 
各位数之和 = 4 + 4 + 2 + 1 = 11 
结果 = 32 - 11 = 21
 

提示：

1 <= n <= 10^5
 * 
 * @author Administrator
 *
 */
public class Pro1281 {
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;
        while(n > 0) {
        	sum += (n % 10);
        	product *= (n % 10);
        	n /= 10;
        }
        return product - sum;
    }
}
