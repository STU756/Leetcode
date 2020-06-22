package com.jia.leetCode;

import java.util.Arrays;
import java.util.stream.Stream;


/**
 * 
 * 递增的三元子序列
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。

	数学表达式如下:
	
	如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
	使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
	说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
	
	示例 1:
	
	输入: [1,2,3,4,5]
	输出: true
	示例 2:
	
	输入: [5,4,3,2,1]
	输出: false
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/increasing-triplet-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Pro0334 {
	public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length <3) {
        	return false;
		}
    	int[][] dp = new int[nums.length][2];
    	dp[0][0] = nums[0];
    	dp[0][1] = 1;
    	int ans = 1;
        for(int i = 1; i < nums.length; i++) {
        	int preMaxIndex = -1;
        	for(int j=0; j<i; j++) {
        		if(dp[j][0] < nums[i]) {
        			if(preMaxIndex!=-1) {
        				preMaxIndex = (dp[preMaxIndex][1] > dp[j][1])?preMaxIndex : j;
        			}else {
        				preMaxIndex = j;
        			}
        		}
        	}
        	dp[i][1] = (preMaxIndex!=-1)? dp[preMaxIndex][1] + 1 : 1;
        	dp[i][0] = nums[i];
        	ans = Math.max(ans, dp[i][1]);
        	if(ans>=3) {
				return true;
			}
        }
        return false;
    }
	public static void main(String[] args) {
		Pro0334 pro0334 = new Pro0334();
		int[] nums = {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,100000000};
		pro0334.increasingTriplet(nums);
	}
}
