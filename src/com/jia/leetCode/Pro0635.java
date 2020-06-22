package com.jia.leetCode;

public class Pro0635 {
    TreeNode treeRoot;
    public boolean findTarget(TreeNode root, int k) {
    	if(root == null) return false;
        treeRoot = root;
        return help(root, k);
    }
    private boolean help(TreeNode node, int k){
        if(node == null) return false;
        TreeNode temp = binaryTreeSearch(treeRoot, k - node.val);
        if(temp!= null && temp != node) {
            return true;
        }
    	return help(node.left, k) || help(node.right, k);
    }
    private TreeNode binaryTreeSearch(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) {
            return root;
        }else if(root.val > val) {
            return binaryTreeSearch(root.left, val);
        }else {
            return binaryTreeSearch(root.right, val);
        }
    }
}
