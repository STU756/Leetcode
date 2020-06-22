package com.jia.explore.bracktrace;
/**
 * 剑指Offer 面试题12
 */


public class Pro13 {
	public int countMoving(int threshold, int rows, int cols) {
		if(threshold < 0 || rows <= 0 || cols <= 0)
			return 0;
		boolean[][] visited = new boolean[rows][cols];
		return countMovingCore(threshold, rows, cols, 0, 0, visited);
	}

	private int countMovingCore(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
		int count = 0;
		if(check(threshold, rows, cols, row, col, visited)) {
			visited[row][col] = true;
			count = 1 + countMovingCore(threshold, rows, cols, row-1, col, visited)
				+ countMovingCore(threshold, rows, cols, row, col - 1, visited)
				+ countMovingCore(threshold, rows, cols, row + 1, col, visited)
				+ countMovingCore(threshold, rows, cols, row, col + 1, visited);
		}
		return count;
	}

	private boolean check(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
		if(row >=0 && row < rows && col >=0 && col < cols && !visited[row][col] && getDigitSum(row) + getDigitSum(col) <= threshold)
			return true;
		return false;
	}

	private int getDigitSum(int col) {
		int digitSum = 0;
		while(col > 0) {
			digitSum+= (col % 10);
			col /= 10;
		}
		return digitSum;
	}
	public static void main(String[] args) {
		Pro13 pro13 = new Pro13();
		System.out.println(pro13.countMoving(18, 400, 400));;
	}
}
