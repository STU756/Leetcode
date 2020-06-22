package com.jia.niukewang;

public class Pro02 {
    private int rows;
    private int cols;
    private  int cnt = 0;
    private int threshold;
    private int[][] digitSum;
    private final static int[][] next = {{0,1}, {0,-1}, {1,0},{-1,0}};
    public int movingCount(int threshold, int rows, int cols)
    {
        this.rows = rows;
        this.cols = cols;
        this.threshold = threshold;
        initDigitSum();
        boolean[][] marked = new boolean[rows][cols];
        dfs(marked, 0, 0);
        return cnt;
    }
    private void dfs(boolean[][] marked, int r, int c) {
        if(r < 0 || r >= rows || c < 0 || c >= cols || marked[r][c])
            return;
        if(digitSum[r][c] > threshold)
            return;
        marked[r][c] = true;
        ++cnt;
        for(int[]  n : next)
            dfs(marked, r + n[0], c + n[1]);
    }
    private void initDigitSum(){
        int[] digitSumOne = new int[Math.max(rows, cols)];
        for(int i = 0; i < digitSumOne.length; i++) {
            int n = i;
            while(n > 0) {
                digitSumOne[i] += n % 10;
                n /= 10;
            }
        }
        this.digitSum = new int[rows][cols];
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                this.digitSum[r][c] = digitSumOne[r] + digitSumOne[c];
            }
        }
    }
    public static void main(String[] args) {
		Pro02 pro02 = new Pro02();
		System.out.println(pro02.movingCount(15, 20, 20));;
	}
}
