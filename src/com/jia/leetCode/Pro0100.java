package com.jia.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Pro0100 {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null || q == null) {
			return (p == null) && (q == null);
		} else {
			if (p.val != q.val)
				return false;
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
	}

}
