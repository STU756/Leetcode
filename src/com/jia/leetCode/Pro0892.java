package com.jia.leetCode;
/**
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class Pro0892 {
    public int surfaceArea(int[][] grid) {
        int ans = 0 ;
        int n = grid.length;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                //先计算每一个位置grid[i][j]上堆叠起来的面积
                if( grid[i][j] > 0){      
                    ans += (grid[i][j] * 4 +2);
                }
                //再计算grid[i][j],与其上下左右面积(需要判断是否存在)重叠，减去
                if( i -1 >= 0 && grid[i-1][j] > 0){
                    ans -= (Math.min(grid[i-1][j] , grid[i][j]));
                }
                if( i + 1 < n && grid[i+1][j] > 0){
                    ans -= (Math.min(grid[i+1][j] , grid[i][j]));
                }
                if( j -1 >= 0 && grid[i][j-1] > 0){
                    ans -= (Math.min(grid[i][j-1] , grid[i][j]));
                }
                if( j + 1 < n && grid[i][j+1] > 0){
                    ans -= (Math.min(grid[i][j+1] , grid[i][j]));
                }
            }
        }
        return ans;
    }
}
