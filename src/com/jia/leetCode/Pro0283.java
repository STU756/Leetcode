package com.jia.leetCode;

import java.util.Arrays;

public class Pro0283 {
	public void moveZeroes(int[] nums) {
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[j++] = nums[i];
			}
		}
		Arrays.fill(nums, j, nums.length, 0);
	}
}
