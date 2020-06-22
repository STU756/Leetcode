package com.jia.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Pro0200 {
	 public int numIslands(char[][] grid) {
	        int answer = 0;
	        for(int i=0; i<grid.length; i++) {
	            for(int j=0; j<grid[i].length; j++) {
	                if(grid[i][j]=='1') {
	                    help(grid, i, j);
	                    answer ++;
	                }
	            }
	        }
	        return answer;
	    }
	    //DFS
/*	    public void help(char[][] grid, int x, int y) {
	        if((x < 0) || (x>=grid.length)||(y < 0) || (y >= grid[x].length) || (grid[x][y] !='1'))
	            return ;
	        grid[x][y] = '0';
	        help(grid, x-1, y);
	        help(grid, x, y-1);
	        help(grid, x+1, y);
	        help(grid, x, y+1);
	    }*/
	 //BFS
	 public void help(char[][] a, int x, int y) {
		 LinkedList<Point> q = new LinkedList<Point>();
		 int[] dx = {-1, 1, 0, 0};
		 int[] dy = {0, 0, -1, 1};
		 a[x][y] = '0';
		 for(q.push(new Point(x, y)); !q.isEmpty();) {
			 Point p = q.poll();
			 x = p.x;
			 y = p.y;
			 for(int i=0; i<4; i++) {
				 int nx = x + dx[i];
				 int ny = y + dy[i];
				 if((nx>=0) && (nx<a.length) && (ny >=0) && (ny<a[nx].length)&&(a[nx][ny]=='1')) {
					 a[nx][ny] = '0';
					 q.push(new Point(nx,ny));
				 }
			 }
		 }
	 }
	 class Point {
		 int x;int y;
		 public Point(int x, int y) {
			 this.x = x;
			 this.y  = y;
		 }
	 }
}
