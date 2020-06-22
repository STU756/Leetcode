package com.jia.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Pro0102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> ll = new ArrayList<List<Integer>>();
    	List<Integer> l;
        LinkedList<TreeNode> linkedList = new LinkedList<TreeNode>();
        if(root == null)	 return ll;
        TreeNode current = root;
        int parentSize = 1, childSize = 0;
        linkedList.push(current);
        l = new ArrayList<Integer>();
        while(!linkedList.isEmpty()) {
        	current = linkedList.pollLast();
        	parentSize--;
        	if(current.left!= null) {linkedList.push(current.left);childSize++;}
        	if(current.right!= null) {linkedList.push(current.right); childSize ++;}
        	l.add(current.val);
        	if(parentSize == 0) {
        		ll.add(l);
        		parentSize = childSize;
        		childSize = 0;
        		l = new ArrayList<Integer>();
        	}
        }
        return ll;
    }	
	
}
