package com.jia.explore.genal.design;

import java.util.Random;

public class Pro01 {
	private int[] nums;
	private int[] shuffleArr;
	private static Random rand = new Random();
	public Pro01(int[] nums) {
		this.nums = nums;
		shuffleArr = new int[nums.length];
		System.arraycopy(nums, 0, shuffleArr, 0, nums.length);
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return nums;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		int length = nums.length;
		for(int i = length; i > 0; i--) {
			int randInd = rand.nextInt(i);
			swap(shuffleArr, randInd, i-1);
		}
		return shuffleArr;
	}
    private static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
