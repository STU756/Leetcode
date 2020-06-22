package com.jia.leetCode;

import java.util.HashMap;
import java.util.Map;


public class Pro0121 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length ==0) return 0;
        int ans = 0;
        int maxPrice = prices[prices.length-1];
        for(int i = prices.length - 1; i >= 0; i--)
        {
            maxPrice = Math.max(maxPrice, prices[i]);
            ans = Math.max(ans, maxPrice - prices[i]);
        }
        
        return ans;
    }
    public static void main(String[] args) {
		int[] prices = {2,1};
		Pro0121 p = new Pro0121();
		System.out.println(p.maxProfit(prices));
	}
}
