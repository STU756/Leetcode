package com.jia.leetCode;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * @author Administrator
 *
 */
public class Pro0042 {
	public int trap(int[] height) {
		int[] left = new int[height.length];
		int[] right = new int[height.length];
		int result = 0;
		if (height == null || height.length == 0)
			return 0;
		// 前缀
		for (int i = 0; i < height.length; i++) {
			left[i] = (i == 0) ? height[i] : Math.max(left[i - 1], height[i]);
		}
		// 后缀
		for (int i = height.length - 1; i >= 0; i--) {
			right[i] = (i == height.length - 1) ? height[i] : Math.max(right[i + 1], height[i]);
		}
		for (int i = 0; i < height.length; i++) {
			result += Math.min(left[i], right[i]) - height[i];
		}
		return result;
	}
}
