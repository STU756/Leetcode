package com.jia.leetCode.pac;

import java.util.HashSet;

public class HappyNumber {
    public boolean isHappy(int n) {
    	HashSet<Integer> set = new HashSet<Integer>();
    	int sum= 0;
    	while(n!=1) {
    		sum = 0;
    		while(n>0) {
    			sum = sum + (n%10) *(n%10);
    			n /= 10;
    		}
    		if(set.contains(sum)) return false;
    		else {
    			n  = sum;
    			set.add(n);
    		}
    	}
    	return true;
    }
    public static void main(String[] args) {
		HappyNumber happyNumber = new HappyNumber();
		System.out.println(happyNumber.isHappy(2));
	}
}
