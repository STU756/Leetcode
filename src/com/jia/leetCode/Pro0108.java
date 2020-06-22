package com.jia.leetCode;

public class Pro0108 {
	public TreeNode sortedArrayTOBST(int[] nums) {
		return build(nums, 0, nums.length - 1);
	}

	private TreeNode build(int[] nums, int st, int ed) {
		if(st > ed) return null;
		int mid = ed - (ed - st) / 2;
		TreeNode r = new TreeNode(nums[mid]);
		r.left = build(nums, st, mid - 1);
		r.right = build(nums, mid + 1, ed);
		return r;
	}
}
