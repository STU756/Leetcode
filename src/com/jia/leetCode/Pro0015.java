package com.jia.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pro0015 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i =0; i <nums.length-2; i++) {
        	if(i>0 && nums[i] == nums[i-1]) continue;
        	int low = i + 1, hight = nums.length-1, sum = 0 - nums[i];
        	while(low < hight) {
        		if(nums[low] + nums[hight] == sum) {
        			res.add(Arrays.asList(nums[i], nums[low], nums[hight]));
        			while(low<hight && nums[low] == nums[low+1]) ++low;
        			while(low < hight && nums[hight] == nums[hight-1]) --hight;
        			++low;
        			--hight;
        		}else if(nums[low] + nums[hight] > sum) {
        			--hight;
        		}else {
        			++low;
        		}
        	}
        }
        return res;
    }
    public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		Pro0015 pro0015 = new Pro0015();
		pro0015.threeSum(nums);
	}
}
