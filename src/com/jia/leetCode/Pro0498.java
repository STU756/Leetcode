package com.jia.leetCode;
/**
 * 对角线遍历
 * 
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。

 

示例:

输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

输出:  [1,2,4,7,5,3,6,8,9]

解释:

 

说明:

给定矩阵中的元素总数不会超过 100000 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/diagonal-traverse
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Administrator
 *
 */
public class Pro0498 {
	public int[] findDiagonalOrder(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return new int[0];
		int iNum = matrix.length; // row len
		int jNum = matrix[0].length; // column len
		int i = 0, j = 0;
		boolean isUp = true;
		int[] ans = new int[iNum * jNum];
		int resultIndex = 0;
		while(i < iNum && j<jNum) {
			if(isUp) {
				while(i>=0 && i<iNum && j>= 0 && j < jNum) {
					//遍历上升所有数
					ans[resultIndex++] = matrix[i--][j++];
				}
				//还原i和j下表
				++i;--j;
				if(j+1 < jNum) {  //j没有超出边界
					++j;
				}else { //j超出边界
					++i;
				}
				isUp = false;
			}else {
				while(i>=0 && i<iNum && j>= 0 && j < jNum) {
					//遍历下降所有数
					ans[resultIndex++] = matrix[i++][j--];
				}
				//还原下表i和j
				--i; ++j;
				if(i+1 < iNum) {
					++i;
				}else {
					++j;
				}
				isUp = true;
			}
		}
		return ans;
	}
}
