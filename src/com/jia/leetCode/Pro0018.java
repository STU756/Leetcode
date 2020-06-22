package com.jia.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pro0018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i =0; i <nums.length-3; i++) {
        	if(i>0 && nums[i] == nums[i-1]) continue;
        	for(int j = i+1; j < nums.length -2; j++ ) {
        		if(j>i+1 && nums[j] == nums[j-1]) continue;
        		int low = j + 1, hight = nums.length-1, sum = target - nums[i] - nums[j];
        		while(low < hight) {
        			if(nums[low] + nums[hight] == sum) {
        				res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[hight]));
        				while(low<hight && nums[low] == nums[low+1]) ++low;  //去重
            			while(low < hight && nums[hight] == nums[hight-1]) --hight;//去重
        				++low;
        				--hight;
        			}else if(nums[low] + nums[hight] > sum) {
        				--hight;
        			}else {
        				++low;
        			}
        		}
        	}
        }
        return res;
    }
    public static void main(String[] args) {
		Pro0018 pro0018 = new Pro0018();
//		int[] nums = {1, 0, -1, 0, -2, 2};
//		int[] nums = {-3,-2,-1,0,0,1,2,3};
//		int[] nums = {0, 0, 0, 0};
		int[] nums = {-1,0,-5,-2,-2,-4,0,1,-2};
		int target = -9;
		System.out.println(pro0018.fourSum(nums, target));
	}
}
