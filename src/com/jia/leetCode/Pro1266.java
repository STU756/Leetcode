package com.jia.leetCode;

public class Pro1266 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int prex = points[0][0], prey = points[0][1];
        int result = 0;
        for(int i = 1; i < points.length; i++) {
            result += Math.max(Math.abs(points[i][0] - prex), Math.abs(points[i][1] - prey));
            prex = points[i][0];
            prey = points[i][1];
        }
        return result;
    }
}
