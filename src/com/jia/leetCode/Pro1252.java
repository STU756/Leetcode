package com.jia.leetCode;
/**
 * 
 * 奇数值单元格的数目
难度
简单

8


收藏

分享
切换为英文
关注
通过次数

3,502

提交次数

4,732

题目描述
评论 (39)
题解(38)
提交记录
给你一个 n 行 m 列的矩阵，最开始的时候，每个单元格中的值都是 0。

另有一个索引数组 indices，indices[i] = [ri, ci] 中的 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。

你需要将每对 [ri, ci] 指定的行和列上的所有单元格的值加 1。

请你在执行完所有 indices 指定的增量操作后，返回矩阵中 「奇数值单元格」 的数目。

 

示例 1：



输入：n = 2, m = 3, indices = [[0,1],[1,1]]
输出：6
解释：最开始的矩阵是 [[0,0,0],[0,0,0]]。
第一次增量操作后得到 [[1,2,1],[0,1,0]]。
最后的矩阵是 [[1,3,1],[1,3,1]]，里面有 6 个奇数。
示例 2：



输入：n = 2, m = 2, indices = [[1,1],[0,0]]
输出：0
解释：最后的矩阵是 [[2,2],[2,2]]，里面没有奇数。
 

提示：

1 <= n <= 50
1 <= m <= 50
1 <= indices.length <= 100
0 <= indices[i][0] < n
0 <= indices[i][1] < m
 * 
 * 
 * @author Administrator
 *
 */
public class Pro1252 {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] matrix = new int[n][m];
        for(int i =0 ; i <indices.length; i++) {
        	//colomn
        	for(int j = 0; j < matrix.length; j++) {
        		++matrix[j][indices[i][1]];
        	}
        	//row
        	for(int j = 0; j<matrix[0].length; j++) {
        		++matrix[indices[i][0]][j];
        	}
        }
        int result = 0;
        for(int i =0; i < matrix.length; i++) {
        	for(int j = 0;j <matrix[0].length; j++) {
        		if(matrix[i][j] % 2 == 1)
        			++result;
        	}
        }
        return result;
    }
    public static void main(String[] args) {
		int n = 2, m = 3;
		int[][] indices = {{0,1},{1,1}};
		Pro1252 pro1252 = new Pro1252();
		pro1252.oddCells(n, m, indices);
	}
}
