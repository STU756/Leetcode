package com.jia.explore.genal.array;

import java.util.Arrays;

public class Pro03 {
	    public void rotate(int[] nums, int k) {
	        k = k % nums.length;
	        help(nums,0,nums.length - k - 1);
	        help(nums,nums.length - k,nums.length - 1);
	        help(nums,0, nums.length-1);
	    }
	    private void help(int[] nums, int start, int end) {
	        while(start < end){
	            int temp = nums[start];
	            nums[start++] = nums[end];
	            nums[end--] = temp;
	        }
	    }
	    
	    public static void main(String[] args) {
			int[] nums = {1,2};
			int k= 1;
			Pro03 pro03 = new Pro03();
			pro03.rotate(nums,k);
			System.out.println(Arrays.toString(nums));
			
		}
}
