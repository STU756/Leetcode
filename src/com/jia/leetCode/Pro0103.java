package com.jia.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 * 
 * @author Jia
 * 
 */
public class Pro0103 {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
		List<Integer> l = null;
		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		LinkedList<TreeNode> q1 = new LinkedList<TreeNode>();
		LinkedList<TreeNode> q2 = new LinkedList<TreeNode>();
		
		if(root == null) return ll;
		TreeNode cur = root;
		q1.add(root);
		while(!q1.isEmpty()||!q2.isEmpty()) {
			l = new LinkedList<Integer>();
			while(!q1.isEmpty()) {
				cur = q1.pollFirst();
				if(cur.left!=null) q2.addLast(cur.left);
				if(cur.right!=null) q2.addLast(cur.right);
				l.add(cur.val);
			}
			while(!q2.isEmpty()) {
				cur = q2.pollLast();
				if(cur.right!=null) q1.addFirst(cur);
				if(cur.left !=null) q2.addFirst(cur);
				l.add(cur.val);
			}
			ll.add(l);
		}
		return ll;
	}
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        boolean isInOrder = true;
        TreeNode node = null;
        ArrayList<Integer> list = null;
        while(!queue.isEmpty()) {
        	int size = queue.size();
        	list = new ArrayList<Integer>();
        	while(size > 0) {
        		node = queue.pollFirst();
        		list.add(node.val);
        		if(node.left!=null)
        			queue.add(node.left);
        		if(node.right!=null)
        			queue.addLast(node.right);
                --size;
        	}
        	if(!isInOrder) {
        		Collections.reverse(list);
        		isInOrder = true;
        	}else {
        		isInOrder = false;
        	}
        	ans.add(list);
        }
        return ans;
    }
}
