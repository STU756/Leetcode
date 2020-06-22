package com.jia.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Pro0113 {
    List<List<Integer>> ll = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<Integer> list = new ArrayList<Integer>();
    	help(root, sum, list);
    	return ll;
    }

	private void help(TreeNode root, int sum,List<Integer> list) {
		if(root==null) return;
		sum = sum - root.val;
		if(sum == 0 && root.left == null && root.right==null) {
			list.add(root.val);
			ll.add(list);
			return;
		}
		else{ 
			list.add(root.val);
			help(root.right, sum, new ArrayList<Integer>(list));
			help(root.left, sum, new ArrayList<Integer>(list));
		}

	}
}
