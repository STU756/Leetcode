package com.jia.leetCode;
/**
 * 
 * @author Administrator
 *
 */
public class Pro1304 {
    public int[] sumZero(int n) {
    	int[] ans = new int[n];
    	for(int i = 0, j = 0; i < n / 2; i++) {
    		ans[j++] = (i+1);
    		ans[j++] = -(i+1);
    	}
    	return ans;
    }
}
