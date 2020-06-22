package com.jia.leetCode;
/**
 * 螺旋矩阵 II
 * 
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

示例:

输入: 3
输出:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/spiral-matrix-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Administrator
 *
 */
public class Pro0059 {
    public int[][] generateMatrix(int n) {
    	int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] ans = new int[n][n];
        int num = 1;
        while(num <= n*n) {
        	for(int i = l; i <= r; i++) ans[t][i] = num++;
        	++t;
        	for(int i = t; i <= b; i++) ans[i][r] = num++;
        	--r;
        	for(int i = r; i >= l; i--) ans[b][i] = num++;
        	--b;
        	for(int i = b; i >= t; i--) ans[i][l] = num++;
        	++l;
        }
        return ans;
    }
}
