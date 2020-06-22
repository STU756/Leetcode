package com.jia.leetCode;

import java.util.LinkedList;
import java.util.List;

public class Test {
	List<List<Integer>> ans = new LinkedList<>();
	List<List<Integer>> permute(int[] nums) {
		//记录路径
		LinkedList<Integer> track = new LinkedList<Integer>();
		backtrack(nums, track);
		return ans;
	}
	private void backtrack(int[] nums, LinkedList<Integer> track) {
		if(track.size() == nums.length) {
			ans.add(new LinkedList<Integer>(track));
		}
		for(int i = 0; i < nums.length; i++) {
			//排除不合法的选择
			if(track.contains(nums[i]))
				continue;
			//做选择
			track.add(nums[i]);
			//进入下一层决策树
			backtrack(nums, track);
			//撤销选择
			track.removeLast();
		}
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		int[] nums = {1,2,3,4,5};
		List<List<Integer>> permute = test.permute(nums);
		for (List<Integer> list : permute) {
			System.out.println(list);
		}
	}
}
