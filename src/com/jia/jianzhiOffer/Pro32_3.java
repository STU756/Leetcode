package com.jia.jianzhiOffer;

import java.util.*;

/**
 * 32.3 按之字形顺序打印二叉树 题目描述 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * 
 * @author Administrator
 *
 */
public class Pro32_3 {
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		Queue<TreeNode> queue = new LinkedList<>();
		ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
		queue.add(pRoot);
		boolean reverse = false;
		while (!queue.isEmpty()) {
			int cnt = queue.size();
			ArrayList<Integer> list = new ArrayList<Integer>();
			while (cnt-- > 0) {
				TreeNode t = queue.poll();
				if (t == null) {
					continue;
				}
				list.add(t.val);
				queue.add(t.left);
				queue.add(t.right);
			}
			if (reverse) {
				Collections.reverse(list);
			}
			reverse = !reverse;
			if (list.size() != 0)
				ret.add(list);
		}
		return ret;
	}
	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> ans = new ArrayList<>();
		if(root == null) return ans;
		boolean isReverse = false;
		queue.add(root);
		while(!queue.isEmpty()) {
			int cnt = queue.size();
			List<Integer> list = new ArrayList<Integer>();
			while(cnt -- > 0) {
				TreeNode t = queue.poll();
				list.add(t.val);
				if(t.left!=null) queue.add(t.left);
				if(t.right!=null) queue.add(t.right);
			}
			if(isReverse) {
				Collections.reverse(list);
			}
			isReverse = !isReverse;
			ans.add(list);
		}
		return ans;
	}
}
