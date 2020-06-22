package com.jia.explore.genal.array;

import java.util.Arrays;

public class Pro08 {
	public void moveZeroes(int[] nums) {
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[j++] = nums[i];
			}
		}
		Arrays.fill(nums, j, nums.length-1, 0);
	}
}
