package com.jia.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * N皇后
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class Pro0051 {
	List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
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
			List<String> list = new ArrayList<String>();
			for(int i = 0; i < board.length; i++) {
				list.add(new String(board[i]));
			}
			ans.add(list);
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
