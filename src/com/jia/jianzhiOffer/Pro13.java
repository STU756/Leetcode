package com.jia.jianzhiOffer;

public class Pro13 {
    int[] dx = {0,0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    private int m;
    private int n;
    boolean[][] visited;
    int ans;
    public int movingCount(int m, int n, int k) {
        if(m < 0 && m > 100 || n < 0 || n > 100) return 0;
        this.m = m;
        this.n = n;
        this.visited = new boolean[m][n];
        dfs(0, 0, k);
        return ans;
    }
    private void dfs(int r, int c, int k) {
        if(r>=0 && r < m && c >=0 && c < n && !visited[r][c] && (countDigits(r) + countDigits(c) <= k)) {
            ++ans;
            visited[r][c] = true;
            for(int i = 0; i < 4; i++) {
                dfs(r + dx[i], c + dy[i], k);
            }
        }
    }
    private int countDigits(int val) {
        int ret = 0;
        while(val != 0) {
            ret += (val % 10);
            val /= 10;
        }
        return ret;
    }
}
