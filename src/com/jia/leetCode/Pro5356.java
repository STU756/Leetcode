package com.jia.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 5356.矩阵中的幸运数
 * 
 * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。

幸运数是指矩阵中满足同时下列两个条件的元素：

在同一行的所有元素中最小
在同一列的所有元素中最大
 

示例 1：

输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
输出：[15]
解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
示例 2：

输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
输出：[12]
解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
示例 3：

输入：matrix = [[7,8],[1,2]]
输出：[7]
 

提示：

m == mat.length
n == mat[i].length
1 <= n, m <= 50
1 <= matrix[i][j] <= 10^5
矩阵中的所有元素都是不同的

 * 
 * @author Administrator
 *
 */
public class Pro5356 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<Integer> ret = new ArrayList<Integer>();
        for(int i = 0; i< rows; i++) {
            int rowMin = matrix[i][0];
            int colMinIndex = 0;
            //行最小
            for(int c = 1; c < cols; c++) {
                if(matrix[i][c] < rowMin) {
                    rowMin = matrix[i][c];
                    colMinIndex = c;
                }
            }
            //判断是不是列最大
            int r = 0;
            for(; r < rows; r++) {
                if(r!=i) {
                    if(matrix[r][colMinIndex] > rowMin) {
                        break;
                    }
                }
            }
            if(r == rows)
                ret.add(rowMin);
        }
        return ret;
    }
    
}
