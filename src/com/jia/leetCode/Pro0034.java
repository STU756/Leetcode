package com.jia.leetCode;
/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

	你的算法时间复杂度必须是 O(log n) 级别。
	
	如果数组中不存在目标值，返回 [-1, -1]。
	
	示例 1:
	
	输入: nums = [5,7,7,8,8,10], target = 8
	输出: [3,4]
	示例 2:
	
	输入: nums = [5,7,7,8,8,10], target = 6
	输出: [-1,-1]

 * 
 * 
 * @author Administrator
 *
 */
public class Pro0034 {
	public int[] searchRange2(int[] nums, int target) {
		int left = LBinarySearch(nums, target);
		int right = RBinarySearch(nums, target);
		return new int[]{left, right};
	}

	public int LBinarySearch(int[] nums, int target) {
		int left = 0, right = nums.length;
		while(left < right) {  //  终止条件left = right
			int mid = left + ((right - left) >> 1);
			// [left, mid, right)  [left, mid)  [mid+1, right)
			if(nums[mid] == target) {
				right = mid;
			}else if(nums[mid] < target) {
				left = mid + 1;
			}else {
				right = mid;
			}
		}
		//left取值范围[0, nums.length]
		if(left==nums.length) return -1;
		return nums[left] == target? left : -1;
	}
	public int RBinarySearch(int[] nums, int target) {
		int left = 0, right = nums.length;
		while(left < right) { //终止条件 left = right
			int mid = left + ((right - left) >> 1);
			if(nums[mid] == target) {
				left = mid + 1; //相同向右移
			}else if( nums[mid] < target) {
				left = mid + 1;
			}else {
				right = mid;  // [left, right) => [left, mid) || [mid+1, right)
			}
		}
		if(left == 0) return -1;

		return nums[left - 1] == target? left - 1 : -1;
	}
	 public int[] searchRange(int[] A, int target) {  
	        int[] res = {-1,-1};  
	        if(A==null || A.length==0)  
	        {  
	            return res;  
	        }  
	        int ll = 0;  
	        int lr = A.length-1;  
	        while(ll<= lr)  
	        {  
	            int m = (ll+lr)/2;  
	            if(A[m]<target)  
	            {  
	                ll = m+1;  
	            }  
	            else  
	            {  
	                lr = m-1;  
	            }  
	        }  
	        int rl = 0;  
	        int rr = A.length-1;  
	        while(rl<= rr)  
	        {  
	            int m = (rl+rr)/2;  
	            if(A[m]<=target)  
	            {  
	                rl = m+1;  
	            }  
	            else  
	            {  
	                rr = m-1;  
	            }  
	        }  
	        if(ll<=rr)  
	        {  
	            res[0] = ll;  
	            res[1] = rr;  
	        }  
	        return res;  
	    }  
}
