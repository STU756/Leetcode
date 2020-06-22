package com.jia.leetCode.pac;

public class Test02 {
    public int partitionDisjoint(int[] A) {
    	int leftMax = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++ ) {
        	leftMax = Math.max(A[i], leftMax);
        	int j = i + 1;
        	for(; j <A.length;j++) {
        		if(A[j] < leftMax)
        			break;
        	}
        	if(j == A.length)
        		return i+1;
        }
        throw new RuntimeException("input error.");
    }
    public static void main(String[] args) {
		//int[] A = {5,0,3,8,6};
		int[] A = {1,1,1,0,6,12};
		Test02 test02 = new Test02();
		System.out.println(test02.partitionDisjoint(A));
	}
}
