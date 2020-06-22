package com.jia.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Pro0116 {
/*	public void connect(TreeLinkNode root) {
	    connectHelper(root, null);
	}
	private void connectHelper(TreeLinkNode root, TreeLinkNode sibling){
	    if(root == null)  
	        return;
	    else 
	        root.next = sibling;

	    connectHelper(root.left,root.right);
	    if(sibling != null){
	        connectHelper(root.right,sibling.left); 
	        connectHelper(sibling.left,sibling.right); 
	    }
	}*/
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }

        TreeLinkNode curHead = root;
        TreeLinkNode nextLevelHead = curHead.left;
        while(nextLevelHead != null) {
            TreeLinkNode nextLevelTail = nextLevelHead;
            //deal with current level
            while(curHead != null) {
                curHead.left.next = curHead.right;
                nextLevelTail = curHead.right;
                curHead = curHead.next;
                if(curHead != null) {
                    nextLevelTail.next = curHead.left;
                }
            }//end this level
            curHead = nextLevelHead;
            nextLevelHead = curHead.left;
        }

    }
	 class TreeLinkNode {
	      TreeLinkNode left;
	      TreeLinkNode right;
	      TreeLinkNode next;
	    }
}
