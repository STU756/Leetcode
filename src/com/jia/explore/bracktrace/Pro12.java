package com.jia.explore.bracktrace;
/**
 * 
 * 剑指Offer 面试题12
 * 
 * @author Administrator
 *
 */
public class Pro12 {
	boolean hasPath(char[][] matrix, String str) {
		if(matrix == null || matrix.length < 1 || matrix[0].length < 1)
			return false;
		int rows = matrix.length;
		int cols = matrix[0].length;
		int pathLength = 0;
		boolean[][] visited = new boolean[rows][cols];
		for(int row =0; row < rows; ++row) {
			for(int col = 0; col < cols; ++col) {
				if(hasPathCore(matrix, rows, cols, row, col, str, pathLength, visited)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean hasPathCore(char[][] matrix, int rows, int cols, int row, int col, String str, int pathLength,
			boolean[][] visited) {
		if(pathLength >= str.length()) return true;
		boolean hasPath = false;
		if(row>=0 && row < rows && col >=0 && col < cols && matrix[row][col] == str.charAt(pathLength)
				&& !visited[row][col]) {
			++pathLength;
			visited[row][col] = true;
			hasPath = hasPathCore(matrix, rows, cols, row, col -1, str, pathLength, visited)
					|| hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength, visited)
					|| hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength, visited)
					|| hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength, visited);
			if(!hasPath) {
				--pathLength;
				visited[row][col] = false;
			}
		}
		return hasPath;
	}
	public static void main(String[] args) {
		Pro12 pro12 = new Pro12();
		char[][] matrix = {{'a', 'b', 't', 'g'},
						   {'c', 'f', 'c', 's'},
						   {'j', 'd', 'e', 'h'}};
		System.out.println(pro12.hasPath(matrix, "abfce"));
	}
}
