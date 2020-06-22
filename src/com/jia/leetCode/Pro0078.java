package com.jia.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集
 * 
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subsets
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Administrator
 *
 */
public class Pro0078 {
	List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
    	if(nums == null || nums.length == 0) return ans;
    	LinkedList<Integer> track = new LinkedList<Integer>();
    	backtrack(nums, track, 0);
        return ans;
    }
    /**
     * 
     * @param nums  数组
     * @param stack 存放选择树路径
     * @param index 数组元素的下表
     */
	private void backtrack(int[] nums, LinkedList<Integer> track, int index) {
		//触发结束条件
		if(index == nums.length) {
			ans.add(new ArrayList<Integer>(track));
		}
		if(index < nums.length) {
			//做出选择
			//不选择
			//backtrack(nums, track, index+1);
			//选择
			track.add(nums[index]);
			backtrack(nums, track, index+1);
			//撤销选择
			track.removeLast();
		}
	}
}
