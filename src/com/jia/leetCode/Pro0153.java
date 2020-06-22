package com.jia.leetCode;

public class Pro0153 {
    /**
     * 有序的半个区域里面不可能有最小值.
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int min = nums[0];
        int left = 0, right = nums.length-1;
        while(left < right) { //不取相等时因为right = mid = left的时候会进入死循环
            int mid = left + ((right - left) >> 1);
            if(nums[left] == nums[mid] && nums[mid] == nums[right]) {
                return findMin(nums, left, right);
            } else if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
    private int findMin(int[] nums, int left, int right) {
        int min = nums[left];
        for(int i = left; i <= right; i++) {
            min = Math.min(min, nums[i]);
        }
        return min;
    }


    public int findMin2(int[] nums) {
        int len = nums.length - 1;
        int left = 0;
        int right = len;
        while( left <= right) {
        	int mid = (left + right) >>> 1;
        	if(nums[mid] > nums[right]) {
        		left = mid + 1;
        	}else {
        		right = mid - 1;
        	}
        }
        return nums[left];
    }
    public static void main(String[] args) {
		int[] nums = {3,1,2};
		System.out.println(new Pro0153().findMin(nums));
	}

}
