package com.jia.explore.genal.array;

public class Pro11 {
    public void rotate(int[][] matrix) {
       // 调换对角元素
    	for(int i = 0; i < matrix.length; i++) {
    		for(int j = 0; j < matrix[0].length - i; j++) {
    			int temp = matrix[i][j];
    			matrix[i][j] = matrix[matrix.length - j - 1][matrix.length - i - 1];
    			matrix[matrix.length - j - 1][matrix.length - i - 1] = temp;
    		}
    	}
    	print(matrix);
       //调换列的元素
    	for(int i = 0; i < matrix.length / 2; i++) {
    		for(int j = 0; j < matrix.length; j++) {
    			int temp = matrix[i][j];
    			matrix[i][j] = matrix[matrix.length - i - 1][j];
    			matrix[matrix.length - i - 1][j] = temp;
    		}
    	}
    	print(matrix);
   }
    private void print(int[][] matrix) {
    	for(int i = 0; i < matrix.length; i++) {
    		for(int j = 0; j < matrix[0].length; j++) {
    			System.out.print(matrix[i][j] + " ");
    		}
    		System.out.println();
    	}
    }
    public static void main(String[] args) {
    	int[][] matrix  = {
    			{1,2,3},
    			{4,5,6},
    			{7,8,9}
    	};
		Pro11 pro11 = new Pro11();
		pro11.rotate(matrix);
	}
}
