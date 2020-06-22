package com.jia.leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *542. 01 矩阵
 *
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 * 示例 1:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 示例 2:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * 注意:
 *
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 *
 *
 */
public class Pro0542 {
    class Node{
        int r;
        int c;
        int val;
        public Node(int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }
    }
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    public int[][] updateMatrix(int[][] matrix) {
        Queue<Node> queue = new LinkedList<Node>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(matrix[i][j] == 0) {
                    queue.offer(new Node(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                Node node = queue.poll();

                for(int i = 0; i < 4; i++) {
                    int r = node.r + dx[i];
                    int c = node.c + dy[i];
                    int val = node.val;
                    if(r >= 0 && r < rows && c >=0 && c < cols && !visited[r][c]) {
                        visited[r][c] = true;
                        matrix[r][c] = val + 1;
                        queue.offer(new Node(r, c, val + 1));
                    }
                }
                --size;
            }
        }
        return matrix;
    }
}
