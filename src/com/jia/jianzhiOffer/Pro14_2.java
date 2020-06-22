package com.jia.jianzhiOffer;

public class Pro14_2 {
    public int cuttingRope(int n) {
    	if(n == 2)
    		return 1;
    	if(n == 3)
    		 return 2;
        long sum = 1;
        while(n > 4) {
        	sum *= 3;
        	sum = sum % 1000000007;
        	n -= 3;
        }
        return (int) (sum * n % 1000000007);
    }
}
