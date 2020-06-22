package com.jia.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Pro0101 {
	public boolean isSymmetric(TreeNode root) {
		return (root == null) || (isSymmetric(root.left, root.right));
	}

	private boolean isSymmetric(TreeNode left, TreeNode right) {
		return (left == null) && (right == null) || (left != null)
				&& (right != null) && (left.val == right.val)
				&& isSymmetric(left.left, right.right)
				&& isSymmetric(left.right, right.left);
	}
}
