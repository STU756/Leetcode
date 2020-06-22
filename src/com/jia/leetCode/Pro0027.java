package com.jia.leetCode;

public class Pro0027 {
	public int removeElement(int[] A, int elem) {
		int l = A.length;
        for(int i=0; i<l; i++) {
        	if(A[i] == elem) {
        		A[i--] = A[l-- -1];
        	}
        }
        return l;
    }
}
