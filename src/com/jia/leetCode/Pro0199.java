package com.jia.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Pro0199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        LinkedList<TreeNode> listNode = new LinkedList<TreeNode>();
        if(root == null) return list;
        listNode.add(root);
        while(listNode.size()>0) {
        	int len = listNode.size();
        	TreeNode node = null;
            for(int i=0;i<len;i++) {
            	node = listNode.pollFirst();
            	if(node.left!=null) 
            		listNode.addLast(node.left);
            	if(node.right!=null)
            		listNode.addLast(node.right);
            }
            if(node!=null) {
            	list.add(node.val);
            }
        }
        return list;
    }
}
