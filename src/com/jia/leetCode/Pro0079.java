package com.jia.leetCode;
import java.beans.Visibility;
import java.util.Arrays;
/**
 * 79. 单词搜索
 * 
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

示例:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true.
给定 word = "SEE", 返回 true.
给定 word = "ABCB", 返回 false.

 * 
 * 
 */

public class Pro0079 {
	private int n;
	private int m;
	private  boolean[][] used;
	public boolean exist(char[][] board, String word) {
		if(word == null || word.length() == 0) return true;
		if(board == null || board.length == 0 || board[0].length == 0) return false;
		m = board.length;
		n = board[0].length;
		used = new boolean[m][n];
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[0].length; y++)
				if(board[x][y]==word.charAt(0)) {
					//cleanUsed(used);
					used[x][y] = true;
					if(help(board, word, x, y, 1)) {
						return true;
					}
				}
		}
		return false;
	}
	private void cleanUsed(boolean[][] used) {
		for(int i = 0; i < used.length; ++i) {
			for(int j = 0;j < used[0].length; j++) {
				if(used[i][j]) {
					used[i][j] = false;
				}
			}
		}
	}
	
	private static final int[] wx = {0,0,-1,1};
	private static final int[] wy = {1,-1,0,0};
	private boolean help(char [][] board, String word, int x, int y, int step) {
		if(step == word.length()) return true;
		for(int i = 0; i < 4; i++) {
			int xx = x + wx[i];
			int yy = y + wy[i];
            used[x][y] = true;
			if(xx >=0 && xx < m && yy>=0 && yy <n&& board[xx][yy] == word.charAt(step)&&!used[xx][yy]) {
				used[xx][yy] = true;
				if(help(board, word, xx, yy, step+1)) {
					return true;
				}
                used[xx][yy] = false;
			}
		}
        used[x][y] = false;
		return false;
	}
	
	public static void main(String[] args) {
		Pro0079 pro0079 = new Pro0079();
		String word = "aaa";
		char[][] board = {{'a','a'}};
		System.out.println(pro0079.exist(board, word)
				);;
	}
}
