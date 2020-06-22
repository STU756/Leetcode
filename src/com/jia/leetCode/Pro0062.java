package com.jia.leetCode;

/**
 * 62.不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？



例如，上图是一个7 x 3 的网格。有多少可能的路径？

 

示例 1:

输入: m = 3, n = 2
输出: 3
解释:
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右
示例 2:

输入: m = 7, n = 3
输出: 28
 

提示：

1 <= m, n <= 100
题目数据保证答案小于等于 2 * 10 ^ 9

 * 
 * @author Administrator
 *
 */
public class Pro0062 {
    public int uniquePaths1(int m, int n) {
    	int[][] dp = new int[m][n];
    	for(int i = 0; i < n; i++) { dp[0][i] = 1; }
    	for(int i = 0; i < m; i++) { dp[i][0] = 1; }
    	for(int i = 1; i <m; i++) {
    		for(int j = 1; j < n; j++) {
    			dp[i][j] = dp[i-1][j] + dp[i][j-1];
    		}
    	}
    	return dp[m-1][n-1];
    }

	/**
	 * 状态压缩
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePaths2(int m, int n) {
    	int[] dp = new int[n];
    	dp[0] = 1;
    	for(int i = 0; i < m; i++) {
    		for(int j = 1; j < n; j++) {
    			//有障碍物
    			//if(grid[i][j] == 1) {
    			//	dp[j-1] = 0;
    			//}else if(j>0)
    			dp[j] += dp[j-1];
    		}
    	}
    	return dp[n-1];
    }



	/**
	 * 排列组合：  对于3×2网络，机器人开始处于（0,0）位置，需要向右走两步和向下走一步，总共需要走3步，那么通过排列组合方式计算C(3 - 1, 3 + 2 - 2)
	 或C(2-1, 3 + 2 - 2) 为C(2, 3)
	 那么可以推到出来（m, n）,总共需要走m + n - 2步到Finish,向右走n - 1步（或向下走m - 1步）， C(n - 1, m + n - 2)

	 **/
	public int uniquePaths3(int m, int n) {
		if(m < 0 || n < 0) { return 0; }
		return (int)combination(m + n - 2, m - 1);
	}
	/**
	 * 计算阶乘： n!= 1 * 2 * 3 * ... * n
	 **/
	private long factorial(int m) {
		long sum = 1;
		while(m > 1) {
			sum *= m--;
		}
		return sum;
	}
	/**
	 * 计算排列， 即A(n, m) = n! / (n - m)!
	 **/
	private long arragement(int n, int m) {
		return (n >= m)? factorial(n) / factorial(n - m) : 0;
	}
	/**
	 * 计算组合，即C(n, m) = n! / ((n -m)! * m!)
	 **/
	private long combination(int n, int m) {
		return (n >= m)? factorial(n) / factorial(n - m) / factorial(m) : 0;
	}

	/**
	 * 递归解决
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePaths22(int m, int n) {
		if(m <= 0 || n <=0) { return 0;}
		else if(m == 1 || n == 1) { //只能一直想右走或者一直向下走，只有一条路径
			return 1;
		}
		return uniquePaths(m -1, n ) + uniquePaths(m, n - 1);
	}

	/**
	 * 递归+打表（最优子结构状态记录）
	 * @param m
	 * @param n
	 * @return
	 */
	private static int[][] paths = new int[101][101];
	public int uniquePaths(int m, int n) {
		if(m <= 0 || n <=0) { return 0;}
		else if(m == 1 || n == 1) { //只能一直想右走或者一直向下走，只有一条路径
			return 1;
		}
		if(paths[m][n] != 0) {
			return paths[m][n];
		}
		paths[m-1][n] = uniquePaths(m - 1, n);
		paths[m][n-1] = uniquePaths(m, n - 1);
		paths[m][n] = paths[m - 1][n] + paths[m][n - 1];
		return paths[m][n];
	}


	public static void main(String[] args) {
		Pro0062 pro0062 = new Pro0062();
		System.out.println(pro0062.uniquePaths2(51, 9));;//1916797311
	}
}
