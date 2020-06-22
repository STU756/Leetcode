package com.jia.leetCode;
/**
 * 37. 解数独
 * 编写一个程序，通过已填充的空格来解决数独问题。

一个数独的解法需遵循如下规则：

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
空白格用 '.' 表示。



一个数独。



答案被标成红色。

Note:

给定的数独序列只包含数字 1-9 和字符 '.' 。
你可以假设给定的数独只有唯一解。
给定数独永远是 9x9 形式的。

 * 
 * @author Administrator
 *
 */
public class Pro0037 {
	/**
	 * 解决9*9数独
	 * 记忆化搜索
	 * 1、初始化记录行、列、宫格每个数字是否出现
	 * 2、搜索过程
	 * 		终止条件：
	 * 		
	 * 		对'.'字符进行1~9进行记忆化dfs搜索
	 * 		选择1~9某个数字，打表
	 * 		dfs进行下一层搜索
	 * 		撤销回溯
	 * 
	 * 
	 * @param board
	 */
    public void solveSudoku(char[][] board) {
    	//记录行各个数字是否存在
    	boolean[][] row = new boolean[9][9];
    	//记录列各个数字是否存在
    	boolean[][] col = new boolean[9][9];
    	//记录宫格各个数字是否存在
    	boolean[][] block = new boolean[9][9];
    	//初始化
    	for(int r = 0; r < 9; r++) {
    		for(int c = 0; c < 9; c++) {
    			if(board[r][c]!='.') {
	    			int num = board[r][c] - '1';
	    			row[r][num] = true;
	    			col[c][num] = true;
	    			block[r / 3 * 3 + c / 3][num] = true;
    			}
    		}
    	}
    	dfs(board, row, col, block, 0, 0);
    }
    private boolean dfs(char[][] board, boolean[][] row, boolean[][] col, boolean[][] block, int r, int c) {
		//终止条件
    	while(board[r][c] != '.') {
    		//一行行找到没有填写数字的方格
    		if(++c>=9) {
    			c = 0;
    			++r;
    		}
    		if(r >= 9) {
    			//终止条件，填写完毕
    			return true;
    		}
    	}
    	int blockIndex = r / 3 * 3 + c / 3;
    	for(int num = 0; num < 9; num++) {
    		if(!row[r][num] && !col[c][num] && !block[blockIndex][num]) {
    			//选择
    			board[r][c] = (char)(num + '1');
    			row[r][num] = true;
    			col[c][num] = true;
    			block[blockIndex][num] = true;
    			//进行下一层
    			if(dfs(board, row, col, block, r, c)) {
    				return true;
    			}else {
    				//撤销回溯
    				board[r][c] = '.';
        			row[r][num] = false;
        			col[c][num] = false;
        			block[blockIndex][num] = false;
    			}
    			
    		}
    	}
    	return false;
	}
	private void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
    	char[][] board = new char[][]{
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    		};
    	Pro0037 pro0037 = new Pro0037();
    	pro0037.solveSudoku(board);
    	pro0037.printBoard(board);
	}
}
