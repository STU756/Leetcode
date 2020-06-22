package com.jia.leetCode.pac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Intersect2 {
    public int[] intersect(int[] nums1, int[] nums2) {
    	int[] tempArr = null;
    	if(nums1.length>nums2.length) {
    		tempArr = nums1;
    		nums1 = nums2;
    		nums2 = tempArr;
    	}
        HashMap<Integer,Integer> map1 = new HashMap<Integer, Integer>();
        HashMap<Integer,Integer> map2 = new HashMap<Integer, Integer>();
        for(int i =0 ; i< nums1.length; i++) {
        	map1.put(nums1[i], map1.containsKey(nums1[i])? map1.get(nums1[i])+1:1);
        }
        for(int i = 0; i< nums2.length; i++) {
        	map2.put(nums2[i], map2.containsKey(nums2[i])? map2.get(nums2[i])+1:1);
        }
        List<Integer> returnList = new ArrayList<Integer>();
        for(Entry<Integer,Integer> entry : map1.entrySet()) {
        	if(map2.containsKey(entry.getKey())&&map2.get(entry.getKey()).equals(entry.getValue())) {
        		int count = entry.getValue();
        		while(count > 0) {
        			returnList.add(entry.getKey());
        			--count;
        		}
        		map2.remove(entry.getKey());
        	}
        }
        return returnList.stream().mapToInt(Integer::valueOf).toArray();
    }
    
    public static void main(String[] args) {
		Intersect2 intersect2 = new Intersect2();
//		System.out.println(Arrays.toString(intersect2.intersect(new int[] {1,2,2,1}, new int[] {2,2})));
		System.out.println(Arrays.toString(intersect2.intersect(new int[] {4,9,5}, new int[] {9,4,9,8,4})));
	}
}
