package com.jia.explore.genal.array;

import java.util.HashSet;
import java.util.Set;

public class Pro04 {
    public boolean containsDuplicate(int[] nums) {
    	if(nums == null || nums.length <2)return false;
    	Set<Integer> set = new HashSet<Integer>();
        for(int i =0; i<nums.length; i++) {
        	if(set.contains(nums[i])) return true;
        	else 
        		set.add(nums[i]);
        }
        return false;
    }
}
