package com.jia.leetCode;
/**
 * 311. 稀疏矩阵的乘法
 * 
 * 
 * 给定两个 稀疏矩阵 A 和 B，请你返回 AB。你可以默认 A 的列数等于 B 的行数。

请仔细阅读下面的示例。

示例：

输入:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]

输出:

     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sparse-matrix-multiplication
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * @author Administrator
 *
 */
public class Pro0311 {
	public int[][] multiply(int[][] A, int[][] B) {
		int[][] ans = new int[A.length][B[0].length];
		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < B[0].length; j++) {
				for(int t = 0; t < B.length; t++) {
					ans[i][j] += (A[i][t] * B[t][j]);
				}
			}
		}
		return ans;
	}
}
