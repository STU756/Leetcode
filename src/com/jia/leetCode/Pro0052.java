package com.jia.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N皇后 II
 * 
 * 
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。



上图为 8 皇后问题的一种解法。

给定一个整数 n，返回 n 皇后不同的解决方案的数量。

示例:

输入: 4
输出: 2
解释: 4 皇后问题存在如下两个不同的解法。
[
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
在真实的面

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-queens-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Administrator
 *
 */
public class Pro0052 {
    private  int ans = 0;
    public int totalNQueens(int n) {
    	char[][] board = new char[n][n];
    	for(int i = 0; i < board.length; i++) {
    		Arrays.fill(board[i], '.');
    	}
    	backtrack(board, 0);
        return ans;
    }
    /**
     * 
     * @param board  n*n棋盘
     * @param row   第几行
     */
	private void backtrack(char[][] board, int row) {
		//触发结束条件
		if(row == board.length) {
			++ans;
		}
		
		for(int col = 0; col < board.length; col++) {
			//排除不合理条件
			if(!isValid(board, row, col))
				continue;
			//做出选择
			board[row][col] = 'Q';
			//进入下一行决策
			backtrack(board, row+1);
			//撤销选择
			board[row][col] = '.';
		}
	}
	//检查是否有皇后冲突
	private boolean isValid(char[][] board, int row, int col) {
		//检查列是否有皇后冲突
		for(int i = 0; i < board.length; i++) {
			if(board[i][col] == 'Q')
				return false;
		}
		//检查右上斜是否有皇后冲突
		for(int i = row -1, j = col + 1; i>=0 && j< board.length; i--, j++) {
			if(board[i][j] == 'Q')
				return false;
		}
		//检查左上斜是否有皇后互相冲突
		for(int i =row - 1, j = col - 1; i >=0 && j>=0; i--, j--) {
			if(board[i][j] == 'Q')
				return false;
		}
		return true;
	}
}
