package com.jia.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Pro0104 {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        //if(root.left == null || root.right == null)
        	//return (root.left == null && root.right == null)? 1 : (root.left==null)? maxDepth(root.right) + 1 : maxDepth(root.left) + 1;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
