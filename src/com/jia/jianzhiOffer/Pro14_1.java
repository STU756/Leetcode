package com.jia.jianzhiOffer;

public class Pro14_1 {
    //贪心算法
    public int cuttingRope2(int n) {
        if(n < 2) return 0;
        if(n == 2) return 1;
        if(n == 3) return 2;
        int timeOf3 = n / 3;
        if(n - 3 * timeOf3 == 1) {
            --timeOf3;
        }
        int timeOf2 = (n - 3*timeOf3) / 2;
        return (int)Math.pow(3, timeOf3) * (int)Math.pow(2,timeOf2);
    }
    //dp
    public int cuttingRope(int n) {
        if(n < 2) return 0;
        if(n == 2) return 1;
        if(n == 3) return 2;
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = i;
            for(int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j));
            }
        }
        return dp[n];
    }


}
