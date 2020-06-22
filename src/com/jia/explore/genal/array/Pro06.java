package com.jia.explore.genal.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Pro06 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.containsKey(nums1[i])? map.get(nums1[i]) + 1 : 1 );
        }
        int j = 0;
        for(int i = 0; i< nums2.length; i++) {
        	if(map.containsKey(nums2[i])) {
        		if(map.get(nums2[i]) > 1) {
        			map.put(nums2[i], map.get(nums2[i]) - 1);
        		}else {
        			map.remove(nums2[i]);
        		}
        		nums1[j++] = nums2[i];
        	}
        }
        return Arrays.copyOfRange(nums1, 0, j);
    }
    public static void main(String[] args) {
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		Pro06 pro06 = new Pro06();
		System.out.println(Arrays.toString(pro06.intersect(nums1, nums2)));
	}
}
