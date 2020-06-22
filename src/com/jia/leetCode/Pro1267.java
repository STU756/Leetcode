package com.jia.leetCode;

public class Pro1267 {
    public int countServers(int[][] grid) {
        int sum = 0;
        for(int i =0; i< grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    int k = 0;
                    for(; k<grid.length; k++) {
                        if(k!=i && grid[k][j] == 1) {
                            ++sum;
                            break;
                        }     
                    }
                    if(k<grid.length) continue;
                    for(k = 0; k < grid[0].length; k++) {
                        if(k!=j && grid[i][k] == 1) {
                            ++sum;
                            break;
                        }
                    }
                }
            }
        }
        return sum;
    }
}
