package com.jia.leetCode;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * 
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

示例 1:

输入: coins = [1, 2, 5], amount = 11
输出: 3 
解释: 11 = 5 + 5 + 1
示例 2:

输入: coins = [2], amount = 3
输出: -1
说明:
你可以认为每种硬币的数量是无限的。

 * @author Administrator
 *
 */
public class Pro0332 {
    /*
    *1.重复子问题：   p[amount] = p[amount - coins[i]] (coins[i] = 1,2,5....)
    *2.状态数组： dp[1..amount] 下标表示金额，数值表示可以凑成所需的最少硬币数
    *3.dp方程 ： dp[i] = min({dp[i - coins[j]] + 1}) (j = 0..coins.length, 且i - coins[j] > 0)
    */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(i >= coins[j]) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        return dp[amount] > amount? -1 : dp[amount];
    }
}
