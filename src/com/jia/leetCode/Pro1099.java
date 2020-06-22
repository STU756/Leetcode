package com.jia.leetCode;

import java.util.Arrays;

public class Pro1099 {
    //two points
    public int twoSumLessThanK(int[] A, int K) {
        if(A.length == 1) return -1;
        Arrays.sort(A);
        int ans = A[0] + A[1];
        if( ans > K) return -1;
        int left = 0, right = A.length - 1;
        while(left < right) {
            if(A[left]+ A[right] >=K) right--;
            else {
                ans = K - Math.min(K - A[left] - A[right], K - ans);
                ++left;
            }
        }
        return ans;
    }
}
