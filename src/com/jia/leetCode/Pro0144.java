package com.jia.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树前序遍历
 * 
 * @author Administrator
 *
 */
public class Pro0144 {
	List<Integer> ans = new ArrayList<Integer>();
	public List<Integer> preorderTraversal2(TreeNode root){
		if(root!=null) {
			ans.add(root.val);
			preorderTraversal2(root.left);
			preorderTraversal2(root.right);
		}
		return ans;
	}
	public List<Integer> preorderTraversal(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if(node != null) {
				ans.add(node.val);
				stack.push(node.right);
				stack.push(node.left);
			}
		}
		return ans;
	}
}
