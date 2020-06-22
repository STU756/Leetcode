package com.jia.jianzhiOffer;
/**
 * 面试题66：构建乘积数组
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class Pro66 {
    public int[] multiply(int[] A) {
    	if(A == null || A.length <2)
    		return null;
    	int[] B = new int[A.length];
    	//
    	for(int i = 0, product = 1; i < A.length; product*=A[i],i++) {
    		//左往右累乘
    		B[i] = product;
    	}
    	for(int i = A.length - 1, product = 1; i >= 0; product *=A[i], i--) {
    		//右往左累乘
    		B[i] *=product;
    	}
    	return B;
    }
}
