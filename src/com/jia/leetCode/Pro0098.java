package com.jia.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Validate Binary Search Tree
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 * @author Jia
 *
 */
public class Pro0098 {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	public boolean isValidBST(TreeNode root) {
		if(root == null) {
			return true;
		}
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	private boolean isValidBST(TreeNode root, long min, long max) {
		if(root == null) {
			return true;
		}
		if(root.val < min || root.val > max) {
			return false;
		}
		return isValidBST(root.left, min, (long)root.val) && isValidBST(root.right, (long)root.val, max);
	}
}
