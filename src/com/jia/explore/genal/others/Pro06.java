package com.jia.explore.genal.others;

/***
 * 
 * 缺失数字
给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。

示例 1:

输入: [3,0,1]
输出: 2
示例 2:

输入: [9,6,4,2,3,5,7,0,1]
输出: 8
说明:
你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 * 
 * 
 * @author Administrator
 *
 */
public class Pro06 {
    public int missingNumber(int[] nums) {
    	int ans = nums[0];
    	int max = nums[0];
        for(int i = 1; i <nums.length; i++) {
        	ans ^= nums[i];
        	max = Math.max(max, nums[i]);
        }
        if(max == nums.length - 1) return nums.length;
        for(int i = 0; i <= max; i++) {
        	ans ^= i;
        }
        return ans;
    }
}
