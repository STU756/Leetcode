package com.jia.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二维网格迁移 难度 简单
 * 
 * 8
 * 
 * 
 * 收藏
 * 
 * 分享 切换为英文 关注 通过次数
 * 
 * 2,286
 * 
 * 提交次数
 * 
 * 3,998
 * 
 * 题目描述 评论 (31) 题解(43) 提交记录 给你一个 n 行 m 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
 * 
 * 每次「迁移」操作将会引发下述活动：
 * 
 * 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。 位于 grid[i][m - 1] 的元素将会移动到 grid[i +
 * 1][0]。 位于 grid[n - 1][m - 1] 的元素将会移动到 grid[0][0]。 请你返回 k 次迁移操作后最终得到的 二维网格。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1 输出：[[9,1,2],[3,4,5],[6,7,8]] 示例 2：
 * 
 * 
 * 
 * 输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
 * 输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]] 示例 3：
 * 
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9 输出：[[1,2,3],[4,5,6],[7,8,9]]
 * 
 * 
 * 提示：
 * 
 * 1 <= grid.length <= 50 1 <= grid[i].length <= 50 -1000 <= grid[i][j] <= 1000
 * 0 <= k <= 100
 * 
 * @author Administrator
 *
 */
public class Pro1260 {
	public List<List<Integer>> shiftGrid(int[][] grid, int k) {
		// 准备返回的列表
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		for (int i = 0; i < grid.length; i++) {
			ret.add(new ArrayList<>());
		}
		k = k % (grid.length * grid[0].length);
		if(k == 0) {
			for(int i = 0; i<grid.length;i++) {
				for(int j = 0; j < grid[0].length; j++) {
					ret.get(i).add(grid[i][j]);
				}
			}
		}else {
			int rowNum = grid.length;
			int columnNum = grid[0].length;
			int qishi = rowNum * columnNum - k;
			int row = qishi / grid[0].length;
			int column = qishi % grid[0].length;
			for(int i = 0; i < grid.length; i++) {
				for(int j = 0; j < grid[0].length; j++) {
					ret.get(i).add(grid[row][column]);
					++column;
					if(column == columnNum) {
						column = 0;
						++row;
					}
					if(row == rowNum) {
						row = 0;
					}
				}
			}
		}
		return ret;
	}
}
