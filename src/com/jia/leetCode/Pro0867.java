package com.jia.leetCode;
/**
 * 867.转置矩阵
 * 给定一个矩阵 A， 返回 A 的转置矩阵。

	矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
	
	 
	
	示例 1：
	
	输入：[[1,2,3],[4,5,6],[7,8,9]]
	输出：[[1,4,7],[2,5,8],[3,6,9]]
	示例 2：
	
	输入：[[1,2,3],[4,5,6]]
	输出：[[1,4],[2,5],[3,6]]
	 
	
	提示：
	
	1 <= A.length <= 1000
1 <= A[0].length <= 1000

 * 
 * @author Administrator
 *
 */
public class Pro0867 {
    public int[][] transpose(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        int[][] ans= new int[M][N];
        for(int row = 0; row < N; row++) {
            for(int col = 0; col < M; col++) {
                ans[col][row] = A[row][col];
            }
        }
        return ans;
    }
}
