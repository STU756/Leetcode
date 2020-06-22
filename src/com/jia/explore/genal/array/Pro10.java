package com.jia.explore.genal.array;

public class Pro10 {
	  public boolean isValidSudoku(char[][] board) {
	       for(int i = 0; i < 9; i++) {
	    	   for(int j = 0; j < 9; j++) {
	    		   //跳过'.'
	    		   if(board[i][j] == '.') continue;
	    		   //判断横和列
	    		   for(int k = 0; k < 9; k++) {
	    			   if(k != i && board[k][j]!='.' && board[k][j] ==board[i][j]) { 
	    				   System.out.println(k + " aaaa" + j);
	    				    return false;
	    			   }
	    		   }
	               for(int k = 0; k < 9; k++) {
	                   if(k!=j &&board[i][k]!='.' &&board[i][k] == board[i][j]) {
	                	   System.out.println(k + "bbbb " + i);
	                	   return false;
	                   }
	               }
	    		   //判断3*3宫内
	    		   for(int k = i/3 * 3; k < (i/3 + 1) * 3; k++) {
	    			   for(int m = j/3 *3; m < (j/3+1) * 3; m++) {
	    				   if(k != i && m != j &&board[k][m]!='.'&& board[k][m] ==board[i][j]) {
	    					   System.out.println(k + " ccc" + m + board[i][j] + i + j);
	    					   return false;
	    				   }
	    			   }
	    		   }
	    	   }
	       }
	       return true;
	    }
    public static void main(String[] args) {
		char[][] board = {{'5','3','.','.','7','.','.','.','.'},
			{'6','.','.','1','9','5','.','.','.'},
			{'.','9','8','.','.','.','.','6','.'},
			{'8','.','.','.','6','.','.','.','3'},
			{'4','.','.','8','.','3','.','.','1'},
			{'7','.','.','.','2','.','.','.','6'},
			{'.','6','.','.','.','.','2','8','.'},
			{'.','.','.','4','1','9','.','.','5'},
			{'.','.','.','.','8','.','.','7','9'}
				};
		Pro10 pro10 = new Pro10();
		System.out.println(pro10.isValidSudoku(board));
    }
}
