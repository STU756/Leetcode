package com.jia.explore.genal.array;

import java.util.HashSet;
import java.util.Set;

public class Pro01 {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i])) {
            	nums[j++] = nums[i]; 
            	set.add(nums[i]);
            }
        }
        return set.size();
    }
}
