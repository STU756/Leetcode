package com.jia.leetCode;

import java.util.HashMap;
import java.util.Map;


public class Pro0122 {
	//���߶ε�������
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int result = 0;
        for(int i=1; i<prices.length; i++) {
        	if(prices[i-1] < prices[i])
        		result += (prices[i] - prices[i-1]);
        }
        return result;
    }
    public static void main(String[] args) {
		int[] prices = {1,2,3,4,2,5};
		Pro0122 p = new Pro0122();
		System.out.println(p.maxProfit(prices));
	}
}
