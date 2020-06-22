package com.jia.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 212.单词搜索II
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class Pro0212 {
	/**
	 * 字典树
	 * @author Administrator
	 *
	 */
	class TreeNode{
		boolean isWord;
		TreeNode[] child;
		public TreeNode() {
			isWord = false;
			child = new TreeNode[26];
		}
	}
	private int n;
	private int m;
	private  boolean[][] used;
	public boolean exist(char[][] board, String word) {
		if(word == null || word.length() == 0) return true;
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
	/**
	 * 字符串插入字典树
	 * @param root
	 * @param word
	 */
	private void insert(TreeNode root, String word) {
		
	}
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
		if(board == null || board.length == 0 || board[0].length == 0) return ans;
		m = board.length;
		n = board[0].length;
		used = new boolean[m][n];
		//字典树
		TreeNode root = new TreeNode();
		//把所有的字符串构建字典树
		for(String word : words) {
			insert(root, word);
		}
        for(String word : words) {
        	cleanUsed(used);
        	if(exist(board, word)) {
        		ans.add(word);
        		
        	}
        }
        return ans;
    }
}
