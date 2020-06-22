package com.jia.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 四数相加 II
 * 
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
	
	为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
	
	例如:
	
	输入:
	A = [ 1, 2]
	B = [-2,-1]
	C = [-1, 2]
	D = [ 0, 2]
	
	输出:
	2
	
	解释:
	两个元组如下:
	1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
	2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
	
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/4sum-ii
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * 
 * @author Administrator
 *
 */


public class Pro0454 {
	/**
	 * 哈希表H<A[i]+B[j],计数>。对 A[i]+B[j] 的值进行计数。

	计算t=C[u]+D[v]。如果H中有-t，那么， A[i]+B[j] + C[u]+D[v] == 0。

	 * 
	 * @param A
	 * @param B
	 * @param C
	 * @param D
	 * @return
	 */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    	int N = A.length;
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < N; j++) {
        		map.put(A[i]+B[j], map.getOrDefault(A[i]+B[j], 0) + 1);
        	}
        }
        int sum = 0;
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < N; j++) {
        		if(map.containsKey(-C[i] - D[j])) {
        			sum += map.get(-C[i] - D[j]);
        		}
        	}
        }
        return sum;
    }
}
