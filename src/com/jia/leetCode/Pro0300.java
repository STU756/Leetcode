package com.jia.leetCode;

public class Pro0300 {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
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
         }
         return ans;
    }
}
