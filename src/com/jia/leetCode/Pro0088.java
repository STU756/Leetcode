package com.jia.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Pro0088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	int i = m -1, j = n-1, k = m + n -1;
    	while(i>-1 && j>-1) nums1[k--] = (nums1[i] > nums2[j])?nums1[i--]:nums2[j--];
    	while(j>-1) nums1[k--] = nums2[j--];
    }

}
