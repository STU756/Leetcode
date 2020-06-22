package com.jia.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 * 
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combinations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Administrator
 *
 */
public class Pro0077 {
	List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
         List<Integer> list = new ArrayList<>();
         backtrack(1,n, k, list);
         return ans;
    }
	private void backtrack(int index, int n, int k, List<Integer> list) {
		if(list.size() == k) {
			ans.add(new ArrayList<Integer>(list));
		}
		for(int i = index; i<= n; i++) {
			if(list.contains(i))
				continue;
			//选取
			list.add(i);
			//进入决策树下一层
			backtrack(i+1,n, k, list);
			//撤销
			list.remove(list.size()-1);
		}
	}
}
