package com.jia.leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 279.完全平方数
 *给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 */
public class Pro0279 {
    /**
     * 动态规划
     *  dp[n]表示完全平方数（1,4,9,16....）的和最小个数
     *  那么dp[n] = 1 + min{dp[n - 1^2], dp[n-2^2],....}
     *
     * @param n
     * @return
     */
    public int numSquares2(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 1; i <= n; i++) {
            int min = n + 1;
            for(int j = 1; i - j*j >=0; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    class Node{
        int n;
        int step;
        public Node(int n, int step) {
            this.n = n;
            this.step = step;
        }
    }

    //bfs
    //bfs
    public int numSquares(int n) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        queue.offer(new Node(n, 0));
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int val = node.n;
            int step = node.step;
            visited[val] = true;
            if(val == 0) {
                return step;
            }
            for(int i =1; i * i <= val; i++) {
                int nextVal = val - i * i;
                if(!visited[nextVal]) {
                    queue.offer(new Node(nextVal, step + 1));
                }
            }
        }
        return -1;
    }
}
