package com.jia.jianzhiOffer;
/**
 * 面试题15：二进制中1的个数
 * @author Administrator
 *
 */
public class Pro15 {
    public int hammingWeight(int n) {
    	int cnt = 0;
        while(n!=0) {
        	++cnt;
        	n &=(n-1);
        }
        return cnt;
    }
}
