package com.jia.leetCode;

import java.util.List;

/**
 * 

307. 区域和检索 - 数组可修改

给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。

update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。

示例:

Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
说明:

数组仅可以在 update 函数下进行修改。
你可以假设 update 函数与 sumRange 函数的调用次数是均匀分布的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/range-sum-query-mutable
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 * 线段树
 * @author Administrator
 *
 */
public class Pro0370 {
	
	class TreeNode{
		int st;
		int ed;
		int sum;
		public TreeNode() {
			st = -1;
			ed = 1;
			sum = 0;
		}
	}
	
	List<TreeNode> tlist;
	List<Integer> index;
	//底层节点个数不超过n，二叉树高度总结点个数不超过2^h - 1;完全二叉树
    public Pro0370(int[] nums) {
    	
    }
    
    public void update(int i, int val) {
    }
    
    public int sumRange(int i, int j) {
    	return 0;
    }
}
