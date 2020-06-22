package com.jia.leetCode;

import java.util.HashMap;
import java.util.Map;


public class Pro0001 {
	public int[] twoSum(int[] nums, int target) {
		int[] a = new int[2];
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for(int i=0; i<nums.length; i++) {
			if(hashMap.containsKey(target - nums[i])) {
				a[0] = hashMap.get(target-nums[i]);
				a[1] = i;
			}else {
				hashMap.put(nums[i], i);
			}
		}
		return a;
	}

	int binarySearch(int[] nums, int target){
		if(nums == null || nums.length == 0)
			return -1;

		int left = 0, right = nums.length;
		while(left < right){
			// Prevent (left + right) overflow
			int mid = left + (right - left) / 2;
			if(nums[mid] == target){ return mid; }
			else if(nums[mid] < target) { left = mid + 1; }
			else { right = mid; }
		}
		System.out.println(left);
		// Post-processing:
		// End Condition: left == right
		if(left != nums.length && nums[left] == target) return left;
		return -1;
	}
	public static void main(String[] args) {
		int[] nums = {-1,0,3,5,9,12};
		Pro0001 pro0001 = new Pro0001();
		System.out.println(pro0001.binarySearch(nums, 40));
	}
}
