package com.jia.leetCode;

public class Pro5428 {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        for(int i = 0, j = 0, k = n; i < 2*n;) {
            ans[i++] = nums[j++];
            ans[i++] = nums[k++];
        }
        return ans;
    }
}
