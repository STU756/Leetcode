package com.jia.leetCode.pac;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Intersection{
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i =0; i< nums1.length; i++) {
            set.add(nums1[i]);
        }
        int len = 0;
        for(int i =0; i< nums2.length; i++) {
           if(set.contains(nums2[i])){
        	   nums1[len++] = nums2[i];
        	   set.remove(nums2[i]);
           }
        }
        int[] result = new int[len];
        System.arraycopy(nums1, 0, result, 0, len);
        return result;
    }
    public static void main(String[] args) {
		Intersection intersection = new Intersection();
		System.out.println(Arrays.toString(intersection.intersection(new int[] {1,2,2,1},new int[] {2,2})));
	}
}
