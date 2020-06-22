package com.jia.leetCode;

import java.util.HashMap;
import java.util.Map;


public class Pro0026 {
    public int removeDuplicates(int[] nums) {
    	int count = 0;
        for(int i=0;i<nums.length; i++) {
            if(i>0&&nums[i] == nums[i-1]) continue;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
		int[] nums = {1,1,2};
		Pro0026 p = new Pro0026();
		System.out.println(p.removeDuplicates(nums));
	}
}
