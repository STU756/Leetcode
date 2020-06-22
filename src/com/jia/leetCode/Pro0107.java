package com.jia.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Pro0107 {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		LinkedList<List<Integer>> ll = new LinkedList<List<Integer>>();
		List<Integer> l;
		LinkedList<TreeNode> linkedList = new LinkedList<TreeNode>();
		if (root == null)
			return ll;
		TreeNode current = root;
		int parentSize = 1, childSize = 0;
		linkedList.push(current);
		l = new ArrayList<Integer>();
		while (!linkedList.isEmpty()) {
			current = linkedList.pollLast();
			parentSize--;
			if (current.left != null) {
				linkedList.push(current.left);
				childSize++;
			}
			if (current.right != null) {
				linkedList.push(current.right);
				childSize++;
			}
			l.add(current.val);
			if (parentSize == 0) {
				ll.addFirst(l);
				parentSize = childSize;
				childSize = 0;
				l = new ArrayList<Integer>();
			}
		}
		return ll;
	}

}
