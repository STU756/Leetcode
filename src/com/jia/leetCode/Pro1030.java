package com.jia.leetCode;


/**
 * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。

另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。

返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）

 

示例 1：

输入：R = 1, C = 2, r0 = 0, c0 = 0
输出：[[0,0],[0,1]]
解释：从 (r0, c0) 到其他单元格的距离为：[0,1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/matrix-cells-in-distance-order
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *解決方法：插入排序
 */
public class Pro1030 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] ret = new int[R*C][2];
        int[] hLen = new int[R*C];
        int k  = 0;
        for(int i =0; i<R; i++) {
        	for(int j = 0; j<C; j++) {
        		int len = Math.abs(i+1 - r0) + Math.abs(j+1 - c0);
        		int h = k-1;
        		while(h >= 0 && hLen[h]>len) {
        			hLen[h+1] = hLen[h];
        			ret[h+1][0] = ret[h][0];
        			ret[h+1][1]	= ret[h][1];
        			--h;
        		}
        		hLen[h+1] = len;
        		ret[h+1][0] = i;
        		ret[h+1][1] = j;
        		++k;
        	}
        }
        return ret;
    }
}
